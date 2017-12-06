package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 一个简单的滚动条</P>
 * @ClassName: SampleBanner
 * @author java_liudong@163.com  2017年12月6日 下午4:07:08
 */
public class SampleBanner extends Applet implements Runnable{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    
    String msg = "我 是 滚 动 条 ";
    Thread t = null;
    int state;
    volatile boolean stopFlag;
    
    @Override
    public void init() {
        setBackground(Color.cyan); // 青色
        setForeground(Color.red); // 前置色为红色
    }

    @Override
    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }

    @Override
    public void run() {
        for( ; ; ) {
            try {
                repaint(); // 重画
                Thread.sleep(1000);
                if (stopFlag) {
                    break ;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void stop() {
        stopFlag = true;
        t = null;
    }
    
    @Override
    public void paint(Graphics g) {
        char ch;
        
        // 将第一个字符， 放在字符串的最后面，一直循环
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
        msg += ch;
        
        g.drawString(msg, 50, 30);
    }
}
