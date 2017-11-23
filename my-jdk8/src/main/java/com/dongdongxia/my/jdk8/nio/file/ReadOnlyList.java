package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * <P>Description: 列出只读文件的列表</P>
 * @ClassName: ReadOnlyList
 * @author java_liudong@163.com  2017年11月23日 上午11:42:02
 */
public class ReadOnlyList {

    private static final String FILE_PATH = "/usr/local/java/jdk-9/";
    
    public static void main(String[] args) {
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                if (Files.isReadable(entry)) return true; 
                return false;
            }
        };
        
        try (DirectoryStream<Path> dirStream1 = Files.newDirectoryStream(Paths.get(FILE_PATH), (entry) -> 
        {
            if (Files.isExecutable(entry)) return true;
            return false;
        })){
            System.out.format("打印 %s的内容%n", FILE_PATH);
            dirStream1.forEach((entry) -> 
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
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        System.out.println("------------------------------");
        
        // 上面的是使用JDK8的 Lambda表达式
        
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(FILE_PATH), how);) {
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
