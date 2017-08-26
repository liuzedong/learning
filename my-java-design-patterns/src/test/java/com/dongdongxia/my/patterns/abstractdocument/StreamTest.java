package com.dongdongxia.my.patterns.abstractdocument;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import javax.swing.JButton;

import org.junit.Test;

/**
 * 
 * <P>Description: 测试JDK8的java.util.stream.Stream接口</P>
 * <p>学习Stream 的时候， 需要学习函数式编程</p>
 * @ClassName: StreamTest
 * @author java_liudong@163.com  2017年8月24日 上午10:44:57
 */
public class StreamTest {

    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 主接口</p>
     * @param args 参数
     * @author java_liudong@163.com  2017年8月26日 下午5:41:22
     */
    public static void main(String[] args) {
//        IntStream.of(new int[]{1, 2, 3}).forEach(System.out :: println);;
//        IntStream.range(1, 100).forEach(System.out::println);
        IntStream.rangeClosed(0, 100).forEach(System.out::println);
    }
    
    /**
     * 
     * <p>Title: lambda_01</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:41:42
     */
    @Test
    public void lambda01() {
        new Thread(() -> {
            System.out.println("我是栋栋侠，正在使用lambda表达式");    
        }).start();
    }
    
    /**
     * 
     * <p>Title: lambda02</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:43:28
     */
    @Test
    public void lambda02() {
        JButton show = new JButton("Show");
        show.addActionListener((e) -> {
            System.out.println("这个按钮被点击啦。。。");
        });
    }
    
    /**
     * 
     * <p>Title: lambda03</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:43:24
     */
    @Test
    public void lambda03() {
        List<String> features = Arrays.asList("刘东", "刘华", "张学友", "张国荣", "栋栋侠");
        features.forEach((n) -> {
            System.out.println(n.getClass().getName());
        });
        
        features.forEach(System.out::println);
    }
    
    /**
     * 
     * <p>Title: lambda04</p>
     * <p>Description: TODO</p>
     * @author java_liudong@163.com  2017年8月26日 下午5:43:18
     */
    @Test
    public void lambda04() {
        List<String> names = Arrays.asList("刘东", "刘华", "张学友", "张国荣", "栋栋侠");
        System.out.println("所有名称'张'开头的 : ");
        filter(names, (str) -> str.startsWith("张"));
        
        System.out.println("所有名称'栋'开头的 : ");
        filter(names, (str) -> str.startsWith("栋"));
        
        System.out.println("所有名称'刘'开头的 : ");
        filter(names, (str) -> str.startsWith("刘"));
    }
    
    /**
     * 
     * <p>Title: filter</p>
     * <p>Description: TODO</p>
     * @param names 遍历名称
     * @param condition lambda 表达式
     * @author java_liudong@163.com  2017年8月26日 下午5:42:35
     */
    public void filter(List<String> names, Predicate<String> condition) {
        /*for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }*/
        // 下面使用更好的办法
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ,");
        });;
    }
}
