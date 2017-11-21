package com.dongdongxia.my.jdk8.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * <P>Description: DataInput 与 DataOutput 使用示例， 用来写入和读取基本数据类型</P>
 * @ClassName: DataIODemo
 * @author java_liudong@163.com  2017年11月17日 上午9:32:45
 */
public class DataIODemo {

    public static void main(String[] args) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("/tmp/Test.dat"))) {
            dout.writeDouble(98.6);
            dout.writeInt(123);
            dout.writeBoolean(true);
            dout.writeUTF("Super DD");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 读取这个文件
        try(DataInputStream din = new DataInputStream(new FileInputStream("/tmp/Test.dat"));) {
            double d = din.readDouble();
            int i = din.readInt();
            boolean b = din.readBoolean();
            String utf = din.readUTF();
            
            System.out.format("这些值是 %s %s %s %s %n", d, i, b, utf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}