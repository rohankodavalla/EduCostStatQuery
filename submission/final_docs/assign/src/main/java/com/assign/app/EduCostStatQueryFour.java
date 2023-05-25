package com.assign.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EduCostStatQueryFour {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryFour";
    private static final Object startYear = null;
    private static final Object endYear = null;

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int latestYear = 2021;
        String type = "Public";
        String length = "4-year";
        int[] pastYears = new int[]{2020, 2019, 2018, 2017};
        Document queryResult = queryTop5HighestGrowthRateStates(latestYear, pastYears, type, length, collection, queryCollection);

        // Print the query result
        System.out.println(queryResult.toJson());

        // Close MongoDB connection
        mongoClient.close();
    }

    public static Document queryTop5HighestGrowthRateStates(int latestYear, int[] pastYears, String type, String length, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
        // Check if the query already exists in the query collection
        Document queryDoc = queryCollection.find(Filters.and(
                Filters.eq("latestYear", latestYear),
                Filters.eq("pastYears", Arrays.toString(pastYears)),
                Filters.eq("type", type),
                Filters.eq("length", length)
        )).first();
        if (queryDoc != null) {
            return queryDoc;
        }

        // Calculate the expenses for the latest year and past years
        List<Document> expenses = new ArrayList<>();
        for (int i = 0; i < pastYears.length; i++) {
            int year = pastYears[i];
            Document expense = collection.find(Filters.and(
                    Filters.eq("year", year),
                    Filters.eq("type", type),
                    Filters.eq("length", length)
            )).projection(Projections.fields(Projections.excludeId(), Projections.include("state"), Projections.include("Value"))).first();
            if (expense != null) {
                expenses.add(expense);
            }
        }
        Document latestExpense = collection.find(Filters.and(
                Filters.eq("year", latestYear),
                Filters.eq("type", type),
                Filters.eq("length", length)
        )).projection(Projections.fields(Projections.excludeId(), Projections.include("state"), Projections.include("Value"))).first();
        if (latestExpense != null) {
            expenses.add(latestExpense);
        }

        // Calculate the growth rate for each state
        List<Double> growthRates = new ArrayList<>();
        List<Document> growthRateResult = new ArrayList<>();
        for (int i = 0; i < growthRateResult.size(); i++) {
            Document stateDoc = (Document) growthRateResult.get(i);
            String state = stateDoc.getString("_id");
            Double avgExpense = stateDoc.getDouble("avgExpense");
            Double prevAvgExpense = 0.0;
            if (i > 0) {
                prevAvgExpense = ((Document) growthRateResult.get(i - 1)).getDouble("avgExpense");
            }
            Double growthRate = ((avgExpense - prevAvgExpense) / prevAvgExpense) * 100;
            growthRates.add(growthRate);
        }

            // Get the top 5 states with the highest growth rate
    List<Document> top5GrowthStates = new ArrayList<>();
    for (int i = 0; i < growthRates.size(); i++) {
        Double growthRate = growthRates.get(i);
        if (Double.isNaN(growthRate)) {
            continue;
        }
        String state = ((Document) growthRateResult.get(i)).getString("_id");
        Document doc = new Document("state", state)
                .append("growthRate", growthRate);
        top5GrowthStates.add(doc);
        if (top5GrowthStates.size() == 5) {
            break;
        }
    }

    // Create a new query document with the query parameters and the query result
    Document queryDocToInsert = new Document()
            .append("startYear", startYear)
            .append("endYear", endYear)
            .append("type", type)
            .append("length", length)
            .append("result", top5GrowthStates);

    // Insert the query document into the query collection
    queryCollection.insertOne(queryDocToInsert);

    return queryDocToInsert;
}
}

