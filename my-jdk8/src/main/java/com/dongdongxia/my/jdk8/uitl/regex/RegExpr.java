package com.dongdongxia.my.jdk8.uitl.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * <P>Description: 一个正则表达式的案例, matches() 方法， 是不会返回字序列的， 是精准匹配， 使用find() 方法， 可以发现</P>
 * @ClassName: RegExpr
 * @author java_liudong@163.com  2017年12月6日 上午11:17:27
 */
public class RegExpr {

    public static void main(String[] args) {
        Pattern pat;
        Matcher mat;
        boolean found;
        
        // 定义正则表达式
        pat = Pattern.compile("Java");
        mat = pat.matcher("Java");
        found = mat.matches(); // 检测是否匹配到
        
        System.out.println("测试是否检测到Java: ");
        if (found) {
            System.out.println("检测到啦");
        } else {
            System.out.println("没有检测到啦");
        }
        
        System.out.println();
        
        mat = pat.matcher("Java 8");
        found = mat.matches();
        
        System.out.println("测试是否检测到Java 8: ");
        if (found) {
            System.out.println("检测到啦");
        } else {
            System.out.println("没有检测到啦");
        }
        
        
        
        
    }
}
