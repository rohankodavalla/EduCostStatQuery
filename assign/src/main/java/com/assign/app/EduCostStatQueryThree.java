package com.assign.app;


/*To query the top 5 most economic states (with overall expense) given a year, type, and length, and save the query as a document 
in a collection named EduCostStatQueryThree, you can use the following Java code in a MongoDB Java application:


This code will connect to the MongoDB server using the specified connection string, retrieve the specified database 
and collection, execute the aggregation query to find the top 5 most economic states with overall expense given the year, 
type, and length, and save the query result as a document in a new collection named EduCostStatQueryThree in the same database.



MongoClient mongoClient = MongoClients.create("<connection_string>");

MongoDatabase database = mongoClient.getDatabase("<database_name>");
MongoCollection<Document> collection = database.getCollection("<collection_name>");

int year = 2013;
String type = "Private";
String length = "4-year";

Document queryResult = collection.aggregate(Arrays.asList(
        Aggregates.match(
                Filters.and(
                        Filters.eq("Year", year),
                        Filters.eq("Type", type),
                        Filters.eq("Length", length)
                )
        ),
        Aggregates.group(
                "$State",
                Accumulators.sum("totalExpense", "$Value")
        ),
        Aggregates.sort(
                new Document("totalExpense", 1)
        ),
        Aggregates.limit(5)
)).into(new Document());

MongoCollection<Document> queryCollection = database.getCollection("EduCostStatQueryThree");
queryCollection.insertOne(queryResult); */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EduCostStatQueryThree {

    public static void main(String[] args) {

        int year = 2013;
        String type = "Private";
        String length = "4-year";

        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("EduCostStat");

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




MongoCollection<Document> resultCollection = database.getCollection("EduCostStatQueryThree");
resultCollection.insertMany(queryResult);
    }
}

/*This is a Java program that performs a query on a MongoDB database using the aggregation pipeline. Specifically, it queries the "EduCostStat" collection to find the top 5 most economical states based on education expenses for a given year, type, and length.

The program first defines the values for the year, type, and length that it wants to query. It then creates a MongoDB client and connects to a database named "test" on the MongoDB Atlas cloud service. It selects the "EduCostStat" collection from the database and uses the aggregation pipeline to perform the query.

The aggregation pipeline consists of several stages, each defined using the Aggregates class from the MongoDB Java driver. The first stage uses the Filters class to match documents in the collection that have the specified year, type, and length. The second stage groups the matching documents by state and calculates the total expense for each state using the Accumulators class. The third stage sorts the resulting documents in ascending order of total expense. The fourth and final stage limits the output to the top 5 documents.

The program then saves the query result as a list of documents and inserts it into a new collection named "EduCostStatQueryThree" in the same MongoDB database. */