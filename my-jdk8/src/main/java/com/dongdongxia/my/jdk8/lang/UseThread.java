package com.dongdongxia.my.jdk8.lang;
/**
 * 
 * <P>Description: 线程与线程组的使用</P>
 * @ClassName: UseThread
 * @author java_liudong@163.com  2017年11月10日 上午11:48:31
 */
public class UseThread {

}


class NewThread extends Thread {
    
    // 暂停标记
    boolean suspendFlag;
    
    NewThread(String threadName, ThreadGroup tgOb) {
        super(tgOb, threadName);
        System.out.println("New Thread: " + this);
        suspendFlag = false;
        
        start(); // 运行这个线程
    }
    
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + " : " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " exiting.");
    }
    
    /**
     * 
     * <p>Title: mysuspendFlag</p>
     * <p>Description: 暂停</p>
     * @author java_liudong@163.com  2017年11月10日 下午2:34:27
     */
    synchronized void mysuspendFlag() {
        suspendFlag = true;
    }
    
    /**
     * 
     * <p>Title: myresume</p>
     * <p>Description: 重新开始</p>
     * @author java_liudong@163.com  2017年11月10日 下午2:34:12
     */
    synchronized void myresume() {
       suspendFlag = false;
       notify();
    }
}

class ThreadGroupDemo {
    
    public static void main(String[] args) {
        // 创建两个线程组
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");
        
        // 创建四个线程， 并且分配到两个线程组上
        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);
        
        System.out.println("\nHere is output from list() :");
        groupA.list();
        groupB.list();
        System.out.println();
        
        System.out.println("Suspending Group A");
        Thread[] tga = new Thread[groupA.activeCount()];
        groupA.enumerate(tga); // 将线程数组， copy 到另外一个中
        
        for (int i = 0; i < tga.length; i++) {
            ((NewThread)tga[i]).mysuspendFlag();
        }
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main 线程被打断啦");
        }
        
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (InterruptedException e) {
            System.out.println("Exception in Main thread");
        }
        
        System.out.println("主线程结束。。");
    }
}
