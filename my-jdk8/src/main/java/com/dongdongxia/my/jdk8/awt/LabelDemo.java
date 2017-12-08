package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Label;

/**
 * 
 * <P>Description: 在面板中创建三个 标签， 显示</P>
 * @ClassName: LabelDemo
 * @author java_liudong@163.com  2017年12月7日 下午8:19:45
 */
public class LabelDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() {
        setSize(new Dimension(400, 400));
        // 向面板添加 标签
        add(new Label("我是一号标签"));
        add(new Label("我是二号标签"));
        add(new Label("我是三号标签"));
    }
    
}
