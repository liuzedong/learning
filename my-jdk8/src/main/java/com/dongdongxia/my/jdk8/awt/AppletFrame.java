package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * <P>Description: 使用Frame 框架初始化 面板</P>
 * @ClassName: AppletFrame
 * @author java_liudong@163.com  2017年12月7日 上午10:53:32
 */
public class AppletFrame extends Applet implements MouseListener{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Frame f;
    
    @Override
    public void init() {
        // 初始化面板
        f = new SampleFrame("一个Frame面板");
        
        f.setSize(250, 250);
        f.setVisible(true);
        
        // 设置鼠标事件
        addMouseListener(this);
    }
    
    @Override
    public void start() {
        f.setVisible(true);
    }
    
    @Override
    public void stop() {
        f.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("一个Applet面板", 10, 20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean b = f.isVisible();
        if (b)
            f.setVisible(false);
        else
            f.setVisible(true);
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        f.setVisible(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        f.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}

class SampleFrame extends Frame {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    public SampleFrame(String title) {
        super(title);
        
        addWindowListener(new MyWindowAdapter(this));
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString("这个Frame 面板", 10, 40);
    }
}

class MyWindowAdapter extends WindowAdapter {
    
    SampleFrame sampleFrame;
    
    public MyWindowAdapter(SampleFrame sampleFrame) {
        this.sampleFrame = sampleFrame;
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        sampleFrame.setVisible(false);
    }
    
}
