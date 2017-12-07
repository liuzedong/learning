package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * <P>Description: 修改窗口的大小</P>
 * @ClassName: ResizeMe
 * @author java_liudong@163.com  2017年12月7日 下午2:58:06
 */
public class ResizeMe extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;
    
    public ResizeMe() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max ? min : (d.width + inc);
                int h = (d.height + inc) > max ? min : (d.height + inc);
                setSize(new Dimension(w, h));
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        d = getSize();
        
        
        g.drawLine(0, 0, d.width - 1, d.height - 1);
        g.drawLine(0, d.height - 1, d.width - 1, 0);
        g.drawRect(0, 0, d.width - 1, d.height - 1);
    }
    
    
}
