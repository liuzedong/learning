package com.dongdongxia.my.jdk8.io;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * <P>Description: 测试字符数组写入</P>
 * @ClassName: CharArrayWriterDemo
 * @author java_liudong@163.com  2017年11月17日 下午3:08:36
 */
public class CharArrayWriterDemo {

    public static void main(String[] args) {
        CharArrayWriter caw = new CharArrayWriter();
        String s = "This should end up in the array";
        
        char[] buf = new char[s.length()];
        
        s.getChars(0, s.length(), buf, 0);
        try {
            caw.write(buf);
        } catch (IOException e) {
            System.out.println("Error Writing to Buffer");
            return ;
        }
        
        System.out.println("Buffer as a string");
        System.out.println(caw.toString());
        System.out.println("Into array");
        
        char[] c = caw.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }
        
        System.out.println("\nTo a FileWriter()");
        
        try (FileWriter f2 = new FileWriter("/tmp/test.txt")) {
            caw.writeTo(f2);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        
        System.out.println("Doing a reset");
        caw.reset();
        
        for (int i = 0; i < 3; i++) {
            caw.write('X');
        }
        
        System.out.println(caw.toString());
    }
    
}
