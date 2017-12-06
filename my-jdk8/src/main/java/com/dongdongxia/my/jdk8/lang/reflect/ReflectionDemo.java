package com.dongdongxia.my.jdk8.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * <P>Description: 使用反射案例， 反射出java.awt.Dimension 中的信息</P>
 * @ClassName: ReflectionDemo
 * @author java_liudong@163.com  2017年12月6日 上午11:33:40
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("java.awt.Dimension");
            System.out.println("构造信息: ");
            Constructor<?>[] constructors = c.getConstructors();
            for(int i = 0; i < constructors.length; i++) {
                System.out.println(constructors[i]);
            }
            
            System.out.println("字段信息: ");
            Field[] fields = c.getFields();
            for(int i = 0; i < fields.length; i++) {
                System.out.println(fields[i]);
            }
            
            System.out.println("方法信息: ");
            Method[] methods = c.getMethods();
            for(int i = 0; i < methods.length; i++)
                System.out.println(methods[i]);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
