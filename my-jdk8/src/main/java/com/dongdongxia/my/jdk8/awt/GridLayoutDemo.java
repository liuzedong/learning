package com.dongdongxia.my.jdk8.awt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;

/**
 * 
 * <P>Description: 网格布局 案例</P>
 * @ClassName: GridLayoutDemo
 * @author java_liudong@163.com  2017年12月8日 下午2:14:27
 */
public class GridLayoutDemo extends Applet {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;
    
    static final int N = 4; // 创建一个4 × 4 的网格布局
    
    @Override
    public void init() {
        setLayout(new GridLayout(N, N));

        setFont(new Font("文泉驿微米黑", Font.PLAIN, 12));
        
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = i * N + j;
                if (k > 0) {
                    add(new Button("" + k));
                }
            }
        }
    }

}
