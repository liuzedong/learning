package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * <P>Description: 添加菜单选项的案例</P>
 * @ClassName: MenuDemo
 * @author java_liudong@163.com  2017年12月8日 下午2:48:33
 */
public class MenuDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Frame f;
    
    @Override
    public void init() {
        f = new MenuFrame("菜单示例");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        f.setVisible(true);
        
    }
    
}

class MenuFrame extends Frame {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    String msg = "";
    CheckboxMenuItem debug, test;
    
    MenuFrame(String title) {
        super(title);
        
        // 创建一个菜单选项，并添加
        MenuBar mbar = new MenuBar();
        setMenuBar(mbar);
        
        // 创建子菜单
        Menu file = new Menu("文件");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("新建"));
        file.add(item2 = new MenuItem("打开"));
        file.add(item3 = new MenuItem("关闭"));
        file.add(item4 = new MenuItem("-"));
        file.add(item5 = new MenuItem("离开"));
        mbar.add(file);
        
        // 创建修改的子菜单
        Menu edit = new Menu("修改");
        MenuItem item6, item7, item8, item9;
        edit.add(item6 = new MenuItem("剪切"));
        edit.add(item7 = new MenuItem("复制"));
        edit.add(item8 = new MenuItem("粘贴"));
        edit.add(item9 = new MenuItem("-"));
        // 下面是两个可选 菜单
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Testing");
        edit.add(test);
        mbar.add(edit);
        
        
        // 创建特殊的子菜单
        Menu sub = new Menu("特殊");
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("第一"));
        sub.add(item11 = new MenuItem("第二"));
        sub.add(item12 = new MenuItem("第三"));
        mbar.add(sub);
        
        MyMenuHandler handler = new MyMenuHandler(this);
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);
        debug.addItemListener(handler);
        test.addItemListener(handler);
        
        addWindowListener(new MyWindowAdapter3(this));
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 10, 200);
        
        if(debug.getState()) {
            g.drawString("Debug 被选中", 10, 220);
        } else {
            g.drawString("Debug 没有被选中", 10, 220);
        }
        
        if(test.getState()) {
            g.drawString("Test 被选中", 10, 240);
        } else {
            g.drawString("Test 没有被选中", 10, 240);
        }
    }
}

class MyWindowAdapter3 extends WindowAdapter {
    
    MenuFrame mf;
    
    MyWindowAdapter3(MenuFrame mf) {
        this.mf = mf;
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        mf.setVisible(false);
    }
}

class MyMenuHandler implements ActionListener, ItemListener {

    MenuFrame mf;
    
    MyMenuHandler(MenuFrame mf) {
        this.mf = mf;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        mf.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "你选中: ";
        String command = e.getActionCommand();
        
        if ("新建".equals(command)) {
            msg += "新建";
        } else if ("打开".equals(command)) {
            msg += "打开";
        } else if ("关闭".equals(command)) {
            msg += "关闭";
        } else if ("离开".equals(command)) {
            msg += "离开";
        } else if ("剪切".equals(command)) {
            msg += "剪切";
        } else if ("复制".equals(command)) {
            msg += "复制";
        } else if ("粘贴".equals(command)) {
            msg += "粘贴";
        } else if ("Debug".equals(command)) {
            msg += "Debug";
        } else if ("Testing".equals(command)) {
            msg += "Testing";
        } else if ("第一".equals(command)) {
            msg += "第一";
        } else if ("第二".equals(command)) {
            msg += "第二";
        } else if ("第三".equals(command)) {
            msg += "第三";
        }
        mf.msg = msg;
        mf.repaint();
    }
    
}
