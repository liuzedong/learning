package com.dongdongxia.my.jdk8.uitl;

import java.util.StringTokenizer;

/**
 * 
 * <P>Description: 字符串分割， 使用示例</P>
 * @ClassName: StringTokenizerDemo
 * @author java_liudong@163.com  2017年11月14日 上午9:44:54
 */
public class StringTokenizerDemo {

    // 定义要分割是字符串
    static String in = "title = Java: The complete Reference;"
            + "author=Schildt;"
            + "publisher=McGraw-Hill;"
            + "copyright=2014";
    
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(in, "=;");
        
        while(st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.format("%s \t %s%n", key, val);
        }
    }
}
