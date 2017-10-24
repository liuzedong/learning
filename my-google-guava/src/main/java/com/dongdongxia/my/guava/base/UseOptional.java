package com.dongdongxia.my.guava.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: Optional 工具类的使用</P>
 * @ClassName: Optional
 * @author java_liudong@163.com  2017年10月24日 上午9:26:02
 */
public class UseOptional {

    private static final Logger LOGGER = LoggerFactory.getLogger(UseOptional.class);
    private static final String DELIMITER = "--------------------  --------------------";
    
    
    public static void main(String[] args) {
        LOGGER.info("Optional 工具类，测试开始{}", ".....");
        
        // JDK 也是拥有Optional的工具类， JDK1.8 开始拥有的
        boolean isNull = java.util.Objects.isNull(null);
        LOGGER.info("isNull : {}", isNull);
        
        LOGGER.info(DELIMITER);
        Integer i = new Integer(2);
        java.util.Optional<Integer> intOptional = java.util.Optional.of(i);
        boolean present = intOptional.isPresent();
        Integer orElse = intOptional.orElse(10);
        LOGGER.info("integer present : {}", present);
        LOGGER.info("integer orElse : {}", orElse);
        
    }
    
}
