package com.dongdongxia.my.jdk8.nio.file;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * <P>Description: 日志文件测试</P>
 * @ClassName: LogFileTest
 * @author java_liudong@163.com  2017年11月8日 上午9:33:44
 */
public class LogFileTest {

    public static void main(String[] args) {
        String s = "Hello World!";
        byte[] data = s.getBytes();
        Path p = Paths.get("./logfile.txt");
        
        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException e) {
            System.err.println(e);
        }
        
    }
    
}
