package com.dongdongxia.my.jdk8.awt.image;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * 
 * <P>Description: 在面板中加载图片，并以幻灯片的形式显示图片</P>
 * @ClassName: TrackedImageLoad
 * @author java_liudong@163.com  2017年12月11日 上午10:26:17
 */
public class TrackedImageLoad extends Applet implements Runnable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    MediaTracker tracker;
    int tracked;
    // 滚动的速度
    int frame_rate = 5;
    int current_img = 0;
    Thread motor;
    // 加载图片的上限
    static final int MAXIMAGES = 10;
    Image[] img = new Image[MAXIMAGES];
    String[] name = new String[MAXIMAGES];
    // 停止的状态
    volatile boolean stopFlag;
    
    // 图片的名称
    String IMG_NAME = "1+2+3+4+5+6+7+8+9+10";
    
    // 加载图片， 并将图片放入到MediaTracker 中
    @Override
    public void init() {
        tracker = new MediaTracker(this);
        
        StringTokenizer st = new StringTokenizer(IMG_NAME, "+");
        while(st.hasMoreTokens() && tracked <= MAXIMAGES) {
            name[tracked] = st.nextToken();
            try {
                img[tracked] = getImage(new URL("file:/home/liuzedong/图片/" + name[tracked] + ".jpg"));
                tracker.addImage(img[tracked], tracked);
                tracked++;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        String loaded = "";
        int donecount = 0; 
        
        for(int i = 0; i < tracked; i++) {
            if (tracker.checkID(i, true)) {
                donecount++;
                loaded += name[i] + "";
            }
        }
        
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        
        if (donecount == tracked) {
            frame_rate = 1;
            Image i = img[current_img];
            // 获取图片的大小
            int iw = i.getWidth(null);
            int ih = i.getHeight(null);
            
            g.drawImage(i, (w -iw) / 2, (h - ih) / 2, null);
            if(current_img >= tracked) {
                current_img = 0;
            }
        } else {
            int x = w * donecount / tracked;
            g.setColor(Color.black);
            g.fillRect(0, h/3, x, 16);
            g.setColor(Color.white);
            g.fillRect(x, h/3, w-x, 16);
            g.setColor(Color.black);
            g.drawString(loaded, 10, h/2);
        }
    }
    
    @Override
    public void start() {
        motor = new Thread(this);
        stopFlag = false;
        motor.start();
    }
    
    @Override
    public void stop() {
        stopFlag = true;
    }
    
    @Override
    public void run() {
        motor.setPriority(Thread.MIN_PRIORITY);
        while(true) {
            repaint();
            try {
                Thread.sleep(1000/frame_rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return ;
            }
            if(stopFlag) {
                return ;
            }
        }
    }

}
