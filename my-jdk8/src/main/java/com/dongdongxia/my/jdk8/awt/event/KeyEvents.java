package com.dongdongxia.my.jdk8.awt.event;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * <P>Description: 键盘监听事件，并监听特殊按键</P>
 * @ClassName: KeyEvents
 * @author java_liudong@163.com  2017年12月7日 上午10:12:12
 */
public class KeyEvents extends Applet implements KeyListener{

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
        
        // 获取键盘码
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break ;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break ;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break ;
            case KeyEvent.VK_F4:
                msg += "<F4>";
                break ;
            case KeyEvent.VK_F5:
                msg += "<F5>";
                break ;
            case KeyEvent.VK_F6:
                msg += "<F6>";
                break ;
            case KeyEvent.VK_UP:
                msg += "^";
                break ;
            case KeyEvent.VK_DOWN:
                msg +="下";
                break ;
            case KeyEvent.VK_LEFT:
                msg += "<";
                break ;
            case KeyEvent.VK_RIGHT:
                msg += ">";
                break ;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        showStatus("键盘释放");
    }


}
