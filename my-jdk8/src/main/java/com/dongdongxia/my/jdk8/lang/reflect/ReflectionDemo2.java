package com.dongdongxia.my.jdk8.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 
 * <P>Description: 利用反射获取私有方法</P>
 * @ClassName: ReflectionDemo2
 * @author java_liudong@163.com  2017年12月6日 上午11:42:46
 */
public class ReflectionDemo2 {

    public static void main(String[] args) {
        A a = new A();
        Class<? extends A> c= a.getClass();
        System.out.println("public methods : ");
        Method[] declaredMethods = c.getDeclaredMethods();
        for(int i = 0; i < declaredMethods.length; i++) {
            // System.out.println(declaredMethods[i]);
            // 获取所有方法的定义级别
            int modifiers = declaredMethods[i].getModifiers();
            if(Modifier.isPublic(modifiers)) {
                System.out.println(declaredMethods[i]);
            }
        }
        
    }
    
}

/**
 * 
 * <P>Description: 使用反射获取A对象中 的不通的方法</P>
 * @ClassName: A
 * @author java_liudong@163.com  2017年12月6日 上午11:44:37
 */
class A {
    public void a1() {
        
    }
    
    public void a2() {
        
    }
    
    protected void a3() {
        
    }
    
    @SuppressWarnings("unused")
    private void a4() {
        
    }
}