package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 
 * <P>Description: Fork/Join 并行框架的demo</P>
 * @ClassName: ForkJoinDemo
 * @author java_liudong@163.com  2017年12月4日 下午2:33:28
 */
public class ForkJoinDemo {
    
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        
        double[] nums = new double[100000];
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        
        System.out.println("一部分序列: ");
        
        for(int i = 0; i < 10; i++) {
            System.out.print(nums[i] + ", ");
        }
        
        System.out.println("\n");
        
        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
        
        pool.invoke(task);
        System.out.println("一部分已平方根的序列: ");
        for(int i = 0; i < 10; i++) {
            System.out.format("%.4f, ", nums[i]);
        }
        System.out.println();
        
        System.out.format("默认的并行级别 %s%n", pool.getParallelism());
        System.out.format("处理器个数 %s%n", Runtime.getRuntime().availableProcessors());
    }
}

/**
 * 
 * <P>Description: 并行计算 double数组中数字的平方根</P>
 * @ClassName: SqrtTransform
 * @author java_liudong@163.com  2017年12月4日 下午2:34:50
 */
class SqrtTransform extends RecursiveAction {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    // 一个分割的阀值
    final int seqThreshold = 1000;
    
    double[] data;
    
    int start, end;
    
    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for(int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
    
}
