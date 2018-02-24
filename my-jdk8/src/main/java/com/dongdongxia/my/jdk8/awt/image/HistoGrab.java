package com.dongdongxia.my.jdk8.awt.image;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.PixelGrabber;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * <P>Description: 抓取图片中的像素值</P>
 * @ClassName: HistoGrab
 * @author java_liudong@163.com  2017年12月13日 下午4:44:47
 */
public class HistoGrab extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Dimension d;
    Image img;
    int iw, ih;
    int[] pixels;
    int w, h;
    int[] hist = new int[256];
    int max_hist = 0;
    
    @Override
    public void init() {
        d = getSize();
        w = d.width;
        h = d.height;
        
        try {
            img = getImage(new URL("file:/home/liuzedong/图片/1.jpg"));
            MediaTracker t = new MediaTracker(this);
            
            t.addImage(img, 0);
            t.waitForID(0);
            iw = img.getWidth(null);
            ih = img.getHeight(null);
            
            pixels = new int[iw * ih];
            // 加载图片的像素，放入到pixels
            PixelGrabber pg = new PixelGrabber(img, 0, 0, iw, ih, pixels, 0, iw);
            
            pg.grabPixels();
        } catch (MalformedURLException | InterruptedException e) {
            e.printStackTrace();
            return ;
        }
        
        for(int i = 0; i < iw * h; i++) {
            int p = pixels[i];
            int r = 0xff & (p << 16);
            int g = 0xff & (p << 8);
            int b = 0xff & (p);
            int y = (int) (.33 * r + .56 * g + .11 * b);
            hist[y]++;
        }
        
        for(int i = 0; i < 256; i++) {
            if(hist[i] > max_hist) {
                max_hist = hist[i];
            }
        }
    }
    
    public void update() {
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
        int x = (w - 256) / 2;
        int lasty = h - h * hist[0] / max_hist;
        
        for(int i = 0; i < 256; i++,x++) {
            int y = h - h * hist[i] / max_hist;
            g.setColor(new Color(i, i, i));
            g.fillRect(x, y, 1, h);
            g.setColor(Color.red);
            g.drawLine(x - 1, lasty, x, y);
            lasty = y;
        }
    }
}
