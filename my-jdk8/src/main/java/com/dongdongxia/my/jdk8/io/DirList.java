package com.dongdongxia.my.jdk8.io;

import java.io.File;
import java.io.IOException;

/**
 * 
 * <P>Description: 遍历目录下面的所有文件和目录</P>
 * @ClassName: DirList
 * @author java_liudong@163.com  2017年11月16日 上午9:14:41
 */
public class DirList {
    
    static final String FILE_NAME = "/usr/local/java/jdk-9";
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        File file = new File(FILE_NAME);
        dirList(file);
    }
    
    static void dirList(File file) {
        if (file.isDirectory()) { // 如果是目录
            String[] strs = file.list();
            for (int i = 0; i < strs.length; i++) {
                File f = new File(file, strs[i]);
                if (f.isDirectory()) {
                    System.out.format("%d %s 是目录%n", count++,  f);
                    dirList(f);
                } else {
                    System.out.format("%d %s 是文件%n", count++, f);
                }
            }
        } else {
            System.out.format("%d %s 是文件 %n", count++, file);
        }
    }
    
}