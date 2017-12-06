package com.dongdongxia.my.jdk8.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * <P>Description: Remote 接口， 用来实现两个数字相加</P>
 * @ClassName: AddServiceIntf
 * @author java_liudong@163.com  2017年12月6日 下午2:14:19
 */
public interface AddServiceIntf extends Remote {

    double add(double d1, double d2) throws RemoteException;
}
