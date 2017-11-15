package com.dongdongxia.my.jdk8.uitl;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * <P>Description: 定时器的使用示例</P>
 * @ClassName: TimerDemo
 * @author java_liudong@163.com  2017年11月14日 下午2:42:23
 */
public class TimerDemo {

    public static void main(String[] args) {
        MyTimerTask myTask = new MyTimerTask();
        Timer timer = new Timer();
        
        // 设置定时任务, 1000毫秒后执行， 500毫秒循环
        timer.schedule(myTask, 2000, 500);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        
        // 关闭定时任务
        timer.cancel();
    }
    
}


class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("定时器正在执行...");
    }
    
}