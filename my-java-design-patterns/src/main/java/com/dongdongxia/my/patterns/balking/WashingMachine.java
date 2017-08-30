package com.dongdongxia.my.patterns.balking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 洗衣机</P>
 * @ClassName: WashingMachine
 * @author java_liudong@163.com  2017年8月30日 上午10:14:34
 */
public class WashingMachine {

    private static final Logger LOGGER = LoggerFactory.getLogger(WashingMachine.class);
    
    private WashingMachineState washingMachineState;
    
    /**
     * 
     * <p>Title: Constructor</p>
     * <p>Description: 构造方法，默认洗衣机是启动的</p>
     */
    public WashingMachine() {
        washingMachineState = WashingMachineState.ENABLED;
    }
    
    /**
     * 
     * <p>Title: getWashingMachineState</p>
     * <p>Description: 获取当前洗衣机的状态</p>
     * @return 洗衣机的状态
     * @author java_liudong@163.com  2017年8月30日 上午10:17:31
     */
    public WashingMachineState getWashingMachineState() {
        return this.washingMachineState;
    }
    
    /**
     * 
     * <p>Title: wash</p>
     * <p>Description: 洗衣服的动作</p>
     * @author java_liudong@163.com  2017年8月30日 上午10:18:30
     */
    public void wash() {
        synchronized (this) {
            LOGGER.info("{}: 实际洗衣机状态 ：{}", Thread.currentThread().getName(), getWashingMachineState());
            if (washingMachineState == WashingMachineState.WASHING) {
                LOGGER.error("ERROR : 不能洗衣服，因为洗衣机正在洗衣服");
                return ;
            }
            washingMachineState = WashingMachineState.WASHING;
        }
        LOGGER.info("{}: 正在洗衣服 ", Thread.currentThread().getName());
        try {
            Thread.sleep(50);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        endOfWashing();
    }
    
    /**
     * 
     * <p>Title: endOfWashing</p>
     * <p>Description: 洗完后的动作</p>
     * @author java_liudong@163.com  2017年8月30日 上午10:24:50
     */
    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        LOGGER.info("{} : 清洗完成 .", Thread.currentThread().getId());
    }
}
