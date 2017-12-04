package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * <P>Description: 线程计时器案例, 当发生指定事件次数后就会释放锁</P>
 * @ClassName: CountDownLatchDemo
 * @author java_liudong@163.com  2017年11月24日 下午4:11:06
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        // 创建一个倒计时 事件的对象
        CountDownLatch cdl = new CountDownLatch(5);
        
        System.out.println("测试开始");
        
        new MyThread(cdl);
        
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("测试结束");
    }
    
}

class MyThread implements Runnable {

    CountDownLatch latch;
    
    MyThread (CountDownLatch latch) {
        this.latch = latch;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown(); // 递减锁数量
        }
    }
    
}