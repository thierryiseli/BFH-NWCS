package com.thierryiseli.tcp_client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultithreadedSocketServer {
    private final static Logger LOGGER = Logger.getLogger(MultithreadedSocketServer.class.getName());

    private int port;
    private ServerSocket serverSocket;

    public MultithreadedSocketServer setSocketPort(int port) {
        this.port = port;
        return this;
    }

    public MultithreadedSocketServer serve() {
        try {
            serverSocket = new ServerSocket(port);
            LOGGER.info("Sever started...");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Connection error!", e);
        }
        return this;
    }


    public MultithreadedSocketServer listen() {
        try {
            int counter = 0;
            while (true) {
                counter++;
                Socket serverClient = serverSocket.accept();
                LOGGER.info(">> Client number " + counter + " started!");
                MultithreadedServerClientThread serverClientThread =
                        new MultithreadedServerClientThread(serverClient, counter);
                serverClientThread.start();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Listen to connection output failed!", e);
        }
        return this;
    }

    public MultithreadedSocketServer and() {
        return this;
    }

    public MultithreadedSocketServer then() {
        return this;
    }
}