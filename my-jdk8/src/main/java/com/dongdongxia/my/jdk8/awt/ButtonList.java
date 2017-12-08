package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * <P>Description: 按钮 集合</P>
 * @ClassName: ButtonList
 * @author java_liudong@163.com  2017年12月7日 下午8:33:14
 */
public class ButtonList extends Applet implements ActionListener {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg = "";
    Button[] bList = new Button[3];
    
    @Override
    public void init() {
        Button b1 = new Button("确认");
        Button b2 = new Button("取消");
        Button b3 = new Button("重置");
        
        bList[0] = (Button) add(b1);
        bList[1] = (Button) add(b2);
        bList[2] = (Button) add(b3);
        
        // 为每个按钮添加事件
        for(int i = 0; i < 3; i++) {
            bList[i].addActionListener(this);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 3; i++) {
            if (e.getSource() == bList[i]) { // getSource 是按下的对象
                msg = "按下的是: " + bList[i].getLabel();
            }
        }
        
        repaint();
    }
}
