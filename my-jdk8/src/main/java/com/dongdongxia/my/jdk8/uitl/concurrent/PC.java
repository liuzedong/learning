package com.dongdongxia.my.jdk8.uitl.concurrent;
/**
 * 
 * <P>Description: 线程， 之间的同步， 且通讯</P>
 * @ClassName: PC
 * @author java_liudong@163.com  2017年12月18日 下午2:45:33
 */
public class PC {

    public static void main(String[] args) {
        Q2 q = new Q2();
        new Producer2(q);
        new Consumer2(q);
        
        System.out.println("需要你自己关闭程序， Ctrl + c");
    }
    
}

// 一个简单的队列， 获取数据和存储数据
class Q2 {
    
    int n;
    
    // 标记
    boolean valueSet = false;
    
    synchronized int get() {
//        System.out.println("Got : " + n);
//        return n;
        // 下面使用的 是等待， 其他线程，进行唤醒
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Got : " + n);
        valueSet = false;
        notify();
        return n;
    }
    
    synchronized void put(int n) {
//        this.n = n;
//        System.out.println("Put : " + n);
        
        // 下面是线程的唤醒
        while(valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = false;
        System.out.println("Put : " + n);
        notify();
    }
    
}

// 提供者
class Producer2 implements Runnable {

    Q2 q;
    
    Producer2(Q2 q) {
        this.q = q;
        new Thread(this, "提供者").start();;
    }
    
    @Override
    public void run() {
        int i = 0;
        
        while(true) {
            q.put(i++);
        }
    }
}

// 消费者
class Consumer2 implements Runnable {

    Q2 q;
    
    Consumer2(Q2 q) {
        this.q = q;
        new Thread(this, "消费者").start();
    }
    
    @Override
    public void run() {
        while(true) {
            q.get();
        }
    }
}