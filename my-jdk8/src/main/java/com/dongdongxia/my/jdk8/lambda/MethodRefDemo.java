package com.dongdongxia.my.jdk8.lambda;
/**
 * 
 * <P>Description: 方法引用 使用示例</P>
 * @ClassName: MethodRefDemo
 * @author java_liudong@163.com  2017年12月5日 上午11:25:35
 */
public class MethodRefDemo {

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
    
    public static void main(String[] args) {
        String inStr = "My name is Super DD";
        String outStr;
        
        outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("源: " + inStr);
        System.out.println("结果: " + outStr);
    }
    
}

interface StringFunc {
    String func(String n);
}

class MyStringOps {
    
    // 将字符串颠倒
    static String strReverse(String str) {
        String result = "";
        int i;
        
        for(i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}