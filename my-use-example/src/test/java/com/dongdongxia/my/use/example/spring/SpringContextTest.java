package com.dongdongxia.my.use.example.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <P>Description: 加载Spring</P>
 * @ClassName: SpringContextTest
 * @author java_liudong@163.com  2017年12月18日 下午4:58:02
 */
public class SpringContextTest {

    static ClassPathXmlApplicationContext context;
    
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
        context.start();
    }
    
}
