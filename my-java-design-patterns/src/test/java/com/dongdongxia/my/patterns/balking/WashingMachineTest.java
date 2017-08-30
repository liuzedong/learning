package com.dongdongxia.my.patterns.balking;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
/**
 * 
 * <P>Description: 洗衣机功能测试</P>
 * @ClassName: WashingMachineTest
 * @author java_liudong@163.com  2017年8月30日 上午10:49:57
 */
public class WashingMachineTest {
    
    private volatile WashingMachineState machineStateGlobal;
    
    /**
     * 
     * <p>Title: wash</p>
     * <p>Description: 测试洗衣机的洗功能</p>
     * @author java_liudong@163.com  2017年8月30日 上午11:06:31
     */
    @Test
    public void wash() {
        WashingMachine washingMachine = new WashingMachine();
        ExecutorService executorService =  Executors.newFixedThreadPool(2); // 创建两个线程
        executorService.execute(washingMachine::wash);
        executorService.execute(() -> {
            washingMachine.wash();
            machineStateGlobal = washingMachine.getWashingMachineState(); // 获取当前洗衣机的状态
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS); // 延迟10 秒关闭所有线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(WashingMachineState.WASHING, machineStateGlobal);
    }
    
    /**
     * 
     * <p>Title: endOfWashing</p>
     * <p>Description: 测试洗完后的状态</p>
     * @author java_liudong@163.com  2017年8月30日 上午11:12:48
     */
    @Test
    public void endOfWashing() {
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.wash();
        assertEquals(WashingMachineState.ENABLED, washingMachine.getWashingMachineState());
    }
}
