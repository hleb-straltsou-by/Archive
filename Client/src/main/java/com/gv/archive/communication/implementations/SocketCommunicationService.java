package com.gv.archive.communication.implementations;

import com.gv.archive.communication.interfaces.CommunicationService;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.logging.AppLogger;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ResourceBundle;

public class SocketCommunicationService implements CommunicationService{

    /** object for extracting properties from resource bundle communication.properties */
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("communication");

    /** name of property in resource bundle that corresponds to server's port */
    private static final String SERVER_PORT = "server.port";

    /** name of property in resource bundle that corresponds to server's ip */
    private static final String SERVER_IP = "server.ip";

    private SocketChannel socketChannel;

    private ObjectInputStream objectInputStream;

    private ObjectOutputStream objectOutputStream;

    public SocketCommunicationService(){}

    @Override
    public void init() {
        try {
            AppLogger.getLogger().info("Initialization of connection with server through sockets.");
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            int serverPort = Integer.parseInt(RESOURCE_BUNDLE.getString(SERVER_PORT));
            if (socketChannel.connect(new InetSocketAddress(RESOURCE_BUNDLE.getString(SERVER_IP), serverPort))) {
                objectInputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
                objectOutputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
            }
            AppLogger.getLogger().info("Initialization was successful. Input and output streams are initialized.");
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        }
    }

    @Override
    public Response doGet(Request request) {
        request.setRequestType("GET");
        AppLogger.getLogger().info("Sending GET request to the server.");
        Response response = sendRequest(request);
        if(response != null){
            AppLogger.getLogger().info("Client has been received response from server.");
        }
        return response;
    }

    @Override
    public Response doPut(Request request) {
        request.setRequestType("PUT");
        AppLogger.getLogger().info("Sending PUT request to the server.");
        Response response = sendRequest(request);
        if(response != null){
            AppLogger.getLogger().info("Client has been received response from server.");
        }
        return response;
    }

    @Override
    public Response doPost(Request request) {
        request.setRequestType("POST");
        AppLogger.getLogger().info("Sending POST request to the server.");
        Response response = sendRequest(request);
        if(response != null){
            AppLogger.getLogger().info("Client has been received response from server.");
        }
        return response;
    }

    @Override
    public Response doDelete(Request request) {
        request.setRequestType("DELETE");
        AppLogger.getLogger().info("Sending DELETE request to the server.");
        Response response = sendRequest(request);
        if(response != null){
            AppLogger.getLogger().info("Client has been received response from server.");
        }
        return response;
    }

    private Response sendRequest(Request request){
        Response response = null;
        try{
            objectOutputStream.writeObject(request);
            response = (Response)objectInputStream.readObject();
        } catch (Exception e){
            AppLogger.getLogger().error(e);
        } finally {
            return response;
        }
    }
}
