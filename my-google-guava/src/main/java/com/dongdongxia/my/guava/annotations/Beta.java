package com.dongdongxia.my.guava.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * <P>Description: 表明一个公用API的未来版本是受不兼容变更或删除限制的,
 * 拥有这个注释标志的API不受任何兼容性保证</P>
 * @ClassName: Beta
 * @author java_liudong@163.com  2017年8月30日 上午11:38:22
 */
@Retention(RetentionPolicy.CLASS)
@Target({
    ElementType.ANNOTATION_TYPE, // 注解
    ElementType.CONSTRUCTOR, // 构造方法
    ElementType.FIELD, // 字段
    ElementType.METHOD, // 方法
    ElementType.TYPE // 对象
})
@Documented
@GwtCompatible
public @interface Beta {
}
