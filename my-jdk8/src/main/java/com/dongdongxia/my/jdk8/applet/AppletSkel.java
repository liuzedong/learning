package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * 
 * <P>Description: 一个简单的Applet 应用骨架</P>
 * @ClassName: AppletSkel
 * @author java_liudong@163.com  2017年12月6日 下午3:40:12
 */
public class AppletSkel extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    // 初始化使用的
    @Override
    public void init() {
        
    }

    // 启动时候使用的
    @Override
    public void start() {
    }

    // 停止时候调用的
    @Override
    public void stop() {
    }
    
    // 摧毁时候调用的
    @Override
    public void destroy() {
    }

    // 向界面中写入信息
    @Override
    public void paint(Graphics g) {
        g.drawString("My name is Super DD", 0, 0);
    }
}
