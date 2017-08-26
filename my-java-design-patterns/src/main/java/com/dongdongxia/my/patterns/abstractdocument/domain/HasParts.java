package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.stream.Stream;

import com.dongdongxia.my.patterns.abstractdocument.Document;
/**
 * 
 * <P>Description: 配件默认实现接口</P>
 * @ClassName: HasParts
 * @author java_liudong@163.com  2017年8月26日 下午4:57:31
 */
public interface HasParts extends Document {

    String PROPERTY = "parts";
     
    default Stream<Part> getParts() {
        return children(PROPERTY, Part::new);
    }
}
