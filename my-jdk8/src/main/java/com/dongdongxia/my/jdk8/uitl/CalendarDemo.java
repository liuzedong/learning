package com.dongdongxia.my.jdk8.uitl;

import java.util.Calendar;

/**
 * 
 * <P>Description: 日期处理Demo</P>
 * @ClassName: CalendarDemo
 * @author java_liudong@163.com  2017年11月14日 上午11:29:53
 */
public class CalendarDemo {

    public static void main(String[] args) {
        String[] months = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        
        Calendar calendar = Calendar.getInstance();
        System.out.format("Date: %s %s %s%n", months[calendar.get(Calendar.MONTH)], calendar.get(Calendar.DATE), calendar.get(Calendar.YEAR));
        
        System.out.format("Time: %s:%s:%s%n", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
        
        // 给当前时间设置时分秒
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 12);
        System.out.format("Time: %s:%s:%s%n", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }
    
}
