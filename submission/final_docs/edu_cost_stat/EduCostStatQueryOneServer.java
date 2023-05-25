public class EduCostStatQueryOneServer {
    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryOne";

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new EduCostStatQueryOneServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }

    private static class EduCostStatQueryOneServiceImpl extends EduCostStatQueryOneServiceGrpc.EduCostStatQueryOneServiceImplBase implements BindableService {
        private final MongoClient mongoClient;
        private final MongoDatabase database;
        private final MongoCollection<Document> collection;
        private final MongoCollection<Document> queryCollection;

        public EduCostStatQueryOneServiceImpl() {
            // Set up MongoDB connection
            mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
            database = mongoClient.getDatabase(DB_NAME); 
            collection = database.getCollection(COLLECTION_NAME);
            queryCollection = database.getCollection(QUERY_COLLECTION_NAME);
        }

        @Override
        public void queryCost(QueryRequest request, StreamObserver<QueryResponse> responseObserver) {
            // Check if the query already exists in the query collection
            Document queryDoc = queryCollection.find(Filters.and(
                    Filters.eq("year", request.getYear()),
                    Filters.eq("state", request.getState()),
                    Filters.eq("type", request.getType()),
                    Filters.eq("length", request.getLength()),
                    Filters.eq("expense", request.getExpense())
            )).first();
            if (queryDoc != null) {
                QueryResponse response = QueryResponse.newBuilder()
                        .setYear(request.getYear())
                        .setState(request.getState())
                        .setType(request.getType())
                        .setLength(request.getLength())
                        .setExpense(request.getExpense())
                        .setCost(queryDoc.getDouble(request.getExpense()))
                        .build();
                        responseObserver.onNext(response);
                        responseObserver.onCompleted();
                        return;
        }
                    // Query the cost from the EduCostStat collection
        Document costDoc = collection.find(Filters.and(
                Filters.eq("year", request.getYear()),
                Filters.eq("state", request.getState()),
                Filters.eq("type", request.getType()),
                Filters.eq("length", request.getLength())
        )).first();

        // Create a new query document with the query parameters and the query result
        Document queryResult = new Document()
                .append("year", request.getYear())
                .append("state", request.getState())
                .append("type", request.getType())
                .append("length", request.getLength())
                .append("expense", request.getExpense())
                .append("cost", costDoc.getDouble(request.getExpense()));

        // Insert the new query document into the query collection
        queryCollection.insertOne(queryResult);

        // Create and send the response
        QueryResponse response = QueryResponse.newBuilder()
                .setYear(request.getYear())
                .setState(request.getState())
                .setType(request.getType())
                .setLength(request.getLength())
                .setExpense(request.getExpense())
                .setCost(queryResult.getDouble(request.getExpense()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

        @Override
        public ServerServiceDefinition bindService() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'bindService'");
        }
}
}