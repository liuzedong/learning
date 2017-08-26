package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Optional;

import com.dongdongxia.my.patterns.abstractdocument.Document;
/**
 * 
 * <P>Description: 类型默认实现接口</P>
 * @ClassName: HasModel
 * @author java_liudong@163.com  2017年8月26日 下午4:57:11
 */
public interface HasModel extends Document {

    String PROPERTY = "model";
    
    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
    
}
