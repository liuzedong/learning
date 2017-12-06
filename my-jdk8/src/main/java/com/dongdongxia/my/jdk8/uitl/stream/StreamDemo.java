package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 
 * <P>Description: 流的各种操作</P>
 * @ClassName: StreamDemo
 * @author java_liudong@163.com  2017年12月4日 下午5:44:37
 */
public class StreamDemo {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(3);
        myList.add(12);
        myList.add(9);
        myList.add(55);
        myList.add(16);
        myList.add(78);
        myList.add(56);
        
        System.out.println("原数据: " + myList);
        
        Stream<Integer> myStream = myList.stream();
        
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if(minVal.isPresent()) {
            System.out.println("最小值: " + minVal.get());
        }
        
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if(maxVal.isPresent()) {
            System.out.println("最大值: " + maxVal.get());
        }
        
        // 排序
        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.println("排序后的值: ");
        sortedStream.forEach((n) -> {System.out.print(n + " ");});
        System.out.println();
        
        // 基数
        Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.println("基数值: ");
        oddVals.forEach((n) -> {System.out.print(n + " ");});
        System.out.println();
        
        // 过滤出 基数 且N 大于5的值
        oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1).filter((n) -> (n > 5));
        oddVals.forEach((n) -> {System.out.print(n + " ");});
        System.out.println();
    }
    
    
}
