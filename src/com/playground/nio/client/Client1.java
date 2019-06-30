package com.playground.nio.client;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author: Vermouth
 * @create: 2019-06-29 21:15
 * @description:
 **/

public class Client1 {

    public static void main(String[] args) {

        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("Hello".getBytes());
            writeBuffer.flip();

            while(true) {
                writeBuffer.rewind(); // 第一次执行并没有影响，主要是第二次及以后
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
                Thread.sleep(5000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }


}
