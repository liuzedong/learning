package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.Phaser;

/**
 * 
 * <P>Description: 同步线程任务的案例</P>
 * @ClassName: PhaserDemo
 * @author java_liudong@163.com  2017年11月27日 下午4:29:58
 */
public class PhaserDemo {

    public static void main(String[] args) {
        // 同时只能有一个阶段
        Phaser phaser = new Phaser(1);
        int curPhase;
        
        System.out.println("开始测试。。。");
        
        new MyThreadC(phaser, "A");
        new MyThreadC(phaser, "B");
        new MyThreadC(phaser, "C");
        
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phaser " + curPhase + " 完整");
        
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phaser " + curPhase + " 完整");
        
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phaser " + curPhase + " 完整");
        
        // 取消注册主线程
        phaser.arriveAndDeregister();
        
        if (phaser.isTerminated()) {
            System.out.println("Phaser 已经终止啦");
        }
    }
}

class MyThreadC implements Runnable {

    Phaser phaser;
    String name;
    
    MyThreadC(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        System.out.println("线程 " + name + "开始第一阶段");
        // 等待信号的到来
        phaser.arriveAndAwaitAdvance();
        
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("线程 " + name + "开始第二阶段");
        phaser.arriveAndAwaitAdvance();
        
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("线程 " + name + "开始第三阶段");
        phaser.arriveAndDeregister();
    }
    
}
