public class EduCostStatQueryFourImpl extends EduCostStatQueryFourServiceGrpc.EduCostStatQueryFourServiceImplBase {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryFour";

    @Override
    public void queryTop5HighestGrowthRateStates(EduCostStatQueryFourRequest request, StreamObserver<EduCostStatQueryFourResponse> responseObserver) {
        int latestYear = request.getLatestYear();
        String type = request.getType();
        String length = request.getLength();
        int[] pastYears = request.getPastYearsList().toArray();

        // Set up MongoDB connection
        MongoCollection<Document> collection = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority")
                .getDatabase(DB_NAME)
                .getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = collection.getDatabase().getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        Document queryResult = queryTop5HighestGrowthRateStates(latestYear, pastYears, type, length, collection, queryCollection);

        // Create the response message
        EduCostStatQueryFourResponse.Builder responseBuilder = EduCostStatQueryFourResponse.newBuilder();
        List<Document> resultDocs = (List<Document>) queryResult.get("result");
        for (Document resultDoc : resultDocs) {
            EduCostStatQueryFourResult.Builder resultBuilder = EduCostStatQueryFourResult.newBuilder();
            resultBuilder.setState(resultDoc.getString("state"));
            resultBuilder.setGrowthRate(resultDoc.getDouble("growth_rate"));
            responseBuilder.addResult(resultBuilder.build());
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    private Document queryTop5HighestGrowthRateStates(int latestYear, int[] pastYears, String type, String length, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
        String[] expenditureFields = {"instruction_expense", "support_services_expense", "other_expenses", "capital_outlay_expense"};
        String[] revenueFields = {"federal_revenue", "state_revenue", "local_revenue"};
        List<String> fields = new ArrayList<>();
        fields.add("state");

        // Build the projection document based on the query parameters
        for (int pastYear : pastYears) {
            if (pastYear >= latestYear - 5) {
                fields.addAll(Arrays.asList(expenditureFields));
            }
            if (pastYear >= latestYear - 4) {
                fields.addAll(Arrays.asList(revenueFields));
            }
        }
        fields.add("enrollment");

        // Aggregate the data
        List<Document> pipeline = new ArrayList<>();
        pipeline.add(Aggregates.match(Filters.eq("year", latestYear)));
        pipeline.add(Aggregates.project(Projections.include(fields)));
        pipeline.add(Aggregates.sort(Sorts.descending("enrollment")));
        Document groupFields = new Document("_id", "$state");
        groupFields.append("latest_year_data", new Document("$first", "$$ROOT"));
        for (int pastYear : pastYears) {
        String expenditureField = null;
        String revenueField = null;
        if (pastYear >= latestYear - 5) {
        expenditureField = "expenditure_" + (latestYear - pastYear);
        groupFields.append(expenditureField, new Document("$sum", "$instruction_expense"));
        groupFields.append(expenditureField, new Document("$sum", "$support_services_expense"));
        groupFields.append(expenditureField, new Document("$sum", "$other_expenses"));
        groupFields.append(expenditureField, new Document("$sum", "$capital_outlay_expense"));
        }
        if (pastYear >= latestYear - 4) {
        revenueField = "revenue_" + (latestYear - pastYear);
        groupFields.append(revenueField, new Document("$sum", "$federal_revenue"));
        groupFields.append(revenueField, new Document("$sum", "$state_revenue"));
        groupFields.append(revenueField, new Document("$sum", "$local_revenue"));
        }
        }
        pipeline.add(Aggregates.group(groupFields));
        pipeline.add(Aggregates.project(Projections.excludeId()));
        pipeline.add(Aggregates.project(Projections.include("state", "latest_year_data", "growth_rate")));
        pipeline.add(Aggregates.sort(Sorts.descending("growth_rate")));
        pipeline.add(Aggregates.limit(5));
    // Execute the query and store the results in a separate collection for future use
    Document queryResult = queryCollection.find(Filters.eq("latestYear", latestYear))
            .filter(Filters.eq("pastYears", Arrays.asList(pastYears)))
            .filter(Filters.eq("type", type))
            .filter(Filters.eq("length", length))
            .first();
    if (queryResult == null) {
        queryResult = collection.aggregate(pipeline).first();
        queryResult.append("latestYear", latestYear);
        queryResult.append("pastYears", Arrays.asList(pastYears));
        queryResult.append("type", type);
        queryResult.append("length", length);
        queryCollection.insertOne(queryResult);
    }
    return queryResult;
}
}