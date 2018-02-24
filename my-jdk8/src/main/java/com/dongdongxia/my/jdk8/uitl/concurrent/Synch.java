package com.dongdongxia.my.jdk8.uitl.concurrent;
/**
 * 
 * <P>Description: 同步方法的使用</P>
 * @ClassName: Synch
 * @author java_liudong@163.com  2017年12月18日 下午2:10:58
 */
public class Synch {

    public static void main(String[] args) {
        Callme callme = new Callme();
        Caller ob1 = new Caller(callme, "你好");
        Caller ob2 = new Caller(callme, "同步");
        Caller ob3 = new Caller(callme, "世界");
        
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

// 调用自己
class Callme {
    
    /*synchronized*/ void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

// 调用者
class Caller implements Runnable {

    String msg;
    Callme target;
    Thread t;
    
    Caller(Callme target, String msg) {
        this.target = target;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
    
}