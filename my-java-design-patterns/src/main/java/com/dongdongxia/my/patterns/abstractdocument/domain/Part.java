package com.dongdongxia.my.patterns.abstractdocument.domain;

import java.util.Map;

import com.dongdongxia.my.patterns.abstractdocument.AbstractDocument;
/**
 * 
 * <P>Description: 汽车部件实体</P>
 * @ClassName: Part
 * @author java_liudong@163.com  2017年8月25日 上午9:59:41
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

    public Part(Map<String, Object> properties) {
        super(properties);
    }

}
