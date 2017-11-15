package com.dongdongxia.my.jdk8.uitl;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 
 * <P>Description: 实现自己的比较器</P>
 * @ClassName: MyComp
 * @author java_liudong@163.com  2017年11月13日 下午2:30:03
 */
public class MyComp implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

class CompDemo {
    
    public static void main(String[] args) {
        // 创建一个TreeSet
        TreeSet<String> ts = new TreeSet<>(new MyComp());
        
        ts.add("B");
        ts.add("A");
        ts.add("E");
        ts.add("C");
        ts.add("F");
        
        for (String element : ts) {
            System.out.print(element + " ");
        }
        
        System.out.println();
    }
}