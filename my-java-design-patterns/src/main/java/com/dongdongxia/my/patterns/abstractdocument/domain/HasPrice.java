package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Optional;

import com.dongdongxia.my.patterns.abstractdocument.Document;
/**
 * 
 * <P>Description: 价钱默认实现接口</P>
 * @ClassName: HasPrice
 * @author java_liudong@163.com  2017年8月26日 下午4:57:57
 */
public interface HasPrice extends Document {

    String PROPERTY = "price";
    
    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(PROPERTY));
    }
}
