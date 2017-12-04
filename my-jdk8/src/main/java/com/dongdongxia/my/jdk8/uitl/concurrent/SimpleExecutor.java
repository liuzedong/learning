package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * <P>Description: 简单的线程执行</P>
 * @ClassName: SimpleExecutor
 * @author java_liudong@163.com  2017年11月27日 下午5:03:46
 */
public class SimpleExecutor {
    
    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);
        
        System.out.println("开始。。。");
        
        es.execute(new MyThreadD(cdl1, "A"));
        es.execute(new MyThreadD(cdl2, "B"));
        es.execute(new MyThreadD(cdl3, "C"));
        es.execute(new MyThreadD(cdl4, "D"));
        
        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        es.shutdown();
        System.out.println("结束。。。");
    }

}

class MyThreadD implements Runnable {

    String name;
    CountDownLatch latch;
    
    MyThreadD(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
        new Thread(this);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
    
}