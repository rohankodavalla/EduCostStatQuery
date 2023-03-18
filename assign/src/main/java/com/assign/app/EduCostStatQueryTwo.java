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

    private static final String DB_NAME = "rondb";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryTwo";

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = 2018;
        String type = "Private";
        String length = "2-year";
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


/*This is a Java program that queries data from a MongoDB database and returns the top 5 most expensive states for a given year, type, and length of education program. The program uses the MongoDB Java driver to connect to the database and execute the query.

Here's a brief overview of the program's structure and function:

The program starts by importing several classes from the MongoDB Java driver and the standard Java library.

The program defines three constants: DB_NAME, COLLECTION_NAME, and QUERY_COLLECTION_NAME, which are used to specify the names of the database, collection, and query collection in the MongoDB database.

The main() method sets up a connection to the MongoDB database, retrieves the specified collection and query collection, and calls the queryTop5ExpensiveStates() method to execute the query.

The queryTop5ExpensiveStates() method first checks if the query has already been executed and saved in the query collection. If so, it returns the saved query result.

If the query has not been executed before, the method executes the query using the aggregate() method of the collection object. The query filters the data by year, type, and length, groups the data by state, calculates the total expense for each state, sorts the results in descending order of total expense, and limits the results to the top 5.

The query result is stored in a List<Object> object, which is then used to create a new query document that includes the query parameters and result.

The new query document is inserted into the query collection, and the method returns the document.

Finally, the main() method closes the MongoDB connection.

Overall, this program demonstrates how to use the MongoDB Java driver to query data from a MongoDB database and how to insert and retrieve documents from a MongoDB collection. */


/*db.colleges.aggregate([
  {
    $match: {
      Year: 2013,
      Type: "Private",
      Length: "4-year"
    }
  },
  {
    $group: {
      _id: "$State",
      totalExpense: { $sum: "$Value" }
    }
  },
  {
    $lookup: {
      from: "states",
      localField: "_id",
      foreignField: "state",
      as: "state_info"
    }
  },
  {
    $project: {
      _id: 0,
      State: "$_id",
      totalExpense: 1,
      Region: { $arrayElemAt: ["$state_info.region", 0] }
    }
  },
  {
    $sort: {
      totalExpense: -1
    }
  },
  {
    $limit: 5
  },
   { $out: "EduCostStatQueryTwo" }
])
 */