package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 文本居中显示</P>
 * @ClassName: CenterText
 * @author java_liudong@163.com  2017年12月7日 下午5:24:53
 */
public class CenterText extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void paint(Graphics g) {
        Dimension d = this.getSize();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.black);
        
        drawCenteredString("我是居中的文本", d.width, d.height, g);
        g.drawRect(0, 0, d.width - 1, d.height - 1);
    }
    
    // 将文字写在面板的中间
    void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

}
