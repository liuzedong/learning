package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * <P>Description: 遍历目录信息</P>
 * @ClassName: DirList
 * @author java_liudong@163.com  2017年11月23日 上午10:46:26
 */
public class DirList {

    private static final String FILE_PATH = "/usr/local/java/jdk-9/";
    
    
    public static void main(String[] args) {
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(FILE_PATH));) {
            System.out.format("打印 %s的内容%n", FILE_PATH);
            
            dirStream.forEach((entry) -> 
                            {
                                try {
                                    BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                                    if (attribs.isDirectory()) {
                                        System.out.print("<DIR>");
                                    } else {
                                        System.out.format("\t");
                                    }
                                    System.out.println(entry.getFileName());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
