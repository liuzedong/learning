package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * <P>Description: 创建三个按钮的面板</P>
 * @ClassName: ButtonDemo
 * @author java_liudong@163.com  2017年12月7日 下午8:25:27
 */
public class ButtonDemo extends Applet implements ActionListener {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg = "";
    Button b1, b2, b3;
    
    @Override
    public void init() {
        setSize(new Dimension(400, 400));
        b1 = new Button("确定");
        b2 = new Button("取消");
        b3 = new Button("重置");
        add(b1);
        add(b2);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取Button上的字符
        String command = e.getActionCommand();
        
        if ("确定".equals(command)) {
            msg = "确定";
        } else if ("取消".equals(command)) {
            msg = "取消";
        } else if ("重置".equals(command)) {
            msg = "重置";
        }
        
        repaint();
    }
    
    

}
