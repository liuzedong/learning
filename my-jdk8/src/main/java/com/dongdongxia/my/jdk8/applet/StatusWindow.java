package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 向窗口中输出 状态信息</P>
 * @ClassName: StatusWindow
 * @author java_liudong@163.com  2017年12月6日 下午4:19:25
 */
/*
 * <applet width=500 height=900></applet>
 */
public class StatusWindow extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() {
        setBackground(Color.cyan);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString("我是向窗口中输出的信息", 10, 20);
        showStatus("我是状态栏中输出的新"); // 这个会输出在窗口的下边框上面
    }
}
