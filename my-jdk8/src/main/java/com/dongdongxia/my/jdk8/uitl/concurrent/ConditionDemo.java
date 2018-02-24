package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * <P>
 * Description: 实现 等待， 和唤醒
 * </P>
 * 
 * @ClassName: ConditionDemo
 * @author java_liudong@163.com 2017年12月18日 上午10:12:25
 */
public class ConditionDemo {

    // main方法启动，就是一个进程
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExcute(business, "sub");
            }
        }).start();;
        threadExcute(business, "main");
    }
    
    
    public static void threadExcute(Business business, String threadType) {
        for(int i = 0; i < 100; i++) {
            try {
                if ("main".equals(threadType)) {
                    business.main(i);
                } else {
                    business.sub(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Business {
    private boolean bool = true;
    private Lock lock = new ReentrantLock();
    // 获取锁的控制
    private Condition condition = lock.newCondition();

    public void main(int loop) {
        // 锁住
        lock.lock();
        //
        try {
            while (bool) {
                // 此处进行等待， 直到被唤醒
                condition.await();
            }
            for(int i = 0; i < 100; i++) {
                System.out.println("main thread seq of " + i + ", loop of " + loop);
            }
            bool = true;
            // 唤醒线程
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 最后一定要记得 释放锁, 不然很容易造成死锁
            lock.unlock();
        }
    }
    
    public void sub(int loop) {
        lock.lock();
        try {
          while(!bool) {
              condition.await();
          }
          for(int i = 0; i < 10; i++) {
              System.out.println("Sub thrread seq of " + i + ", loop of " + loop);
          }
          bool = false;
          condition.signal();
        } catch (Exception e) { 
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}