package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 * 
 * <P>Description: 流式布局</P>
 * @ClassName: FlowLayoutDemo
 * @author java_liudong@163.com  2017年12月8日 下午1:55:19
 */
public class FlowLayoutDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    
    String msg;
    Checkbox c1, c2, c3;
    
    @Override
    public void init() {
        // 此处添加流式 布局, 默认是居中对齐
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // 创建三个复选框，添加到面板中
        c1 = new Checkbox("Java", null, true);
        c2 = new Checkbox("Linux");
        c3 = new Checkbox("Jenkins");
        
        add(c1);
        add(c2);
        add(c3);
        
        // 设置窗口大小
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        c1.addItemListener((e) -> repaint());
        c2.addItemListener((e) -> repaint());
        c3.addItemListener((e) -> repaint());
    }
    
    @Override
    public void paint(Graphics g) {
        msg = "当前多选框的状态：";
        g.drawString(msg, 6, 100);
        msg = "Java : " + c1.getState();
        g.drawString(msg, 6, 120);
        msg = "Linux : " + c2.getState();
        g.drawString(msg, 6, 140);
        msg = "Jenkis : " + c3.getState();
        g.drawString(msg, 6, 160);
    }
}
