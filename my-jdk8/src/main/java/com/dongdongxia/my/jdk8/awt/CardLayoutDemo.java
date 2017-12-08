package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * <P>Description: 卡片布局</P>
 * @ClassName: CardLayoutDemo
 * @author java_liudong@163.com  2017年12月8日 下午2:23:59
 */
public class CardLayoutDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    Checkbox windowsXP, windows7, windows8, android, solaris, mac;
    Panel osCards;
    CardLayout cardLO;
    Button win, other;
    
    @Override
    public void init() {
        win = new Button("windows");
        other = new Button("other");
        
        add(win);
        add(other);
        
        // 创建布局和面板,并设置
        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO);
        
        // 创建两种不同的 多选框
        windowsXP = new Checkbox("windowsXP", null, true);
        windows7 = new Checkbox("windows7", null, false);
        windows8 = new Checkbox("windows8", null, false);
        
        android = new Checkbox("android");
        solaris = new Checkbox("solaris");
        mac = new Checkbox("mac");
        
        // 将上面不同的多选框， 添加到面板中
        Panel winPan = new Panel();
        winPan.add(windowsXP);
        winPan.add(windows7);
        winPan.add(windows8);
        
        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(solaris);
        otherPan.add(mac);
        
        // 将上面两个面板， 添加到一个总的面板中
        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");
        
        // 最后，将系统面板添加到 显示的面板中
        add(osCards);
        
        win.addActionListener((e) -> {
            if (win == e.getSource()) {
                cardLO.show(osCards, "Windows");
            } else {
                cardLO.show(osCards, "Other");
            }
        });
        
        other.addActionListener((e) -> {
            if (win == e.getSource()) {
                cardLO.show(osCards, "Windows");
            } else {
                cardLO.show(osCards, "Other");
            }
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cardLO.next(osCards);
            }
        });
    }

}
