package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 
 * <P>Description: Semaphore 对象的使用，经典的信号量</P>
 * @ClassName: SemaphoreDemo
 * @author java_liudong@163.com  2017年11月23日 下午3:48:58
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 创建一个许可证 和 两个线程， 然后启动, 这个许可证中的入参， 指定同时访问的线程个数
        Semaphore sem = new Semaphore(1);
        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
    
    
}


// 一个共享的资源
class Shared {
    static int count = 0;
}

// 一个线程， 将共享资源进行自增
class IncThread implements Runnable {

    String name;
    Semaphore sem;
    
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        System.out.format("%s 开始%n", name);
        
        try {
            // 获得许可
            System.out.format("%s 正在等待许可%n", name);
            sem.acquire();
            System.out.format("%s 获得许可%n", name);
            
            // 对共享资源进行操作
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.format("%s : %s %n", name, Shared.count);
                
                // 休眠一下
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        
        // 释放这个许可证
        System.out.format("%s 许可证释放 %n", name);
        sem.release();
    }
}

// 一个线程，将共享资源进行自减
class DecThread implements Runnable {
    
    String name;
    Semaphore sem;
    
    DecThread(Semaphore s, String n) {
        name = n;
        sem = s;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.format("%s 开始%n", name);
        
        try {
            // 获得许可
            System.out.format("%s 正在等待许可%n", name);
            sem.acquire();
            System.out.format("%s 获得许可%n", name);
            
            // 对共享资源进行操作
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.format("%s : %s %n", name, Shared.count);
                
                // 休眠一下
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        
        // 释放这个许可证
        System.out.format("%s 许可证释放 %n", name);
        sem.release();
    }
    
}