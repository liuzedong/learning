package com.dongdongxia.my.use.example.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class LiudongNamespaceHandler extends NamespaceHandlerSupport{

    @Override
    public void init() {
        registerBeanDefinitionParser("dongdongxia", new LiudongBeanDefinitionParser());
    }

}
