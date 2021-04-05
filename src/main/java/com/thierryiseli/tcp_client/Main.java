package com.thierryiseli.tcp_client;

public class Main {
    public static void main(String[] args) {
        String type = System.getenv("TCP_CLIENT_TYPE");
        String serverHost = System.getenv("TCP_SERVER_HOST");
        int serverPort = Integer.parseInt(System.getenv("TCP_SERVER_PORT"));
        switch (type) {
            case "MultithreadedSocketServer":
                new MultithreadedSocketServer()
                        .setSocketPort(serverPort)
                        .and()
                        .serve()
                        .then()
                        .listen();
                break;
            case "MultithreadedClient":
                new MultithreadedClient()
                        .setHost(serverHost, serverPort)
                        .and()
                        .connectToHost()
                        .then()
                        .listen();
                break;
            case "Server":
                new Server()
                        .setSocketPort(serverPort)
                        .and()
                        .serve()
                        .then()
                        .listen();
                break;
            case "Client":
                new Client()
                        .setHost(serverHost, serverPort)
                        .and()
                        .connectToHost()
                        .then()
                        .listen();
                break;
        }
    }
}
