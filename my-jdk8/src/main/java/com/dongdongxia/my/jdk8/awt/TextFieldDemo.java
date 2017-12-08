package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;

/**
 * 
 * <P>Description: 文本框， 使用案例</P>
 * @ClassName: TextFieldDemo
 * @author java_liudong@163.com  2017年12月8日 上午10:01:15
 */
public class TextFieldDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    // 文本框和密码框
    TextField name, pass;
    
    @Override
    public void init() {
        Label namep = new Label("name: ", Label.RIGHT); // 左侧显示
        Label passp = new Label("pass: ", Label.RIGHT);
        
        name = new TextField(12); // 12个字符
        pass = new TextField(8);
        pass.setEchoChar('?'); // 输入的字符显示为?
        
        // 向面板中添加 组件
        add(namep);
        add(name);
        add(passp);
        add(pass);
        setSize(new Dimension(400,400));
        
        name.addTextListener((e) -> repaint());
        pass.addTextListener((e) -> repaint());
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString("Name: " + name.getText(), 6, 60);
        g.drawString("Selected text in name: " + name.getSelectedText(), 6, 80);
        g.drawString("Pass: " + pass.getText(), 6, 100);
    }

}
