package com.dongdongxia.my.jdk8.applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.net.URL;

/**
 * 
 * <P>Description: 读取本地文件，然后在面板中显示</P>
 * @ClassName: Bases
 * @author java_liudong@163.com  2017年12月6日 下午4:25:25
 */
public class Bases extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    
    @Override
    public void paint(Graphics g) {
        String msg;
        
        URL url = getCodeBase(); // 获取编译后的java代码
        
        msg = "Code base: " + url.toString();

        g.drawString(msg, 10, 20);
        
        url = getDocumentBase(); // 获取编译前的Java代码
        msg = "Document Base: " + url.toString();
        
        g.drawString(msg, 10, 40);
    }
}
