package com.dongdongxia.my.patterns.adapter;
/**
 * 
 * <P>Description: 适配器的使用类</P>
 * @ClassName: App
 * @author java_liudong@163.com  2017年8月29日 上午9:52:01
 */
public class App {

    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 应用</p>
     * @param args 入参
     * @author java_liudong@163.com  2017年8月29日 上午9:52:25
     */
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
    
}
