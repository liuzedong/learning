package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 多个单选框， 属于一个组， 这样就是单选框啦</P>
 * @ClassName: CheckboxGropDemo
 * @author java_liudong@163.com  2017年12月7日 下午8:50:51
 */
public class CheckboxGropDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg;
    Checkbox c1, c2, c3;
    CheckboxGroup cbg;
    
    @Override
    public void init() {
        // 创建一个多选框的组
        cbg = new CheckboxGroup();
        
        // 创建三个复选框，添加到面板中
        c1 = new Checkbox("Java", cbg, false);
        c2 = new Checkbox("Linux", cbg, true);
        c3 = new Checkbox("Jenkins", cbg, false);
        
        add(c1);
        add(c2);
        add(c3);
        
        c1.addItemListener((e) -> repaint());
        c2.addItemListener((e) -> repaint());
        c3.addItemListener((e) -> repaint());
    }

    @Override
    public void paint(Graphics g) {
        msg = "当前多选框的状态：";
        g.drawString(msg, 6, 100);
        msg = "Java : " + c1.getState() + " " + c1.getLabel();
        g.drawString(msg, 6, 120);
        msg = "Linux : " + c2.getState() + " " + c2.getLabel();
        g.drawString(msg, 6, 140);
        msg = "Jenkis : " + c3.getState() + " " + c3.getLabel();
        g.drawString(msg, 6, 160);
    }
    
}
