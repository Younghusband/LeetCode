package com.playground.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Vermouth
 * @create: 2019-06-29 20:53
 * @description:
 **/

public class EpollServer {

    public static void main(String[] args) {

        try {
            // socket Server端
            ServerSocketChannel ssc = ServerSocketChannel.open(); // ServerSocketChannel只能用来做 accept操作
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);

            writeBuffer.put("server ".getBytes());
            writeBuffer.flip();

            while (true) {
                int nReady = selector.select(); // block op
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer); // 写进来了client端的hello

                        System.out.println("received : " + new String(readBuffer.array()));
                        readBuffer.flip();
                        key.interestOps(SelectionKey.OP_WRITE);
                    } else if (key.isWritable()) {
                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }

}
