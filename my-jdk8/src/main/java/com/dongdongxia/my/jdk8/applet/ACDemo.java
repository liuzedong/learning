package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * <P>Description: 使用showDocument方法显示文本</P>
 * @ClassName: ACDemo
 * @author java_liudong@163.com  2017年12月6日 下午4:35:06
 */
public class ACDemo extends Applet{

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void paint(Graphics g) {
        AppletContext appletContext = getAppletContext();
        URL url = getCodeBase();
        
        try {
            // 将编译文本路径下的文件加载到面板中
            System.out.println(new URL(url + "Test.html"));
            appletContext.showDocument(new URL(url + "Test.html"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
