package com.dongdongxia.my.jdk8.uitl;

import java.util.BitSet;

/**
 * 
 * <P>Description: BitSet 对象的使用</P>
 * @ClassName: BitSetDemo
 * @author java_liudong@163.com  2017年11月14日 上午9:57:34
 */
public class BitSetDemo {

    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(16);
        BitSet bitSet2 = new BitSet(16);
        
        // 向bitSet 中插入值
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bitSet1.set(i); 
            if ((i % 5) == 0) bitSet2.set(i);
        }
        
        System.out.println("bitSet1 的初始化 : ");
        System.out.println(bitSet1);

        System.out.println("bitSet2 的初始化 : ");
        System.out.println(bitSet2);
        
        // AND bit, 两个的交集
        bitSet2.and(bitSet1);
        System.out.println("\nbitSet2 AND bitSet1: ");
        System.out.println(bitSet2);
        
        // OR bit, 两个的并集
        bitSet2.or(bitSet1);
        System.out.println("\nbitSet2 OR bitSet1: ");
        System.out.println(bitSet2);
        
        // XOR bit, 两个的补集
        bitSet2.xor(bitSet1);
        System.out.println("\nbitSet2 XOR bitSet1: ");
        System.out.println(bitSet2);
    }
    
}
