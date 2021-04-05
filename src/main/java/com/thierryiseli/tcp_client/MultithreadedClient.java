package com.thierryiseli.tcp_client;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultithreadedClient {
    private final static Logger LOGGER = Logger.getLogger(MultithreadedClient.class.getName());

    private Socket socket;
    private String address;
    private int port;

    public MultithreadedClient setHost(String address, int port) {
        this.address = address;
        this.port = port;
        return this;
    }

    public MultithreadedClient connectToHost() {
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Connection error!", e);
        }
        return this;
    }

    public MultithreadedClient listen() {
        int amountOfRequests = 20;
        try {
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "";
            String serverMessage = "";

            while (!clientMessage.equals("bye")) {
                System.out.println("You can talk to the Server...");
                System.out.println("Enter a Number, \"Ping\" or \"Bye\"");
                clientMessage = br.readLine();
                for (int i = 0; i < amountOfRequests; i++) {
                    outStream.writeUTF(clientMessage);
                    outStream.flush();
                    serverMessage = inStream.readUTF();
                    System.out.println(serverMessage);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Listen to connection output failed!", e);
        }
        return this;
    }

    public MultithreadedClient and() {
        return this;
    }

    public MultithreadedClient then() {
        return this;
    }
}
