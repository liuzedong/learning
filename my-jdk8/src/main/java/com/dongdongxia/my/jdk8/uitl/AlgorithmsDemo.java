package com.dongdongxia.my.jdk8.uitl;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 
 * <P>Description: Collections 算法类的使用</P>
 * @ClassName: AlgorithmsDemo
 * @author java_liudong@163.com  2017年11月13日 下午3:49:30
 */
public class AlgorithmsDemo {

    
    public static void main(String[] args) {
        // 创建一个LinkedList
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(-8);
        ll.add(20);
        ll.add(-20);
        ll.add(8);
        
        // 创建一个 排序翻转 的 接口
        Comparator<Integer> r = Collections.reverseOrder();
        
        // 使用上面的排序规则进行排序
        Collections.sort(ll, r);
        
        System.out.println("List 的反向自然排序: ");
        for (int i : ll) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 清理集合, 再输出， 就不会有原先的排序啦
        Collections.shuffle(ll);
        System.out.println("List shuffled: ");
        for (int i : ll) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        // 下面是打印出集合中，的最大值和最小值
        System.out.format("最大值: %s%n", Collections.max(ll));
        System.out.format("最小值: %s%n", Collections.min(ll));
    }
}
