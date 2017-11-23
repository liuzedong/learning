package com.dongdongxia.my.jdk8.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * <P>Description: 使用文件映射到缓冲区，文件通道读取文件</P>
 * @ClassName: MappedChannelRead
 * @author java_liudong@163.com  2017年11月23日 上午9:36:48
 */
public class MappedChannelRead {

    private static final String FILE_PATH = "/tmp/renderlog";
    
    public static void main(String[] args) {
        
        try (FileChannel fCha = (FileChannel) Files.newByteChannel(Paths.get(FILE_PATH))) {
            
            // 获取文件的大小
            long fSize = fCha.size();
            
            // 现在， 将文件映射到缓冲中, 将所有的信息缓冲到文件映射中
            MappedByteBuffer mBuf = fCha.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            
            // 读取并显示通道中的内容
            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("I/0 Error " + e);
        }
        
        
    }
    
}
