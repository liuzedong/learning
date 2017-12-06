package com.dongdongxia.my.jdk8.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * <P>Description: 远程服务的实现</P>
 * @ClassName: AddServiceImpl
 * @author java_liudong@163.com  2017年12月6日 下午2:16:06
 */
public class AddServiceImpl extends UnicastRemoteObject implements AddServiceIntf {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 1L;

    public AddServiceImpl() throws RemoteException {
        
    }

    @Override
    public double add(double d1, double d2) throws RemoteException {
        System.out.format("你请求的入参: %s , %s %n", d1, d2);
        return d1 + d2;
    }
}
