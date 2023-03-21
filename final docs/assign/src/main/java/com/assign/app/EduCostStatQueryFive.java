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
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EduCostStatQueryFive {

    private static final String DB_NAME = "rondb";
    private static final String COLLECTION_NAME = "EduCostStat";
    private static final String QUERY_COLLECTION_NAME = "EduCostStatQueryFive";
    private static final Object startYear = null;
    private static final Object endYear = null;

    public static void main(String[] args) {
        // Set up MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
        MongoCollection<Document> queryCollection = database.getCollection(QUERY_COLLECTION_NAME);

        // Call the query method
        int year = 2019;
        String type = "Public In-State";
        String length = "4-year";
        String[] regions = new String[]{"Northeast", "Southeast", "Midwest", "Southwest", "West"};
        Document queryResult = queryRegionAverageExpense(year, type, length, regions, collection, queryCollection);

        // Print the query result
        System.out.println(queryResult.toJson());

        // Close MongoDB connection
        mongoClient.close();
    }

    public static Document queryRegionAverageExpense(int year, String type, String length, String[] regions, MongoCollection<Document> collection, MongoCollection<Document> queryCollection) {
        // Check if the query already exists in the query collection
        Document queryDoc = queryCollection.find(Filters.and(
                Filters.eq("year", year),
                Filters.eq("type", type),
                Filters.eq("length", length),
                Filters.eq("regions", Arrays.toString(regions))
        )).first();
        if (queryDoc != null) {
            return queryDoc;
        }

        // Aggregate the region's average overall expense for the given year, type, and length
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(Aggregates.match(Filters.and(
                Filters.eq("year", year),
                Filters.eq("type", type),
                Filters.eq("length", length),
                Filters.in("region", Arrays.asList(regions))
        )));
        pipeline.add(Aggregates.group("$region", Accumulators.avg("avgExpense", "$Value")));

/*The change made here is replacing the type List<Document> with List<Bson> for the pipeline variable. 
Bson is a supertype of Document, which means it can accept both Document and Bson objects. This change makes
 the pipeline variable compatible with the Aggregates class methods, which expect a list of Bson objects as their argument. */

        // Execute the aggregation pipeline
        List<Document> regionAverageExpenseResult = collection.aggregate(pipeline).into(new ArrayList<Document>());

        // Create a new query document with the query parameters and the query result
        Document queryDocToInsert = new Document()
                .append("year", year)
                .append("type", type)
                .append("length", length)
                .append("regions", Arrays.toString(regions))
                .append("result", regionAverageExpenseResult);

        // Insert the query document into the query collection
        queryCollection.insertOne(queryDocToInsert);

        return queryDocToInsert;
    }
}


/*This code is a Java program that queries MongoDB for average education expenses in different regions of the United States.

The code first sets up a MongoDB connection using the MongoClient class from the MongoDB Java driver. It specifies the name of the database and collection to be used for the query, as well as the name of a separate collection to store the results of the query for future reference.

The program then calls the queryRegionAverageExpense method with the desired parameters for the query: year, type, length, and an array of regions. The method checks if the query has already been executed by searching the query collection for a document that matches the specified parameters. If such a document exists, it returns the query results from that document.

If the query has not been executed before, the method constructs an aggregation pipeline using the Aggregates class from the MongoDB Java driver. The pipeline consists of two stages: a match stage that filters the documents based on the specified parameters, and a group stage that calculates the average education expenses for each region. The pipeline is executed using the aggregate method of the MongoCollection class, and the results are stored in a List of Document objects.

The method then creates a new query document containing the query parameters and the query results, and inserts it into the query collection using the insertOne method of the MongoCollection class.

Finally, the main method of the program calls the queryRegionAverageExpense method and prints the results to the console. The MongoDB connection is then closed using the close method of the MongoClient class.



 */
/*db.College.aggregate([
  {
    $match:{
      Year: 2019,
      Type: "Public In-State",
      Length: "4-year",
      Value: { $gte: 10000 }
    }   },
  {
    $addFields: {
      region: {
        $switch: {
          branches: [
            { case: { $in: [ "$State", ["Washington", "Oregon", "California", "Nevada", "Hawaii", "Alaska"] ] }, then: "West" },
            { case: { $in: [ "$State", ["Idaho", "Montana", "Wyoming", "North Dakota", "South Dakota", "Nebraska", "Kansas", "Oklahoma", "Texas"] ] }, then: "Mid-west" },
            { case: { $in: [ "$State", ["Minnesota", "Iowa", "Missouri", "Wisconsin", "Illinois", "Indiana", "Michigan", "Ohio"] ] }, then: "Northeast" },
            { case: { $in: [ "$State", ["Maine", "New Hampshire", "Vermont", "Massachusetts", "Rhode Island", "Connecticut", "New York", "New Jersey", "Pennsylvania"] ] }, then: "Southeast" },
            { case: { $in: [ "$State", ["Maryland", "Delaware", "District of Columbia", "Virginia", "West Virginia", "North Carolina", "South Carolina", "Georgia", "Florida", "Kentucky", "Tennessee", "Alabama", "Mississippi", "Louisiana", "Arkansas"] ] }, then: "Southwest" }
          ],
          default: "Elsewhere"
        }
      }
    }
  },
  {
    $group: {
      _id: "$region",
      totalExpense: { $sum: "$Value" },
      count: { $sum: 1 }
    }
  },
  {
    $addFields: {
      avgExpense: { $divide: ["$totalExpense", "$count"] }
    }
  },
  {
    $project: {
      _id: 0,
      Region: "$_id",
      Year: 2019,
      Type: "Public In-State",
      Length: "4-year",
      avgExpense: 1
    }
  },
  {
    $out: "EduCostStatQueryFive"
  }
]);

 */