package com.dongdongxia.my.patterns.balking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 阻塞模式的使用</P>
 * @ClassName: App
 * @author java_liudong@163.com  2017年8月30日 上午10:38:12
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 启动程序</p>
     * @param args 入参
     * @author java_liudong@163.com  2017年8月30日 上午10:39:15
     */
    public static void main(String[] args) {
        final WashingMachine washingMachine = new WashingMachine();
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建3个线程， 使用的是线程池
        
        for (int i = 0; i < 3; i++) {
            executorService.execute(washingMachine::wash);
        }
        
        executorService.shutdown(); // 关闭线程池
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS); // 10 秒后等待终止
        } catch (InterruptedException e) {
            LOGGER.error("ERROR : 正在等待服务关闭。。。");
        }
        
    }
}