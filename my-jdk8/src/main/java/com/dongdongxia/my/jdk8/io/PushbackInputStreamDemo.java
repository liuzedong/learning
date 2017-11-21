package com.dongdongxia.my.jdk8.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 
 * <P>Description: 回推流的使用示例</P>
 * @ClassName: PushbackInputStreamDemo
 * @author java_liudong@163.com  2017年11月16日 下午3:06:42
 */
public class PushbackInputStreamDemo {

    public static void main(String[] args) {
        String s = "if (a == 4) a = 0; \n";
        byte[] buf = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        
        int c;
        try (PushbackInputStream pin = new PushbackInputStream(in)) {
            while ((c = pin.read()) != -1) {
                switch (c) {
                case '=' :
                    if ((c = pin.read()) == '=') {
                        System.out.print(".eq.");
                    } else {
                        System.out.print("<-");
                        pin.unread(c);
                    }
                    break ;
                default :
                    System.out.print((char) c);
                    break ;
                }
            }
        } catch (IOException e) {
            System.out.println("I/O Error : " + e);
        }
        
    }
    
}
