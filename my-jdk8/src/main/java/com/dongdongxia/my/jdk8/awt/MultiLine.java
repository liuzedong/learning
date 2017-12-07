package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 显示多行文本</P>
 * @ClassName: MultiLine
 * @author java_liudong@163.com  2017年12月7日 下午5:07:29
 */
public class MultiLine extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    
    int curX = 0, curY = 0;
    
    @Override
    public void init() {
        setSize(400, 400);
    }
    
    @Override
    public void paint(Graphics g) {
        nextLine("我是第一行", g);
        nextLine("我是第二行", g);
        sameLine(" 我在后面一行", g);
        sameLine(" 我在后面二行", g);
        nextLine("我是第三行", g);
        curX = curY = 0;
    }
    
    // 显示下一行
    void nextLine(String str, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        
        // 当前行的我高度 累加
        curY += fm.getHeight();
        curX = 0;
        
        g.drawString(str, curX, curY);
        // 设置当前行的尾部 像素位置
        curX = fm.stringWidth(str);
    }
    
    // 行后面输出
    void sameLine(String str, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        g.drawString(str, curX, curY);
        // 尾部像素位置累加
        curX += fm.stringWidth(str);
    }
    
    
    
}
