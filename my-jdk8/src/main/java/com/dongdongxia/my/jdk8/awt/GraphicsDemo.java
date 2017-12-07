package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * 
 * <P>Description: 在面板上面画图</P>
 * @ClassName: GraphicsDemo
 * @author java_liudong@163.com  2017年12月7日 下午2:36:35
 */
public class GraphicsDemo extends Applet implements MouseMotionListener{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg;
    int X, Y;
    
    @Override
    public void init() {
        addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        // 画线
        g.drawLine(0, 0, 100, 90);
        g.drawLine(0, 90, 100, 10);
        g.drawLine(40, 25, 250, 80);
        
        // 画矩形
        g.drawRect(10, 150, 60, 50);
        g.drawRect(100, 150, 60, 50);
        g.fillRoundRect(190, 150, 60, 50, 15, 15);
        g.fillRoundRect(280, 150, 60, 50, 30, 40);
        
        // 画椭圆和实心椭圆
        g.drawOval(10, 250, 50, 50);
        g.fillOval(90, 250, 75, 50);
        g.drawOval(190, 260, 100, 40);
        
        // 画弧度
        g.drawArc(10, 350, 70, 70, 0, 180);
        g.fillArc(60, 350, 70, 70, 0, 75);
        
        // 画多边形
        int[] xPoints = {10, 200, 10, 200, 10};
        int[] yPoints = {450, 450, 650, 650, 450};
        int nPoints = 5;
        g.drawPolygon(xPoints, yPoints, nPoints);
        
//        g.drawString(msg, X, Y);
        
        setSize(new Dimension(500, 800));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        msg = "鼠标位置: " + X + ", " + Y;
        showStatus(msg);
    }

}
