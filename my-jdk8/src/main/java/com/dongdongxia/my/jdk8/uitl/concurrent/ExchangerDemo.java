package com.dongdongxia.my.jdk8.uitl.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 
 * <P>Description: 多个线程交换数据的案例</P>
 * @ClassName: ExchangerDemo
 * @author java_liudong@163.com  2017年11月24日 下午4:44:33
 */
public class ExchangerDemo {
    
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new UseString(exchanger);
        new MakeString(exchanger);
    }

}

class MakeString implements Runnable {

    Exchanger<String> ex;
    String str;
    
    MakeString(Exchanger<String> ex) {
        this.ex = ex;
        str = new String();
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        char ch = 'A';
        
        for (int i = 0; i < 3; i++) {
            // 装满缓存
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }
            
            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UseString implements Runnable {

    Exchanger<String> ex;
    String str;
    
    UseString(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Got : " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
