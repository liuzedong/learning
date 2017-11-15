package com.dongdongxia.my.jdk8.uitl;

import java.util.TreeSet;

/**
 * 
 * <P>Description: 使用Lambda 实现比较器</P>
 * @ClassName: CompDemo2
 * @author java_liudong@163.com  2017年11月13日 下午2:36:48
 */
public class CompDemo2 {

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>((strA, strB) -> strB.compareTo(strA));
        ts.add("B");
        ts.add("A");
        ts.add("V");
        ts.add("E");
        ts.add("F");
        
        for (String element : ts) {
            System.out.print(element + " ");
        }
        
        System.out.println();
    }
    
}
