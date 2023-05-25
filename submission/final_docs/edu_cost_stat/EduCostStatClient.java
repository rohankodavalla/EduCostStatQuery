import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class EduCostStatClient {
    private final ManagedChannel channel;
    private final EduCostStatQueryOneGrpc.EduCostStatQueryOneBlockingStub queryOneStub;
    private final EduCostStatQueryTwoGrpc.EduCostStatQueryTwoBlockingStub queryTwoStub;
    private final EduCostStatQueryThreeGrpc.EduCostStatQueryThreeBlockingStub queryThreeStub;
    private final EduCostStatQueryFourGrpc.EduCostStatQueryFourBlockingStub queryFourStub;
    private final EduCostStatQueryFiveGrpc.EduCostStatQueryFiveBlockingStub queryFiveStub;

    public EduCostStatClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    public EduCostStatClient(ManagedChannel channel) {
        this.channel = channel;
        this.queryOneStub = EduCostStatQueryOneGrpc.newBlockingStub(channel);
        this.queryTwoStub = EduCostStatQueryTwoGrpc.newBlockingStub(channel);
        this.queryThreeStub = EduCostStatQueryThreeGrpc.newBlockingStub(channel);
        this.queryFourStub = EduCostStatQueryFourGrpc.newBlockingStub(channel);
        this.queryFiveStub = EduCostStatQueryFiveGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void queryOne(int year, String state, String type, String length, int expense) {
        EduCostStatQueryOneRequest request = EduCostStatQueryOneRequest.newBuilder()
                .setYear(year)
                .setState(state)
                .setType(type)
                .setLength(length)
                .setExpense(expense)
                .build();
    
        EduCostStatQueryOneResponse response = queryOneStub.queryCost(request);
    
        System.out.println("Query One Response: " + response.getResult());
    }
    

    public void queryTwo(int year, String type, String length) {
        EduCostStatQueryTwoRequest request = EduCostStatQueryTwoRequest.newBuilder()
                .setYear(year)
                .setType(type)
                .setLength(length)
                .build();

        EduCostStatQueryTwoResponse response = queryTwoStub.queryTop5ExpensiveStates(request);

        System.out.println("Query Two Response: " + response.getResult());
    }

    public void queryThree(int year, String type, String length) {
        EduCostStatQueryThreeRequest request = EduCostStatQueryThreeRequest.newBuilder()
                .setYear(year)
                .setType(type)
                .setLength(length)
                .build();

        EduCostStatQueryThreeResponse response = queryThreeStub.queryEconomicStates(request);

        System.out.println("Query Three Response: " + response.getResult());
    }

    public void queryFour(int year, String type, String length, int[] pastYears) {
        EduCostStatQueryFourRequest request = EduCostStatQueryFourRequest.newBuilder()
                .setYear(year)
                .setType(type)
                .setLength(length)
                .setPastYears(pastYears)
                .build();

        EduCostStatQueryFourResponse response = queryFourStub.queryTop5HighestGrowthRateStates(request);

        System.out.println("Query Four Response: " + response.getResult());
    }

    public void queryFive(int year, String type, String length, String... regions) {
        EduCostStatQueryFiveRequest request = EduCostStatQueryFiveRequest.newBuilder()
                .setYear(year)
                .setType(type)
                .setLength(length)
                .addAllRegions(Arrays.asList(regions))
                .build();

        EduCostStatQueryFiveResponse response = queryFiveStub.queryRegionAverageExpense(request);

        System.out.println("Query Five Response: " + response.getResult());
    }

    public static void main(String[] args) throws Exception {
        EduCostStatClient client = null;
        try {
            // create a client
            client = new EduCostStatClient("localhost", 50051);
    
            
            // run query one
            client.queryOne(year + "," + state + "," + type + "," + length + "," + expense);

    
            // run query two
            client.queryTwo(year + "," + type + "," + length);
    
            // run query three
            client.queryThree(year + "," + type + "," + length);
    
            // run query four
            client.queryFour(year + "," + type + "," + length + "," +pastYears);
    
            // run query five
            client.queryFive(2020, "Private", "2 Years", "Northeast", "South");
        } finally {
            // shutdown client
            if (client != null) {
                client.shutdown();
            }
        }
    }
}    
