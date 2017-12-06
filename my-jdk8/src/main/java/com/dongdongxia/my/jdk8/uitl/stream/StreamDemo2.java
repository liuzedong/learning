package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.Optional;

/**
 * 
 * <P>Description: TODO</P>
 * @ClassName: StreamDemo2
 * @author java_liudong@163.com  2017年12月5日 下午3:51:23
 */
public class StreamDemo2 {

    
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        
        myList.add(7);
        myList.add(8);
        myList.add(10);
        myList.add(14);
        myList.add(22);
        myList.add(19);
        
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a*b);
        
        if (productObj.isPresent()) {
            System.out.println("可选的产品: " + productObj.get());
        }
        
        Integer product = myList.stream().reduce(1, (a, b) -> a*b);
        System.out.println("可选的产品: " + product);
        
        
        System.out.println("流中的个数: " + myList.stream().count());
    }
}
