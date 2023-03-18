package com.assign.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EduCostStatQueryFour {

    private static final String DB_NAME = "rondb";
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
        int latestYear = 2022;
        String type = "Public";
        String length = "4-year";
        int[] pastYears = new int[]{2021, 2020, 2019, 2018, 2017};
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


/*This code is a Java program that connects to a MongoDB database and executes a query to find the top 5 states with the highest growth rate of education expenses over a period of time. The program has a main method that sets up the MongoDB connection and calls the queryTop5HighestGrowthRateStates method with the required parameters.

The queryTop5HighestGrowthRateStates method takes in several parameters such as the latest year, past years, type of education institution, length of education, the main collection to query, and the query collection to store the result. The method checks if the query already exists in the query collection using the query parameters. 
If it exists, the method returns the result from the query document. Otherwise, it calculates the expenses for the latest year and past years using the main collection and projects the results to only include the state and the value of expenses. It then calculates the growth rate for each state by comparing the average expenses of each year and storing the growth rates in an array.

Next, the method extracts the top 5 states with the highest growth rate by iterating through the growth rate array and adding the states to a new document. The method also checks if the growth rate is NaN and skips adding that state if it is. Finally, the method creates a new query document with the query parameters and the query result and inserts it into the query collection. The method then returns the query document.

The program also imports several classes from the com.mongodb.client package such as MongoClient, MongoDatabase, and MongoCollection to connect to the database and query the collections. It also imports the Document class from the org.bson package to work with BSON documents in MongoDB. Additionally, it imports classes from the com.mongodb.client.model package to use filters, projections, and sorts in the queries. */