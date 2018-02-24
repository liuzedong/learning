package com.dongdongxia.my.jdk8.awt.image;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;

/**
 * 
 * <P>Description: 在内存中创建图像, 创建图片对象，使用的是MemoryImageSource 对象</P>
 * @ClassName: MemoryImageGenerator
 * @author java_liudong@163.com  2017年12月13日 上午10:07:39
 */
public class MemoryImageGenerator extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Image img;
    
    @Override
    public void init() {
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        // 创建面板大小的像素
        int[] pixels = new int[w * h];
        int i = 0;
        
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                int r = (x^y) & 0xff;
                int g = (x*2^y*2) & 0xff;
                int b = (x*4^y*4) & 0xff;
                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        // 使用像素在内存中创建对象
        img = createImage(new MemoryImageSource(w, h, pixels, 0, w));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }
}
