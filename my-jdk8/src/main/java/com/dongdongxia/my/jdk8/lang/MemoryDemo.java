package com.dongdongxia.my.jdk8.lang;
/**
 * 
 * <P>Description: 检测虚拟机内存， 使用Runtime 对象</P>
 * @ClassName: MemoryDemo
 * @author java_liudong@163.com  2017年11月9日 下午4:38:13
 */
public class MemoryDemo {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        long mem1, mem2;
        
        long K = 1024L;
        
        Integer[] someints = new Integer[1000];
        
        System.out.format("总内存是: %s B, %s M %n", r.totalMemory(), (r.totalMemory() / K / K));
        
        // 剩余的内存
        mem1 = r.freeMemory();
        System.out.format("首次剩余内存: %s B, %s M %n", mem1, (mem1 / K / K));
        
        // 进行一次GC 然后，再显示
        r.gc();
        mem1 = r.freeMemory();
        System.out.format("垃圾回收后的内存: %s B, %s M %n", mem1, (mem1 / K / K));
        
        // 将数组填满。 然后， 在看内存
        for (int i = 0; i < 1000; i++) {
            someints[i] = new Integer(i);
        }
        
        mem2 = r.freeMemory();
        System.out.format("使用后的内存: %s B, %s M %n", mem2, (mem2 / K / K));
        
        // 使用勒多少
        System.out.format("使用的内存: %s B, %s M %n", (mem1 - mem2), ((mem1 - mem2) / K / K));
        
        // 将数组置为 null ， 然后进行gc
        for (int i = 0; i < 1000; i++) {
            someints[i] = null;
        }
        
        r.gc();
        mem2 = r.freeMemory();
        System.out.format("将数组置为 null的内存: %s B, %s M %n", mem2, (mem2 / K / K));
        
    }
}