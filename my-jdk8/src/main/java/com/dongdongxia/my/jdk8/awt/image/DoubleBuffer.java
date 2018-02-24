package com.dongdongxia.my.jdk8.awt.image;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * 
 * <P>Description: 双缓冲， 在内存中画图像， 并显示在应用中</P>
 * @ClassName: DoubleBuffer
 * @author java_liudong@163.com  2017年12月8日 下午4:09:48
 */
public class DoubleBuffer extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    int gap = 3;
    int mx, my;
    boolean flicker = true;
    Image buffer = null;
    int w, h;
    
    @Override
    public void init() {
        Dimension d = getSize();
        w = d.width;
        h = d.height;
        
        // 创建跟面板一样大小的画板
        buffer = createImage(w, h);
        // 添加鼠标事件， 用来画图
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = false;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
                flicker = true;
                repaint();
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics screengc = null;
        
        if (!flicker) {
            screengc = g;
            g = buffer.getGraphics();
        }
        
        g.setColor(Color.blue);
        g.fillRect(0, 0, w, h);
        
        g.setColor(Color.red);
        for(int i = 0; i < w; i += gap) {
            g.drawLine(i, 0, w - i, h);
        }
        for(int i = 0; i < h; i += gap) {
            g.drawLine(0, i, w, h - i);
        }
        
        g.setColor(Color.black);
        g.drawString("按下", 10, h / 2);
        
        g.setColor(Color.yellow);
        g.fillOval(mx - gap, my - gap, gap*2 - 1, gap*2 + 1);
        
        if(!flicker) {
            screengc.drawImage(buffer, 0, 0, null);
        }
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
