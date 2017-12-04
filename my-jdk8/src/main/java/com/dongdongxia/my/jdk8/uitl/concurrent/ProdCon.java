package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 
 * <P>Description: TODO</P>
 * @ClassName: ProdCon
 * @author java_liudong@163.com  2017年11月23日 下午4:22:20
 */
public class ProdCon {
    
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

class Q {
    int n;
    
    // 创建两个信号量
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);
    
    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Got: " + n);
        semProd.release();
    }
    
    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
        System.out.println("Put: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {

    Q q;
    
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}

class Consumer implements Runnable {

    Q q;
    
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}
