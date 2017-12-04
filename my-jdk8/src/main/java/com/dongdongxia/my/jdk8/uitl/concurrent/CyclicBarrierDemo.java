package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * <P>Description: 当所有线程达到指定数量时候出发的锁</P>
 * @ClassName: CyclicBarrierDemo
 * @author java_liudong@163.com  2017年11月24日 下午4:24:37
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws Exception{
        // 当线程数， 达到3个的时候， 就执行后续的线程
        CyclicBarrier cb = new CyclicBarrier(2, new BarAction());
        
        new MyThread2(cb, "A");
        Thread.sleep(3000);
        new MyThread2(cb, "B");
        Thread.sleep(3000);
        new MyThread2(cb, "C");
        Thread.sleep(3000);
        new MyThread2(cb, "D");
        Thread.sleep(3000);
    }
    
}

class MyThread2 implements Runnable {

    CyclicBarrier cb;
    String name;
    
    MyThread2(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        System.out.format("%s 启动 %n", name);
        
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("阻塞啦");
    }
    
}