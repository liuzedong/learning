package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 一个简单的Applet　应用，用来设置背景色和前置色，和启动顺序</P>
 * @ClassName: Sample
 * @author java_liudong@163.com  2017年12月6日 下午3:57:38
 */
public class Sample extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    // 定义一个全局的变量， 用来想面板上面写文字
    String msg;
    
    @Override
    public void init() {
        setBackground(Color.cyan); // 青色
        setForeground(Color.red); // 前置色为红色
        msg = "Inside init() ---";
    }
    
    @Override
    public void start() {
        msg += "Inside start() ---";
    }
    
    @Override
    public void paint(Graphics g) {
        msg += "Inside paint() ---";
        g.drawString(msg, 10, 30);
    }
    
}