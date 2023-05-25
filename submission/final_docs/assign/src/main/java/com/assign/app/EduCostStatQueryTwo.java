package com.assign.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EduCostStatQueryTwo {

    private static final String DB_NAME = "test";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryTwo";

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = 2013;
        String type = "Private";
        String length = "4-year";
        Document queryResult = queryTop5ExpensiveStates(year, type, length, collection, queryCollection);

        // Print the query result
        System.out.println(queryResult.toJson());

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

