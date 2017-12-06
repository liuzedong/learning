package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 
 * <P>Description: 流API map 映射</P>
 * @ClassName: StreamDemo4
 * @author java_liudong@163.com  2017年12月5日 下午4:11:52
 */
public class StreamDemo4 {

    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);
        
        Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));
        
//        sqrtRootStrm.forEachOrdered((a) -> System.out.println(a));
        
        Double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a*b);
        System.out.println("计算的结果: " + productOfSqrRoots);
        
        
    }
    
}
