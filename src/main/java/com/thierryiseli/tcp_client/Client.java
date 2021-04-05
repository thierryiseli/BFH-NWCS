package com.thierryiseli.tcp_client;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    private final static Logger LOGGER = Logger.getLogger(Client.class.getName());

    private Socket socket;
    private String address;
    private int port;

    public Client setHost(String address, int port) {
        this.address = address;
        this.port = port;
        return this;
    }

    public Client connectToHost() {
        try {
            socket = new Socket(address, port);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Connection error!", e);
        }
        return this;
    }

    public Client listen() {
        try {
            String line = "";
            DataInputStream dataInputStream = new DataInputStream(System.in);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while (!line.equals("Over")) {
                line = dataInputStream.readLine();
                outputStream.writeUTF(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Listen to connection output failed!", e);
        }
        return this;
    }

    public Client and() {
        return this;
    }

    public Client then() {
        return this;
    }
}