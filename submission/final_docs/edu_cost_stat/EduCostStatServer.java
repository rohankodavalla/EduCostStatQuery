import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EduCostStatServer {
    private final int port;
    private final Server server;

    public EduCostStatServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }

    public EduCostStatServer(ServerBuilder<?> serverBuilder, int port) {
        this.port = port;
        server = serverBuilder.addService(new EduCostStatQueryOneImpl())
                .addService(new EduCostStatQueryTwoImpl())
                .addService(new EduCostStatQueryThreeImpl())
                .addService(new EduCostStatQueryFourImpl())
                .addService(new EduCostStatQueryFiveImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server since JVM is shutting down");
                try {
                    EduCostStatServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("Server shut down");
            }
        });
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        EduCostStatServer server = new EduCostStatServer(50051);
        server.start();
        server.blockUntilShutdown();
    }

}





























