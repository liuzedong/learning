package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * <P>Description: 创建日志文件， 并且追加输出</P>
 * @ClassName: LogFilePermissionsTest
 * @author java_liudong@163.com  2017年11月8日 上午9:46:41
 */
public class LogFilePermissionsTest {

    public static void main(String[] args) {
        // 创建多个OpenOptions
        Set<OpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        
        // 创建用户权限属性
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        
        // 创建文件并且输出日志
        String s = "Hello World !";
        byte[] data = s.getBytes();
        
        ByteBuffer bb = ByteBuffer.wrap(data);
        
        Path file = Paths.get("./permissions.log");
        
        try (SeekableByteChannel sbc = Files.newByteChannel(file, options, attr)) {
            sbc.write(bb);
        } catch (IOException e) {
            System.out.println("Exception thrown: " + e);
        }
    }
    
}
