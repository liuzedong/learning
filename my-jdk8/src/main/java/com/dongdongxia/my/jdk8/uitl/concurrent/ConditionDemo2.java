package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <P>Description: 实现锁住对象，然后 休眠， 然后 释放锁</P>
 * @ClassName: ConditionDemo2
 * @author java_liudong@163.com  2017年12月18日 上午10:30:11
 */
public class ConditionDemo2 {

    public static void main(String[] args) throws Exception {
        ArrayData a = new ArrayData();
        new ConditionAwait(a);
        
        Thread.sleep(1000 * 2);
        
        a.unlockObject();
        
        Thread.sleep(1000 * 2);
        
        System.out.println("结束");
    }
    
}

class ConditionAwait implements Runnable {

    ArrayData a;
    
    ConditionAwait(ArrayData a) {
        this.a = a;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        a.lockObject();
    }
    
}

class ArrayData {
    
    private ReentrantLock lock = new ReentrantLock();
    // 创建一个锁控制器
    private Condition condition = lock.newCondition();
    
    
    // 锁住 且等待
    public void lockObject() {
        
        try {
            lock.lock();
            
            System.out.println("锁住对象");
            condition.await();
            System.out.println("唤醒啦");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        
        
    }
    
    // 锁住 且唤醒
    public void unlockObject() {
        lock.lock();
        
        condition.signal();
        
        lock.unlock();
    }
}