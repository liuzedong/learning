package com.dongdongxia.my.jdk8.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 函数接口的使用</P>
 * @ClassName: LambdaInteface
 * @author java_liudong@163.com  2017年10月24日 上午10:48:16
 */
@FunctionalInterface
public interface LambdaInterface {

    static final Logger LOGGER = LoggerFactory.getLogger(LambdaInterface.class);
    
    // 没有参数
    void function();
    
    // 一个静态方法
    static void function(Integer i) {
        LOGGER.info("{}", i);
    }
    
    // 一个参数
    default void function(String args1) {
        System.out.println(args1);
    }
    
    // 两个参数，并且有返回值
    default String function(String args1, String args2) {
        System.out.println(args1);
        System.out.println(args2);
        return String.format("args + args2 = %s + %s", args1, args2);
    }
}
