package com.dongdongxia.my.jdk8.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * <P>Description: 注册服务</P>
 * @ClassName: AddServer
 * @author java_liudong@163.com  2017年12月6日 下午2:18:09
 */
public class AddServer {

    public static void main(String[] args) {
        try {
            AddServiceImpl addServiceImpl = new AddServiceImpl();
//            Naming.bind("AddServer", addServiceImpl);
            LocateRegistry.createRegistry(6666);
            Naming.rebind("rmi://dongdongxia:6666/AddServer", addServiceImpl);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        
        
    }
}
