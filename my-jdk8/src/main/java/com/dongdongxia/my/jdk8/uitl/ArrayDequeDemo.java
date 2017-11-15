package com.dongdongxia.my.jdk8.uitl;

import java.util.ArrayDeque;

/**
 * 
 * <P>Description: 数组队列</P>
 * @ClassName: ArrayDequeDemo
 * @author java_liudong@163.com  2017年11月13日 上午10:22:24
 */
public class ArrayDequeDemo {

    public static void main(String[] args) {
        ArrayDeque<String> adq = new ArrayDeque<>();
                
        
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        
        System.out.println("Popping the stack: ");
        
        while(adq.peek() != null) {
            System.out.print(adq.pop() + " ");
        }
        System.out.println();
    }
    
}
