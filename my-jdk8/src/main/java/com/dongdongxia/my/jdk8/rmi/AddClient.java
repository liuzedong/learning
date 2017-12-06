package com.dongdongxia.my.jdk8.rmi;

import java.rmi.Naming;

/**
 * 
 * <P>Description: RMI 的客户端</P>
 * @ClassName: AddClient
 * @author java_liudong@163.com  2017年12月6日 下午2:21:48
 */
public class AddClient {

    public static void main(String[] args) {
        try {
            String addServerURL = "rmi://dongdongxia:6666/AddServer";
            AddServiceIntf addServiceIntf = (AddServiceIntf) Naming.lookup(addServerURL);
            
            // 定义两个参数， 给远程调用
            double d1 = 2.3, d2 = 4.4;
            System.out.format("%s + %s = ", d1, d2);
            
            System.out.println(addServiceIntf.add(d1, d2));
        } catch (Exception e) {
            System.err.println("Remote Client Error: " + e);
        }
    }
    
}
