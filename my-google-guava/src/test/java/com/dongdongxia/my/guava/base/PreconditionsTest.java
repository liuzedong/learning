package com.dongdongxia.my.guava.base;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 判断校验对象的测试</P>
 * @ClassName: PreconditionsTest
 * @author java_liudong@163.com  2017年8月30日 上午11:57:38
 */
public class PreconditionsTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PreconditionsTest.class);
    
    /**
     * 
     * <p>Title: checkArgument</p>
     * <p>Description: 测试 boolean 值</p>
     * @author java_liudong@163.com  2017年8月30日 下午2:35:28
     */
    @Test
    public void checkArgumentTest01() {
        try {
            Preconditions.checkArgument(true);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    /**
     * 
     * <p>Title: checkArgumentTest02</p>
     * <p>Description: 异常并抛出指定的错误描述</p>
     * @author java_liudong@163.com  2017年8月30日 下午2:40:37
     */
    @Test
    public void checkArgumentTest02() {
        try {
            Preconditions.checkArgument(false, "我是打印出来的异常");
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
    /**
     * 
     * <p>Title: checkArgumentTest03</p>
     * <p>Description: 此处使用的错误异常， 并错误描述，字符串格式化</p>
     * @author java_liudong@163.com  2017年8月30日 下午3:06:45
     */
    @Test
    public void checkArgumentTest03() {
        try {
            Preconditions.checkArgument(false, "我是%s，他是%s", "栋栋侠", "刘东");
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            assertTrue(e instanceof IllegalArgumentException);
        }
    }
    
}
