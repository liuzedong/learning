package com.dongdongxia.my.jdk8.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * <P>Description: 使用channel(通道)I/O 读取文件</P>
 * @ClassName: ExplicitChannelRead
 * @author java_liudong@163.com  2017年11月23日 上午9:14:15
 */
public class ExplicitChannelRead {

    private static final String FILE_PATH = "/tmp/renderlog";
    
    public static void main(String[] args) {
        int count;
        Path filePath = null;
        
        // 首先，获取文件
        filePath = Paths.get(FILE_PATH);
        
        // 然后获取通道，并且使用完 后关闭
        try ( SeekableByteChannel sbc = Files.newByteChannel(filePath) ) {
            // 分配一个通道空间
            ByteBuffer mBuf = ByteBuffer.allocate(5);
            
            do {
                count = sbc.read(mBuf);
                
                // 如果读取出来， 不是最尾部， 就将指针只想，缓冲区的首部
                if (count != -1) {
                    mBuf.rewind();
                }
                // 读取的数据显示
                for (int i = 0; i < count; i++) {
                    System.out.print((char) mBuf.get());
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}