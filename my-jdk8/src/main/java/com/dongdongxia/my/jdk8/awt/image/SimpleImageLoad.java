package com.dongdongxia.my.jdk8.awt.image;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * <P>Description: 加载图片并且在 应用中显示</P>
 * @ClassName: SimpleImageLoad
 * @author java_liudong@163.com  2017年12月8日 下午3:55:53
 */
public class SimpleImageLoad extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Image img;
    
    @Override
    public void init() {
        try {
            img = getImage(new URL("file:/home/liuzedong/图片/1.jpg"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

    @Override
    public void paint(Graphics g) {
        // 将图片 画在面板上面
        g.drawImage(img, 0, 0, this);
    }
}
