package com.gv.archive.communication.concurrency;

import com.gv.archive.communication.factories.implementations.RequestStrategyFactoryImpl;
import com.gv.archive.communication.factories.interfaces.RequestStrategyFactory;
import com.gv.archive.communication.interfaces.Request;
import com.gv.archive.communication.interfaces.Response;
import com.gv.archive.communication.strategies.interfaces.RequestStrategy;
import com.gv.archive.logging.AppLogger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.SocketChannel;

public class RequestExecutor implements Runnable{

    private SocketChannel socketChannel;

    private RequestStrategyFactory factory = new RequestStrategyFactoryImpl();

    public RequestExecutor(SocketChannel socketChannel){
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            AppLogger.getLogger().info("Request executor has been started.");

            ObjectInputStream inputStream = new ObjectInputStream(socketChannel.socket().getInputStream());
            Request request = (Request) inputStream.readObject();

            AppLogger.getLogger().info("Request has been received. Request type: " + request.getRequestType());

            RequestStrategy strategy = factory.defineRequestStrategy(request);
            Response response = strategy.executeRequest(request);

            ObjectOutputStream outputStream = new ObjectOutputStream(socketChannel.socket().getOutputStream());
            outputStream.writeObject(response);
            outputStream.close();
            inputStream.close();

            AppLogger.getLogger().info("Response has been sent.");
        }catch (Exception e) {
            AppLogger.getLogger().error(e);
        }
    }
}
