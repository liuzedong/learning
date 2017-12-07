package com.dongdongxia.my.jdk8.awt.event;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 
 * <P>Description:　键盘监听事件</P>
 * @ClassName: SampleKey
 * @author java_liudong@163.com  2017年12月7日 上午10:06:05
 */
public class SampleKey extends Applet implements KeyListener{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg = "";
    int X = 10, Y = 20;
    
    @Override
    public void init() {
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, X, Y);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // 获取键盘输入的值
        msg += e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        showStatus("键盘按下");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        showStatus("键盘释放");
    }

}
