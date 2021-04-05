package com.thierryiseli.tcp_client;

public class Main {
    public static void main(String[] args) {
        String type = System.getenv("TCP_CLIENT_TYPE");
        switch (type) {
            case "MultithreadedSocketServer":
                new MultithreadedSocketServer()
                        .setSocketPort(1337)
                        .and()
                        .serve()
                        .then()
                        .listen();
                break;
            case "MultithreadedClient":
                new MultithreadedClient()
                        .setHost("127.0.0.1", 1337)
                        .and()
                        .connectToHost()
                        .then()
                        .listen();
                break;
            case "Server":
                new Server()
                        .setSocketPort(5000)
                        .and()
                        .serve()
                        .then()
                        .listen();
                break;
            default:
            case "Client":
                new Client()
                        .setHost("127.0.0.1", 5000)
                        .and()
                        .connectToHost()
                        .then()
                        .listen();
                break;
        }
    }
}
