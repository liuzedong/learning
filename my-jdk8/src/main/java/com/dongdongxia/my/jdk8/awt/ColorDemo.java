package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 颜色案例</P>
 * @ClassName: ColorDemo
 * @author java_liudong@163.com  2017年12月7日 下午3:13:27
 */
public class ColorDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void paint(Graphics g) {
        Color c1 = new Color(255, 100, 100);
        Color c2 = new Color(100, 255, 100);
        Color c3 = new Color(100, 100, 255);
        
        g.setColor(c1);
        g.drawString("我是栋栋侠", 10, 20);
        
        g.setColor(c2);
        g.drawString("我是栋栋侠", 10, 40);
        
        g.setColor(c3);
        g.drawString("我是栋栋侠", 10, 60);
        
        g.drawRect(10, 150, 60, 50);
        g.drawRect(100, 150, 60, 50);
        g.fillRoundRect(190, 150, 60, 50, 15, 15);
        g.fillRoundRect(280, 150, 60, 50, 30, 40);
        
        setSize(390, 300);
    }

}
