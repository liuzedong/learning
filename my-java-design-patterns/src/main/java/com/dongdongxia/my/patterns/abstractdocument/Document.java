package com.dongdongxia.my.patterns.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {

	/**
	 * 
	 * <p>Title: put</p>
	 * <p>Description: key中存入相关的value</p>
	 * @param key 键
	 * @param value 值 or null
	 * @return
	 * @author java_liudong@163.com  2017年8月24日 上午10:34:49
	 */
	Void put(String key, Object value);
	
	/**
	 * 
	 * <p>Title: get</p>
	 * <p>Description: 获取key对应的value值</p>
	 * @param key 键
	 * @return 值 或 null
	 * @author java_liudong@163.com  2017年8月24日 上午10:36:38
	 */
	Object get(String key);
	
	/**
	 * 
	 * <p>Title: children</p>
	 * <p>Description: 获取所有的孩子节点， 用Stream进行返回</p>
	 * @param key 键
	 * @param constructor 子类的构造器
	 * @return 子类的Stream
	 * @author java_liudong@163.com  2017年8月24日 上午10:41:19
	 */
	<T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
