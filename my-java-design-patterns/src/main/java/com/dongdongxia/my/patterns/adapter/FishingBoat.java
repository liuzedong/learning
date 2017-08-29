package com.dongdongxia.my.patterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 渔船</P>
 * @ClassName: FishingBoat
 * @author java_liudong@163.com  2017年8月29日 上午9:46:02
 */
public class FishingBoat {

    private static final Logger LOGGER = LoggerFactory.getLogger(FishingBoat.class);
    
    /**
     * 
     * <p>Title: sail</p>
     * <p>Description: 渔船自己的方法</p>
     * @author java_liudong@163.com  2017年8月29日 上午9:54:09
     */
    public void sail() {
        LOGGER.info("这个渔船正在航行。。。");
    }
}
