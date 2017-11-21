package com.dongdongxia.my.jdk8.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 
 * <P>Description: 一次读取多个流的使用示例</P>
 * @ClassName: SequenceInputStreamDemo
 * @author java_liudong@163.com  2017年11月16日 下午3:18:08
 */
public class SequenceInputStreamDemo {

    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();
        
        files.addElement(System.getProperty("user.home") + "/下载/file1.txt");
        files.addElement(System.getProperty("user.home") + "/下载/file2.txt");
        files.addElement(System.getProperty("user.home") + "/下载/file3.txt");
        InputStreamEnmuerator ise = new InputStreamEnmuerator(files);
        try (
        InputStream input = new SequenceInputStream(ise);
        ) {
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("I/O Error : " + e);
        }
        
        
    }
    
}

class InputStreamEnmuerator implements Enumeration<FileInputStream> {

    private Enumeration<String> files;
    
    public InputStreamEnmuerator(Vector<String> files) {
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    
}