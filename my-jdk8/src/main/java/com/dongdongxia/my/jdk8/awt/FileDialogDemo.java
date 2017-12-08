package com.dongdongxia.my.jdk8.awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * <P>Description: 文件对话框 案例</P>
 * @ClassName: FileDialogDemo
 * @author java_liudong@163.com  2017年12月8日 下午3:37:22
 */
public class FileDialogDemo {

    public static void main(String[] args) {
        Frame f = new SampleFrame2("文件对话框案例");
        
        f.setVisible(true);
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        FileDialog fd = new FileDialog(f, "文件对话框");
        fd.setVisible(true);
    }
}

class SampleFrame2 extends Frame {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    SampleFrame2(String title) {
        super(title);
        
        addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
