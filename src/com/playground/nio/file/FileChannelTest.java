package com.playground.nio.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Vermouth
 * @create: 2019-06-29 22:56
 * @description: 测试文件操作
 **/

public class FileChannelTest {

    public static void main(String[] args) {
        RandomAccessFile afile = null;
        try {
            afile = new RandomAccessFile("/Users/Younghusband/Java/my.txt","rw");
            FileChannel channel = afile.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(48);
            int readCounts = channel.read(readBuffer); // 写作read 看做是写...
            System.out.println("开始读！");
            while(readCounts!=-1) {
                readBuffer.flip(); // limit置position, position置0 准备读buffer
                while(readBuffer.hasRemaining()) {
                    System.out.print((char)readBuffer.get()); // 一个汉字是两个字节，所以这里会乱码
                }
                readBuffer.clear(); // position归零，limit置为capacity
                readCounts = channel.read(readBuffer); // 从头继续写
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                afile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
