package com.dongdongxia.my.guava.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * <P>Description: 表明一个类型可能会与 Google Web Toolkit 一起使用.如果一个方法使用这个注释,说明这个方法的返回值是 GWT 兼容的</P>
 * <p>Retention注解， 存在的时刻，RUNTIME 可以被虚拟机识别，CLASS只在class文件中保留，虚拟机不识别，SOURCE只在源码中保留，其他class和虚拟机都忽略</p>
 * <p>Target注解， 指定次注解在什么上面使用TYPE：类， METHOD： 方法</p>
 * <p>Documented注解，用于制定javadoc生成描述，默认javadoc是不生成注解的javadoc的</p>
 * @ClassName: GwtCompatible
 * @author java_liudong@163.com  2017年8月30日 上午11:26:24
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@GwtCompatible
public @interface GwtCompatible {

    /**
     * 
     * <p>Title: serializable</p>
     * <p>Description: 说明一个类型或者方法的返回值是否支持 GWT 序列化</p>
     * @return 是否
     * @author java_liudong@163.com  2017年8月30日 上午11:33:01
     */
    boolean serializable() default false;
    
    /**
     * 
     * <p>Title: emulated</p>
     * <p>Description: 说明一个类型是否在 GWT 被模拟.被模拟的源(父源)和JVM的实现不一样</p>
     * @return
     * @author java_liudong@163.com  2017年8月30日 上午11:33:23
     */
    boolean emulated() default false;
    
}
