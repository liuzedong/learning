package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * 
 * <P>Description: Stream 的Spliterator 迭代方式， 使用的lambda表达式</P>
 * @ClassName: StreamDemo9
 * @author java_liudong@163.com  2017年12月6日 上午10:47:48
 */
public class StreamDemo9 {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        
        myList.add("刘一");
        myList.add("陈二");
        myList.add("张三");
        myList.add("李四");
        myList.add("王五");
        myList.add("赵六");
        myList.add("田七");
        
        Spliterator<String> spliterator = myList.stream().spliterator();
        
        while(spliterator.tryAdvance((n) -> System.out.println(n)));
        
        // 另外一个迭代方式
        System.out.println();
        System.out.println(" 使用 forEachRemaining 迭代: ");
        spliterator = myList.stream().spliterator();
        spliterator.forEachRemaining((n) -> System.out.println(n));
    }
}
