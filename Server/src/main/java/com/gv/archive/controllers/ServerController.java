package com.gv.archive.controllers;

import com.gv.archive.communication.concurrency.RequestExecutor;
import com.gv.archive.logging.AppLogger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerController {

    /** object for extracting properties from resource bundle communication.properties */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("communication");

    /** name of property in resource bundle that corresponds to server's port */
    private static final String SERVER_PORT = "server.port";

    private static ServerSocketChannel serverSocketChannel;

    private final static int POOL_SIZE = 30;

    private final static ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        try {
            AppLogger.getLogger().info("Trying to start server.");
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(true);
            int port = new Integer(RESOURCE_BUNDLE.getString(SERVER_PORT));
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            AppLogger.getLogger().info("Server started.");
            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                AppLogger.getLogger().info("Got a request from client.");
                Thread requestExecutor = new Thread(new RequestExecutor(socketChannel));
                EXECUTOR_SERVICE.execute(requestExecutor);
            }
        } catch (IOException e){
            AppLogger.getLogger().error(e);
        }
    }
}
