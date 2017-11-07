package com.dongdongxia.my.jdk8.nio.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 日志测试</P>
 * @ClassName: Main
 * @author java_liudong@163.com  2017年11月7日 下午5:50:54
 */
public class Main {

    static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        LOGGER.debug("123");
        LOGGER.info("123");
        LOGGER.warn("123");
        LOGGER.error("123");
    }
}
