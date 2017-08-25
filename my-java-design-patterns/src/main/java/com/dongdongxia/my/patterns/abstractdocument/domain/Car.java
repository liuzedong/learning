package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Map;

import com.dongdongxia.my.patterns.abstractdocument.AbstractDocument;

/**
 * 
 * <P>Description: 汽车实体</P>
 * @ClassName: Car
 * @author java_liudong@163.com  2017年8月24日 上午10:10:56
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts{

	public Car(Map<String, Object> properties) {
		super(properties);
	}

}
