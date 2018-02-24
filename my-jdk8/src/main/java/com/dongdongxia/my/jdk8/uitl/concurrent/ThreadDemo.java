package com.dongdongxia.my.jdk8.uitl.concurrent;

public class ThreadDemo {
    
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("A");
        NewThread ob2 = new NewThread("B");
        NewThread ob3 = new NewThread("C");
        
        System.out.println("线程A的状态 : " + ob1.t.isAlive());
        System.out.println("线程B的状态 : " + ob2.t.isAlive());
        System.out.println("线程C的状态 : " + ob3.t.isAlive());
        
        // 下面是线程， 进行等待， 知道线程完成
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程A的状态 : " + ob1.t.isAlive());
        System.out.println("线程B的状态 : " + ob2.t.isAlive());
        System.out.println("线程C的状态 : " + ob3.t.isAlive());
    }
}

class NewThread implements Runnable {
    
    String name;
    Thread t;
    
    NewThread(String threadName) {
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread : " + t);
        t.start();
    }
    
    @Override
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println(name + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
    
}
