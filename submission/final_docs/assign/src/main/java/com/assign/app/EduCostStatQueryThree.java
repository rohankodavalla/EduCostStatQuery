package com.assign.app;

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
    private MongoCollection<Document> collection;
    private MongoCollection<Document> resultCollection;
    private MongoClient mongoClient;
    private MongoDatabase database;

    public void queryEconomicStates() {
        mongoClient = MongoClients.create("mongodb+srv://rkodava:Dimpu1997@educoststat.ioim58e.mongodb.net/?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("test");
        collection = database.getCollection("EduCostStat");
        resultCollection = database.getCollection("EduCostStatQueryThree");
    }

    public void execute() {
        int year = 2013;
        String type = "Private";
        String length = "4-year";

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

        resultCollection.insertMany(queryResult);
    }
}



