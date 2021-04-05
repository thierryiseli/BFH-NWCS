package com.thierryiseli.tcp_client;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final static Logger LOGGER = Logger.getLogger(MultithreadedSocketServer.class.getName());

    private int port;
    private ServerSocket serverSocket = null;

    public Server setSocketPort(int port) {
        this.port = port;
        return this;
    }

    public Server serve() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Connection error!", e);
        }
        LOGGER.info("Server started...");
        LOGGER.info("Waiting for a client...");
        return this;
    }

    public Server listen() {
        try {
            LOGGER.info("Waiting for accepting client...");
            Socket socket = serverSocket.accept();
            LOGGER.info("Client accepted...");
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over")) {
                line = in.readUTF();
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Listen to connection output failed!", e);
        }
        return this;
    }

    public Server and() {
        return this;
    }

    public Server then() {
        return this;
    }
}