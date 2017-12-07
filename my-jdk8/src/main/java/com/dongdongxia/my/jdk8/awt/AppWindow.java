package com.dongdongxia.my.jdk8.awt;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * <P>Description: 基于main 方法启动的窗口</P>
 * @ClassName: AppWindow
 * @author java_liudong@163.com  2017年12月7日 上午11:11:55
 */
public class AppWindow extends Frame {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    String keyMsg = "这是测试 : ";
    String mouseMsg = "";
    int mouseX = 30, mouseY = 30;
    
    public AppWindow() {
        addKeyListener(new MyKeyAdapter(this));
        addMouseListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter2());
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString(keyMsg, 10, 40);
        g.drawString(mouseMsg, mouseX, mouseY);
    }
    
    public static void main(String[] args) {
        // 启动窗口
        AppWindow appWindow = new AppWindow();
        appWindow.setSize(new Dimension(500, 500));
        appWindow.setTitle("我是测试AppWindow 窗口");
        appWindow.setVisible(true);
    }
}

// 键盘事件
class MyKeyAdapter extends KeyAdapter {
    
    AppWindow appWindow;
    
    public MyKeyAdapter(AppWindow appWindow) {
        this.appWindow = appWindow;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        appWindow.keyMsg += e.getKeyChar();
        appWindow.repaint();
    }
}

// 鼠标事件
class MyMouseAdapter extends MouseAdapter {
    
    AppWindow appWindow;
    
    public MyMouseAdapter(AppWindow appWindow) {
        this.appWindow = appWindow;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        appWindow.mouseX = e.getX();
        appWindow.mouseY = e.getY();
        appWindow.mouseMsg = "鼠标按下的位置: " + appWindow.mouseX + ", " + appWindow.mouseY;
        appWindow.repaint();
    }
}

// 窗口事件
class MyWindowAdapter2 extends WindowAdapter {
    
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
