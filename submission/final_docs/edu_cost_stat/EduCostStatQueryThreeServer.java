

public class EduCostStatQueryThreeServiceImpl extends EduCostStatQueryThreeServiceGrpc.EduCostStatQueryThreeServiceImplBase {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryThree";
  
    @Override
    public void queryTop5CheapestStates(QueryTop5CheapestStatesRequest request, StreamObserver<QueryTop5CheapestStatesResponse> responseObserver) {
      // Set up MongoDB connection
      MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
      MongoDatabase database = mongoClient.getDatabase(DB_NAME);
      MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
      MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);
  
      // Call the query method
      int year = request.getYear();
      String type = request.getType();
      String length = request.getLength();
      Document queryResult = queryTop5CheapestStates(year, type, length, collection, queryCollection);
  
      // Convert the query result to the response message
      QueryTop5CheapestStatesResponse.Builder responseBuilder = QueryTop5CheapestStatesResponse.newBuilder();
      for (Object o : queryResult) {
        Document doc = (Document) o;
        String state = doc.getString("_id");
        double totalExpense = doc.getDouble("totalExpense");
        QueryResult queryResultMsg = QueryResult.newBuilder()
                .setState(state)
                .setTotalExpense(totalExpense)
                .build();
        responseBuilder.addQueryResult(queryResultMsg);
      }
  
      // Send the response message to the client
      QueryTop5CheapestStatesResponse response = responseBuilder.build();
      responseObserver.onNext(response);
      responseObserver.onCompleted();
  
      // Close MongoDB connection
      mongoClient.close();
    }
  
    public static Document queryTop5CheapestStates(int year, String type, String length, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
      // Check if the query already exists in the query collection
      Document queryDoc = queryCollection.find(Filters.and(
              Filters.eq("year", year),
              Filters.eq("type", type),
              Filters.eq("length", length)
      )).first();
      if (queryDoc != null) {
  // If the query result already exists, return it
  return queryDoc.get("result", Document.class);
  } else {
  // If the query result doesn't exist, perform the query
  List<Document> queryResult = (List<Document>) collection.aggregate(Arrays.asList(
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
  new Document("totalExpense", 1)
  ),
  Aggregates.limit(5)
  )).into(new ArrayList<Document>());
  
    // Insert the query result into the query collection
    Document queryResultDoc = new Document("year", year)
            .append("type", type)
            .append("length", length)
            .append("result", queryResult);
    queryCollection.insertOne(queryResultDoc);
  
    // Return the query result
    return queryResultDoc.get("result", Document.class);
  }
  }
  }
  