package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 * 
 * <P>Description: Spilitrerator 中的 trySplit 方法的使用 拆分遍历</P>
 * <p>拆分， 并没有什么实际的用途， 但是对于大数据的时候， 这种并行处理， 会提升很大的性能</p>
 * @ClassName: StreamDemo10
 * @author java_liudong@163.com  2017年12月6日 上午10:54:15
 */
public class StreamDemo10 {

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
        
        Spliterator<String> trySplit = spliterator.trySplit();
        
        // 拆分后可能为空
        if (trySplit != null) {
            System.out.println("拆分后的结果: ");
            trySplit.forEachRemaining((n) -> System.out.println(n));
        }
        
        // 拆分前的结果
        System.out.println("拆分前的结果: ");
        spliterator.forEachRemaining((n) -> System.out.println(n));
    }
    
}
