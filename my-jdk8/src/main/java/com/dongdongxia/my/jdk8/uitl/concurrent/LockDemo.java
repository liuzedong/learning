package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <P>Description: Lock 锁的使用示例</P>
 * @ClassName: LockDemo
 * @author java_liudong@163.com  2017年12月4日 上午10:53:16
 */
public class LockDemo {

    public static void main(String[] args) {
        ReentrantLock rt = new ReentrantLock();
        
        // 创建两个线程， 如果没有锁的话，会同时进行， 如果有锁的话， 需要等待， 前一个锁释放，才可以执行
        new LockThread("A", rt);
        new LockThread("B", rt);
    }
    
}

/**
 * 
 * <P>Description: 一个共同享用的资源</P>
 * @ClassName: Shared2
 * @author java_liudong@163.com  2017年12月4日 上午10:54:03
 */
class Shared2 {
    static int count = 0;
}

/**
 * 
 * <P>Description: 一个持有锁的线程， 使用可重用锁</P>
 * @ClassName: LockThread
 * @author java_liudong@163.com  2017年12月4日 上午10:54:41
 */
class LockThread implements Runnable {

    String name;
    ReentrantLock lock;
    
    LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        try {
            System.out.format("%s 正在等待 count 资源 锁 %n", name);
            lock.lock();
            System.out.format("%s 锁住勒 count 资源 %n", name);
            
            Shared2.count++;
            System.out.format("%s : %s%n", name, Shared2.count);
            
            System.out.format("%s 休眠", name);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            System.out.println(name + "释放count 资源 锁");
            lock.unlock();
        }
    }
}
