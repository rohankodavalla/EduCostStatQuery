package com.assign.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


public class EduCostStatQueryOne {

    private static final String DB_NAME = "rondb";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryOne";

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME); 
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = 2018;
        String state = "California";
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


/*This Java code queries the education cost of a specific expense category in a given year, state, type, and length of education. The code connects to a MongoDB Atlas database and retrieves data from a collection named "EduCostStat".

The program defines a class called "EduCostStatQueryOne" with a "main" method. In the main method, the code establishes a connection to the MongoDB Atlas database, creates references to the "EduCostStat" collection and a new collection called "EduCostStatQueryOne" to store the query results.

Then the code calls a method "queryCost" which accepts the input parameters of year, state, type, length, expense, and references to the "EduCostStat" collection and "EduCostStatQueryOne" collection. The method checks if the query already exists in the "EduCostStatQueryOne" collection, and if so, returns the existing result document. If not, the method queries the cost of the specified expense category using the given input parameters from the "EduCostStat" collection, and creates a new document that contains the input parameters and the cost result. Finally, the method inserts the new document into the "EduCostStatQueryOne" collection.

In the main method, the code calls the "queryCost" method with the input parameters and retrieves the resulting document. The program prints the JSON representation of the resulting document to the console and then closes the MongoDB connection. */


/*db.collection.find({
  "Year": 2013,
  "State": "Alabama",
  "Type": "Private",
  "Length": "4-year",
  "Expense": "Fees/Tuition",
  "Value": 13983
})
 */