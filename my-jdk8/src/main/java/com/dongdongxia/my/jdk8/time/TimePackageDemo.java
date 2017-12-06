package com.dongdongxia.my.jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: Time包中的对象使用</P>
 * @ClassName: TimePackageDemo
 * @author java_liudong@163.com  2017年10月16日 下午4:47:11
 */
public class TimePackageDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimePackageDemo.class);
    
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int dayOfMonth = now.getDayOfMonth();
        
        LOGGER.info(String.format("current date is year : %d ", year));
        LOGGER.info(String.format("current date of month : %d", dayOfMonth));
        
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
    }
    
}
