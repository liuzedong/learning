package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * <P>Description: 原子字段的操作， 使用原子类型的使用，方法，就可以不用加锁啦</P>
 * @ClassName: AtomicDemo
 * @author java_liudong@163.com  2017年12月4日 上午11:09:37
 */
public class AtomicDemo {

    public static void main(String[] args) {
        // 创建三个线程，同时去操作一个元数据
        new AtomicThread("A");
        new AtomicThread("B");
        new AtomicThread("C");
    }
}

/**
 * 
 * <P>Description: 一个公用的原子</P>
 * @ClassName: Shared3
 * @author java_liudong@163.com  2017年12月4日 上午11:11:05
 */
class Shared3 {
    static AtomicInteger ai = new AtomicInteger(0);
}

/**
 * 
 * <P>Description: 一个线程操作原子数据，主方法中操作多个线程</P>
 * @ClassName: AtomicThread
 * @author java_liudong@163.com  2017年12月4日 上午11:11:36
 */
class AtomicThread implements Runnable {

    String name;
    
    AtomicThread(String name) {
        this.name = name;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        System.out.format("%s 开始%n", name);
        
        for(int i = 1; i <= 3; i++) {
            System.out.println(name + " got: " + Shared3.ai.getAndSet(i));
        }
        
        System.out.format("%s 休眠 %n", name);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}