package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * <P>Description: 使用SimpleFileVisitor 遍历， Tree</P>
 * @ClassName: DirTreeList
 * @author java_liudong@163.com  2017年11月23日 下午2:09:41
 */
public class DirTreeList {
    
    private static final String FILE_PATH = "/usr/local/java/jdk-9/";
    
    public static void main(String[] args) {
        System.out.format("%s 开始遍历 %n", FILE_PATH);
        
        try {
            Files.walkFileTree(Paths.get(FILE_PATH), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}

class MyFileVisitor extends SimpleFileVisitor<Path> {

    private int count = 1;
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println((count++) + " " + file);
        return FileVisitResult.CONTINUE;
    }
    
    
}