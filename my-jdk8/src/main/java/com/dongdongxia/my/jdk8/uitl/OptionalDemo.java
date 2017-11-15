package com.dongdongxia.my.jdk8.uitl;

import java.util.Optional;

/**
 * 
 * <P>Description: Optional案例， 使用方式</P>
 * @ClassName: OptionalDemo
 * @author java_liudong@163.com  2017年11月14日 上午10:24:18
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty();
        
        Optional<String> hasVal = Optional.of("ABCDEFG");
        
        if (noVal.isPresent()) {
            System.out.println("这个不会显示");
        } else {
            System.out.println("noVal 里面没有值");
        }
        
        if (hasVal.isPresent()) {
            System.out.println("这个hasVal 的值 : " + hasVal.get());
        }
        
        
        // 如果值不存在， 就显示其他的值
        String defStr = noVal.orElse("显示的默认值");
        System.out.println(defStr);
        
    }
    
}
