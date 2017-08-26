package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Optional;

import com.dongdongxia.my.patterns.abstractdocument.Document;
/**
 * 
 * <P>Description: 类型默认接口</P>
 * @ClassName: HasType
 * @author java_liudong@163.com  2017年8月26日 下午5:38:29
 */
public interface HasType extends Document {

    String PROPERTY = "type";
    
    default Optional<String> getType() {
        return Optional.ofNullable((String) get(PROPERTY));
    }
}
