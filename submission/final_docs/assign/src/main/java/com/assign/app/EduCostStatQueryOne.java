package com.assign.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


public class EduCostStatQueryOne {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryOne";

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME); 
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = 2013;
        String state = "Alabama";
        String type = "Private";
        String length = "4-year";
        String expense = "Fees/Tuition";
        Document queryResult = queryCost(year, state, type, length, expense, collection, queryCollection);

        // Print the query result
        System.out.println(queryResult.toJson());

        // Close MongoDB connection
        mongoClient.close();
    }

    public static Document queryCost(int year, String state, String type, String length, String expense, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
        // Check if the query already exists in the query collection
        Document queryDoc = queryCollection.find(Filters.and(
                Filters.eq("year", year),
                Filters.eq("state", state),
                Filters.eq("type", type),
                Filters.eq("length", length),
                Filters.eq("expense", expense)
        )).first();
        if (queryDoc != null) {
            return queryDoc;
        }

        // Query the cost from the EduCostStat collection
        Document costDoc = collection.find(Filters.and(
                Filters.eq("year", year),
                Filters.eq("state", state),
                Filters.eq("type", type),
                Filters.eq("length", length)
        )).first();

        // Create a new query document with the query parameters and the query result
        Document queryResult = new Document()
                .append("year", year)
                .append("state", state)
                .append("type", type)
                .append("length", length)
                .append("expense", expense)
                .append("cost", costDoc.getDouble(expense));
        
                // Insert the new query document into the query collection
                queryCollection.insertOne(queryResult);

    return queryResult;
    }
} 


