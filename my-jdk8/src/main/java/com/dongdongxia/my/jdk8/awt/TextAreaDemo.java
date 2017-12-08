package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.TextArea;
import java.awt.Toolkit;

/**
 * 
 * <P>Description: 多行文本 显示</P>
 * @ClassName: TextAreaDemo
 * @author java_liudong@163.com  2017年12月8日 上午10:14:30
 */
public class TextAreaDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        String val = "\tbash - GNU Bourne-Again SHell\n"
                + "bash [options] [command_string | file]\n"
                + "Bash is Copyright (C) 1989-2013 by the Free Software Foundation, Inc.\n"
                + "Bash  is  an  sh-compatible command language interpreter that executes commands read from the standard input or from a file.\n"
                + "Bash also incorporates useful features from the Korn and C shells (ksh and csh).\n"
                + "Bash is intended to be a conformant implementation of the Shell and Utilities portion of the IEEE POSIX specification (IEEE Standard 1003.1).\n"
                + "Bash can be configured  to  be POSIX-conformant by default.";
        
        TextArea ta = new TextArea(val);
        add(ta);
        
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
}
