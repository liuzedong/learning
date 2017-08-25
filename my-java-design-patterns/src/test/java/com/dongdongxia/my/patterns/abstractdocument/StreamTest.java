package com.dongdongxia.my.patterns.abstractdocument;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import javax.swing.JButton;

import org.junit.Test;

/**
 * 
 * <P>Description: 测试JDK8的java.util.stream.Stream<T>接口</P>
 * <p>学习Stream 的时候， 需要学习函数式编程</p>
 * @ClassName: StreamTest
 * @author java_liudong@163.com  2017年8月24日 上午10:44:57
 */
public class StreamTest {

	public static void main(String[] args) {
//		IntStream.of(new int[]{1, 2, 3}).forEach(System.out :: println);;
//		IntStream.range(1, 100).forEach(System.out::println);
		IntStream.rangeClosed(0, 100).forEach(System.out::println);
	}
	
	@Test
	public void lambda_01() {
		new Thread(() -> {
			System.out.println("我是栋栋侠，正在使用lambda表达式");	
		}).start();
	}
	
	@Test
	public void lambda_02() {
		JButton show = new JButton("Show");
		show.addActionListener((e) -> {
			System.out.println("这个按钮被点击啦。。。");
		});
	}
	
	@Test
	public void lambda_03() {
		List<String> features = Arrays.asList("刘东", "刘华", "张学友", "张国荣", "栋栋侠");
		features.forEach((n) -> {
			System.out.println(n.getClass().getName());
		});
		
		features.forEach(System.out::println);
	}
	
	@Test
	public void lambda_04() {
		List<String> names = Arrays.asList("刘东", "刘华", "张学友", "张国荣", "栋栋侠");
		System.out.println("所有名称'张'开头的 : ");
		filter(names, (str) -> str.startsWith("张"));
		
		System.out.println("所有名称'栋'开头的 : ");
		filter(names, (str) -> str.startsWith("栋"));
		
		System.out.println("所有名称'刘'开头的 : ");
		filter(names, (str) -> str.startsWith("刘"));
	}
	
	public void filter(List<String> names, Predicate<String> condition){
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
