package com.gv.archive.communication.concurrency;

import java.nio.channels.SocketChannel;

public class RequestExecutor implements Runnable{

    private SocketChannel socketChannel;

    public RequestExecutor(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {

    }
}
