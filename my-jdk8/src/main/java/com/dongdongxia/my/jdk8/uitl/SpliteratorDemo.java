package com.dongdongxia.my.jdk8.uitl;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * 
 * <P>Description: JDK 8 的并行遍历</P>
 * @ClassName: SpliteratorDemo
 * @author java_liudong@163.com  2017年11月13日 上午10:57:53
 */
public class SpliteratorDemo {

    public static void main(String[] args) {
        ArrayList<Double> vals = new ArrayList<>();
        
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);
        
        System.out.println("所有的数字: ");
        
        // 使用tryAdvance() 方法进行遍历
        Spliterator<Double> spliterator = vals.spliterator();
        while (spliterator.tryAdvance((n) -> System.out.println(n)));
        System.out.println();
        
        spliterator = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while(spliterator.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
        
        // 下面是打印新的数组
        System.out.println("新的所有数字: ");
        spliterator = sqrs.spliterator();
        spliterator.forEachRemaining((n) -> System.out.println(n));
        
        System.out.println();
    }
    
}
