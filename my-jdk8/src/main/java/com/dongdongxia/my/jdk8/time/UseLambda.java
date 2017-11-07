package com.dongdongxia.my.jdk8.time;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 使用 Lambda 表达式</P>
 * @ClassName: UseLambda
 * @author java_liudong@163.com  2017年10月24日 上午10:35:02
 */
public class UseLambda {

    private static final Logger LOGGER = LoggerFactory.getLogger(UseLambda.class);
    
    public static void main(String[] args) {
        LOGGER.info("Use Lambda function {} ....", "begin");
        Arrays.asList("刘东", "刘霞").forEach((String e) -> System.out.println(e));
        
        LOGGER.info("USE Lambda create {} impl", LambdaInterface.class);
        
        LambdaInterface lambadInterface = () -> {};
        lambadInterface.function("123", "445");
        
    }
    
    
    
}
