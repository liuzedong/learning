package com.dongdongxia.my.jdk8.lang;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * <P>Description: 使用运行时</P>
 * @ClassName: UseRuntime
 * @author java_liudong@163.com  2017年11月9日 下午4:20:51
 */
public class UseRuntime {

    public static void main(String[] args) {
        // 使用Runtime exec 执行pwd命令
        Runtime r = Runtime.getRuntime();
        try {
            Process exec = r.exec("pwd");
            InputStream inputStream = exec.getInputStream();
            int c ;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char) c);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Properties properties = System.getProperties();
        Set<Object> keySet = properties.keySet();
        for (Object object : keySet) {
            System.out.format("%s = %s %n", object, properties.get(object));
        }
    }
    
}
