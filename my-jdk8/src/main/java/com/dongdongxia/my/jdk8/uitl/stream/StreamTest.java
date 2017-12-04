package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <P>Description: forEach, Stream, parallel Stream 的性能测试</P>
 * @ClassName: StreamTest
 * @author java_liudong@163.com  2017年11月27日 上午9:57:31
 */
public class StreamTest {

    static List<Integer> myList = new ArrayList<>();
    
    public static void main(String[] args) {
        for (int i = 0; i < 50000000; i++) {
            myList.add(i);
        }
        int result = 0;
        long loopStartTime = System.currentTimeMillis();
        for (int i : myList) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        long loopEndTime = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("总耗时 : " + (loopEndTime - loopStartTime));
        
        
        // 下面是使用并行流
        long streamStartTime = System.currentTimeMillis();
        System.out.println(myList.stream().filter((value) -> value % 2 == 0).mapToInt(Integer::intValue).sum());
        long streamEndTime = System.currentTimeMillis();
        System.out.println("流总耗时 : " + (streamEndTime - streamStartTime));
        
        long parallelStreamStartTime = System.currentTimeMillis();
        System.out.println(myList.parallelStream().filter((value) -> value % 2 == 0).mapToInt(Integer::intValue).sum());
        long parallelStreamEndTime = System.currentTimeMillis();
        System.out.println("并行流总耗时 : " + (parallelStreamEndTime - parallelStreamStartTime));
    }
}