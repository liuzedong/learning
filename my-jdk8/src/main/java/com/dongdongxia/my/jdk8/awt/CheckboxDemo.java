package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 复选框案例</P>
 * @ClassName: CheckboxDemo
 * @author java_liudong@163.com  2017年12月7日 下午8:43:11
 */
public class CheckboxDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg;
    Checkbox c1, c2, c3;
    
    @Override
    public void init() {
        // 创建三个复选框，添加到面板中
        c1 = new Checkbox("Java", null, true);
        c2 = new Checkbox("Linux");
        c3 = new Checkbox("Jenkins");
        
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
        msg = "Java : " + c1.getState();
        g.drawString(msg, 6, 120);
        msg = "Linux : " + c2.getState();
        g.drawString(msg, 6, 140);
        msg = "Jenkis : " + c3.getState();
        g.drawString(msg, 6, 160);
    }

}
