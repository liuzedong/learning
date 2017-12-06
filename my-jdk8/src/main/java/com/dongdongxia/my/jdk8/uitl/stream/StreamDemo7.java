package com.dongdongxia.my.jdk8.uitl.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * <P>Description: 将流转换过成为 集合</P>
 * @ClassName: StreamDemo7
 * @author java_liudong@163.com  2017年12月6日 上午10:25:25
 */
public class StreamDemo7 {

    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        
        myList.add(new NamePhoneEmail("张三", "13409671111", "a@dongdongxia.cn"));
        myList.add(new NamePhoneEmail("李四", "13409672222", "b@dongdongxia.cn"));
        myList.add(new NamePhoneEmail("王五", "13409673333", "c@dongdongxia.cn"));
        
        Stream<NamePhone> nameAndPhone = myList.stream().map((n) -> new NamePhone(n.name, n.phoneNum));
        
        // 将流转换为集合
        List<NamePhone> namePhoneList = nameAndPhone.collect(Collectors.toList());
        System.out.println("下面是姓名和手机号的List集合: ");
        System.out.println(namePhoneList.getClass().getName());
        for (NamePhone namePhone : namePhoneList) {
            System.out.println(namePhone.name + " : " + namePhone.phoneNum);
        }
        
        // 分割
        System.out.println(); 
        
        // 下面的是， 将集合映射为stream ， 然后stream 转换为 set
        nameAndPhone = myList.stream().map((n) -> new NamePhone(n.name, n.phoneNum));
        
        Set<NamePhone> nameAndPhoneSet = nameAndPhone.collect(Collectors.toSet());
        System.out.println("下面是姓名和手机号的Set集合: ");
        System.out.println(nameAndPhoneSet.getClass().getName());
        for(NamePhone namePhone : nameAndPhoneSet) {
            System.out.println(namePhone.name + " : " + namePhone.phoneNum);
        }
        
    }
    
}

/**
 * 
 * <P>Description: 姓名, 手机, 邮箱</P>
 * @ClassName: NamePhoneEmail
 * @author java_liudong@163.com  2017年12月6日 上午10:25:57
 */
class NamePhoneEmail {
    
    String name;
    String phoneNum;
    String email;
    
    public NamePhoneEmail(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }
    
}

/**
 * 
 * <P>Description: 姓名, 手机</P>
 * @ClassName: NamePhone
 * @author java_liudong@163.com  2017年12月6日 上午10:27:11
 */
class NamePhone {
    
    String name;
    String phoneNum;
    
    public NamePhone(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}