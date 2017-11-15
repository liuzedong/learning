package com.dongdongxia.my.jdk8.uitl;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * <P>Description: 资源加载示例</P>
 * @ClassName: LRBDemo
 * @author java_liudong@163.com  2017年11月15日 上午10:54:23
 */
public class LRBDemo {

    public static void main(String[] args) {
        ResourceBundle rd = ResourceBundle.getBundle("com.dongdongxia.my.jdk8.uitl.SampleRB");
        
        System.out.println("Chinese version: ");
        System.out.format("String for Title key: %s%n", rd.getString("title"));
        System.out.format("String for StopText: %s%n", rd.getString("StopText"));
        System.out.format("String for StartText: %s%n", rd.getString("StartText"));
        
        System.out.println(Locale.ENGLISH);
        
        rd = ResourceBundle.getBundle("com.dongdongxia.my.jdk8.uitl.SampleRB", Locale.ENGLISH);
        
        System.out.println("English version: ");
        System.out.format("String for Title key: %s%n", rd.getString("title"));
        System.out.format("String for StopText: %s%n", rd.getString("StopText"));
        System.out.format("String for StartText: %s%n", rd.getString("StartText"));
    }
}
