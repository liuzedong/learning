package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * <P>Description: Callable 和 Future 的使用实例</P>
 * @ClassName: CallableDemo
 * @author java_liudong@163.com  2017年12月4日 上午9:44:58
 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;
        
        System.out.println("开始");
        
        f1 = es.submit(new Sum(10));
        f2 = es.submit(new Hypot(5D, 5D));
        f3 = es.submit(new Factorial(10));
        
        // 下面获取。 计算的结果
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println(e);
        }
        
        // 下面的是关闭线程池
        es.shutdown();
        System.out.println("结束");
    }
}

/**
 * 
 * <P>Description: 计算指定数值的递增</P>
 * @ClassName: Sum
 * @author java_liudong@163.com  2017年12月4日 上午9:48:18
 */
class Sum implements Callable<Integer> {

    int stop;
    
    Sum(int v) {
        this.stop = v;
    }
    
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

/**
 * 
 * <P>Description: 求两个数的平方根</P>
 * @ClassName: Hypot
 * @author java_liudong@163.com  2017年12月4日 上午9:51:40
 */
class Hypot implements Callable<Double> {

    double side1, side2;
    
    Hypot(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }
    
    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
    
}

/**
 * 
 * <P>Description: 求一个数值的阶层</P>
 * @ClassName: Factorial
 * @author java_liudong@163.com  2017年12月4日 上午9:52:55
 */
class Factorial implements Callable<Integer> {

    int stop;
    
    Factorial(int stop) {
        this.stop = stop;
    }
    
    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
    
}