package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;

/**
 * 
 * <P>Description: 滚动条案例</P>
 * @ClassName: SBDemo
 * @author java_liudong@163.com  2017年12月7日 下午9:16:07
 */
public class SBDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    String msg = "";
    Scrollbar vertSB, horzSB;
    
    @Override
    public void init() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        vertSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, height);
        vertSB.setPreferredSize(new Dimension(20, 100));
        
        horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, width);
        horzSB.setPreferredSize(new Dimension(100, 20));
        
        add(vertSB);
        add(horzSB);
        
        vertSB.addAdjustmentListener((e) -> repaint());
        horzSB.addAdjustmentListener((e) -> repaint());
        
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                vertSB.setValue(y);
                horzSB.setValue(x);
                repaint();
            };
        });
        setSize(width, height);
    }
    
    @Override
    public void paint(Graphics g) {
        msg = "Vertical: " + vertSB.getValue();
        msg += ", Horizontal" + horzSB.getValue(); 
        g.drawString(msg, 6, 200);
        
        g.drawString("*", horzSB.getValue(), vertSB.getValue());
    }
    

}
