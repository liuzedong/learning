package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * <P>Description: Fork/Join 有返回结果的 并行处理</P>
 * @ClassName: RecurTaskDemo
 * @author java_liudong@163.com  2017年12月4日 下午3:50:45
 */
public class RecurTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        
        double[] nums = new double[5000];
        
        // 如果是单数的话， 就设置 整数， 否则设置为负数
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }
        
        Sum2 task = new Sum2(nums, 0, nums.length);
        
        // 调用任务
        Double summation = pool.invoke(task);
        
        System.out.println("求和结果 : " + summation);
    }
    
}

/**
 * 
 * <P>Description: 创建累加</P>
 * @ClassName: Sum2
 * @author java_liudong@163.com  2017年12月4日 下午3:51:59
 */
class Sum2 extends RecursiveTask<Double> {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    final int seqThresHold = 500;
    
    double[] data;
    
    int start, end;
    
    Sum2(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Double compute() {
        double sum = 0;
        
        if ((end -start) < seqThresHold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            // 这里的是分割的任务
            int middle = (start + end) / 2;
            
            Sum2 sumTaskA = new Sum2(data, start, middle);
            Sum2 sumTaskB = new Sum2(data, middle, end);
            
            // 触发任务
            sumTaskA.fork();
            sumTaskB.fork();
            
            // 获取任务集 进行相加
            sum = sumTaskA.join() + sumTaskB.join();
        }
        return sum;
    }
    
}