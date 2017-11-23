package com.dongdongxia.my.jdk8.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

/**
 * 
 * <P>Description: 使用缓冲映射，将文件写入到底层的文件中 </P>
 * @ClassName: MappedChannelWrite
 * @author java_liudong@163.com  2017年11月23日 上午10:09:35
 */
public class MappedChannelWrite {

    private static final String FILE_PATH = "/tmp/test2.txt";
    
    public static void main(String[] args) {
        
        try (FileChannel fChannel = (FileChannel) Files.newByteChannel(Paths.get(FILE_PATH), 
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);){
            MappedByteBuffer map = fChannel.map(FileChannel.MapMode.READ_WRITE, 0, 120);
            
            // 直接想MappedByteBuffer 中写入数据， 就直接写入到底层文件中啦
            for (int i = 0; i < 120; i++) {
                Thread.sleep(1000);
                map.put((byte) ('A' + new Random().nextInt(10)));
            }
            
        } catch (IOException e) {
            System.err.format("I/O Error %s%n", e);
        } catch (InterruptedException e) {
            System.err.format("Interrupted Error %s%n", e);
        }
        
        
    }
    
}
