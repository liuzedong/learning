package com.dongdongxia.my.jdk8.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/***
 * 
 * <P>Description: 显式的使用通道写入文件</P>
 * @ClassName: ExplicitChannelWrite
 * @author java_liudong@163.com  2017年11月23日 上午9:51:58
 */
public class ExplicitChannelWrite {

    private static final String FILE_PATH = "/tmp/test.txt";
    
    public static void main(String[] args) {
        
        try (FileChannel fCha = (FileChannel) Files.newByteChannel(Paths.get(FILE_PATH), 
                StandardOpenOption.CREATE, 
                StandardOpenOption.WRITE)) {
            
            // 创建一个缓冲区， 想缓冲区中写入数据
            ByteBuffer bBuf = ByteBuffer.allocate(120);
            
            for (int i = 0; i < 120; i++) {
                Thread.sleep(1000);
                bBuf.put((byte) ('A' + new Random().nextInt(10)));
            }
            
            // 将缓冲区的指针只想， 缓冲区的首部
            bBuf.rewind();
            
            // 将缓冲区中的数据写入到通道中
            fCha.write(bBuf);
        } catch (IOException e) {
            System.err.format("I/O Error %s%n", e);
        } catch (InterruptedException e) {
            System.err.format("Interrupted Error %s%n", e);
        }
        
        
    }
    
    
}
