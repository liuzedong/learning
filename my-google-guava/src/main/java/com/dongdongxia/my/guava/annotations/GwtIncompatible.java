package com.dongdongxia.my.guava.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <P>Description: 说明一个方法可能无法与 GWT 一起使用,他只能用于被 @GwtCompatible 标志的类的字段,方法和内部类</P>
 * @ClassName: GwtIncompatible
 * @author java_liudong@163.com  2017年8月30日 上午11:38:14
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Documented
@GwtCompatible
public @interface GwtIncompatible {

    /**
     * 
     * <p>Title: value</p>
     * <p>Description: 用于表示不兼容 GWT 的原因</p>
     * @return 原因
     * @author java_liudong@163.com  2017年8月30日 上午11:40:42
     */
    String value() default "";
}
