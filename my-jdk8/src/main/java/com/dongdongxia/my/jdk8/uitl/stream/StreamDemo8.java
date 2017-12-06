package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * <P>Description: Stream 的迭代</P>
 * @ClassName: StreamDemo8
 * @author java_liudong@163.com  2017年12月6日 上午10:43:22
 */
public class StreamDemo8 {

    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        
        myList.add("刘一");
        myList.add("陈二");
        myList.add("张三");
        myList.add("李四");
        myList.add("王五");
        myList.add("赵六");
        myList.add("田七");
        
        Iterator<String> iterator = myList.stream().iterator();
        // 使用迭代进行遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
