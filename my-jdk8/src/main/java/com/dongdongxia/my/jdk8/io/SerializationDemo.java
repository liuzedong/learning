package com.dongdongxia.my.jdk8.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * <P>Description: 序列化和反序列化的使用示例</P>
 * @ClassName: SerializationDemo
 * @author java_liudong@163.com  2017年11月17日 下午3:54:29
 */
public class SerializationDemo {

    static final String FILE_PATH = "/tmp/serial";
    
    public static void main(String[] args) {
        try (ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            MyClass myClass = new MyClass("123", 2);
            objStream.writeObject(myClass);
            System.out.println(myClass);
        } catch (FileNotFoundException e) {
            System.out.println("File not fount " + e);
        } catch (IOException e) {
            System.out.println("I/O Exception " + e);
        }
        
        // 读取反序列
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object readObject = in.readObject();
            System.out.println(readObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MyClass implements Serializable {

    /**
     * @Fields serialVersionUID : 
     */
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    transient int age ;
    
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass [name=" + name + ", age=" + age + "]";
    }
}
