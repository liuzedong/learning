package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 显示默认字体的样式</P>
 * @ClassName: ShowFontStyle
 * @author java_liudong@163.com  2017年12月7日 下午4:47:40
 */
public class ShowFontStyle extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() {
        setSize(400, 400);
    }
    
    @Override
    public void paint(Graphics g) {
        Font font = g.getFont();
        
        String fontName = font.getFontName();
        int style = font.getStyle();
        int size = font.getSize();
        String family = font.getFamily();
        
        g.drawString("fontName: " + fontName
                + ",style: " + style
                + ",size: " + size
                + ",family: " + family, 10, 20);
        
    }

}
