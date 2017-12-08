package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;

/**
 * 
 * <P>Description: 列表案例</P>
 * @ClassName: ListDemo
 * @author java_liudong@163.com  2017年12月7日 下午9:04:36
 */
public class ListDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    List l1, l2;
    String msg = "";

    @Override
    public void init() {
        setSize(new Dimension(400, 400));
        // 可以多选， true
        l1 = new List(3, true);
        l1.add("Java");
        l1.add("Linux");
        l1.add("C++");
        
        // 不能多选， false
        l2 = new List(3, false);
        l2.add("计算机网络基础");
        l2.add("计算机系统基础");
        l2.add("数据结构导论");
        
        add(l1);
        add(l2);
        
        l1.addItemListener((e) -> repaint());
        l2.addItemListener((e) -> repaint());
    }
    
    @Override
    public void paint(Graphics g) {
        //将上面选中的 信息显示出来
        int[] idx;
        
        msg = "当前选中的技术: ";
        idx = l1.getSelectedIndexes();
        for (int i = 0; i < idx.length; i++) {
            msg += l1.getItem(i) + " ";
        }
        g.drawString(msg, 6, 100);
        
        msg = "当前选中的课本: ";
        msg += l2.getSelectedItem() == null ? "" : l2.getSelectedItem();
        g.drawString(msg, 6, 120);
    }
    
}
