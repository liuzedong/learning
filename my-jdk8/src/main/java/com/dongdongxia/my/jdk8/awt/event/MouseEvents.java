package com.dongdongxia.my.jdk8.awt.event;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * <P>Description: 监听鼠标</P>
 * @ClassName: MouseEvents
 * @author java_liudong@163.com  2017年12月7日 上午9:48:36
 */
public class MouseEvents extends Applet implements MouseListener, MouseMotionListener{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    String msg = "";
    int mouseX = 0, mouseY = 0; // 鼠标的默认位置
    
    @Override
    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        showStatus("鼠标拖动 : " + mouseX + ", " + mouseY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        showStatus("鼠标移动 : " + mouseX + ", " + mouseY);
        repaint();
    }

    // 鼠标点击事件
    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        msg = "鼠标点击啦";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "鼠标下压";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "鼠标释放";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        msg = "鼠标进入";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 0;
        mouseY = 10;
        msg = "鼠标离开";
        repaint();        
    }

}
