
public class EduCostStatQueryTwoServiceImpl extends EduCostStatQueryTwoServiceGrpc.EduCostStatQueryTwoServiceImplBase {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryTwo";

    @Override
    public void queryTop5ExpensiveStates(QueryTop5ExpensiveStatesRequest request, StreamObserver<QueryTop5ExpensiveStatesResponse> responseObserver) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = request.getYear();
        String type = request.getType();
        String length = request.getLength();
        Document queryResult = queryTop5ExpensiveStates(year, type, length, collection, queryCollection);

        // Convert the query result to the response message
        QueryTop5ExpensiveStatesResponse.Builder responseBuilder = QueryTop5ExpensiveStatesResponse.newBuilder();
        for (Object o : queryResult) {
            Document doc = (Document) o;
            String state = doc.getString("_id");
            double totalExpense = doc.getDouble("totalExpense");
            QueryTop5ExpensiveStatesResponse.QueryResult queryResultMsg = QueryTop5ExpensiveStatesResponse.QueryResult.newBuilder()
                    .setState(state)
                    .setTotalExpense(totalExpense)
                    .build();
            responseBuilder.addQueryResult(queryResultMsg);
        }

        // Send the response message to the client
        QueryTop5ExpensiveStatesResponse response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        // Close MongoDB connection
        mongoClient.close();
    }

    public static Document queryTop5ExpensiveStates(int year, String type, String length, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
// Check if the query already exists in the query collection
Document queryDoc = queryCollection.find(Filters.and(
Filters.eq("year", year),
Filters.eq("type", type),
Filters.eq("length", length)
)).first();
if (queryDoc != null) {
return queryDoc;
}
    // Query the top 5 most expensive states
    List<Object> queryResult = collection.aggregate(Arrays.asList(
        Aggregates.match(
                Filters.and(
                        Filters.eq("year", year),
                        Filters.eq("type", type),
                        Filters.eq("length", length)
                )
        ),
        Aggregates.group(
                "$state",
                Accumulators.sum("totalExpense", "$Value")
        ),
        Aggregates.sort(
                new Document("totalExpense", -1)
        ),
        Aggregates.limit(5)
)).into(new ArrayList<>());

    // Create a new query document with the query parameters and the query result
    Document queryDocToInsert = new Document()
            .append("year", year)
            .append("type", type)
            .append("length", length)
            .append("result", queryResult);

    // Insert the query document into the query collection
    queryCollection.insertOne(queryDocToInsert);

    return queryDocToInsert;
}
}
