package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Choice;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 下拉列表 案例</P>
 * @ClassName: ChoiceDemo
 * @author java_liudong@163.com  2017年12月7日 下午8:56:14
 */
public class ChoiceDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    Choice c1, c2;
    String msg;
    
    @Override
    public void init() {
        // 初始化语言的列表
        c1 = new Choice();
        c1.add("Java");
        c1.add("Linux");
        c1.add("C++");
        
        // 文本类
        c2 = new Choice();
        c2.add("计算机网络基础");
        c2.add("计算机系统基础");
        c2.add("数据结构导论");
        
        add(c1);
        add(c2);
        
        c1.addItemListener((e) -> repaint());
        c2.addItemListener((e) -> repaint());
    }
    
    @Override
    public void paint(Graphics g) {
        msg = "当前选中的信息: ";
        g.drawString(msg, 6, 50);
        msg = "语言: " + c1.getSelectedItem();
        g.drawString(msg, 6, 70);
        msg = "书本: " + c2.getSelectedItem();
        g.drawString(msg, 6, 90);
    }
}
