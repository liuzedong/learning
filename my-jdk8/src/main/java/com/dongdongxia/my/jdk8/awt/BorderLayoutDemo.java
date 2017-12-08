package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.Toolkit;

/**
 * 
 * <P>Description: 边框布局， 就是将面板， 分成， 东西南北中， 五个方向， 添加组件到面板中，同时添加位置</P>
 * @ClassName: BorderLayoutDemo
 * @author java_liudong@163.com  2017年12月8日 下午2:00:32
 */
public class BorderLayoutDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() {
        // 添加布局
        setLayout(new BorderLayout());
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        // 在不同方位 添加Button 
        add(new Button("上"), BorderLayout.NORTH);
        add(new Button("下"), BorderLayout.SOUTH);
        add(new Button("右边"), BorderLayout.EAST);
        add(new Label("左边"), BorderLayout.WEST);
        
        String val = "\tbash - GNU Bourne-Again SHell\n"
                + "bash [options] [command_string | file]\n"
                + "Bash is Copyright (C) 1989-2013 by the Free Software Foundation, Inc.\n"
                + "Bash  is  an  sh-compatible command language interpreter that executes commands read from the standard input or from a file.\n"
                + "Bash also incorporates useful features from the Korn and C shells (ksh and csh).\n"
                + "Bash is intended to be a conformant implementation of the Shell and Utilities portion of the IEEE POSIX specification (IEEE Standard 1003.1).\n"
                + "Bash can be configured  to  be POSIX-conformant by default.";
        
        TextArea ta = new TextArea(val);
        add(ta, BorderLayout.CENTER); // 添加到中间
    }

}
