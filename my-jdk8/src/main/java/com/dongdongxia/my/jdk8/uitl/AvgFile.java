package com.dongdongxia.my.jdk8.uitl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * <P>Description: 从文件中读取数字， 进行平均值的计算</P>
 * @ClassName: AvgFile
 * @author java_liudong@163.com  2017年11月15日 上午10:11:12
 */
public class AvgFile {

    static final String fileName = "/tmp/test.txt";
    
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0D;
        
        FileWriter fw = new FileWriter(fileName);
        fw.write("2 3.4 5 6 0.5 7.8 9 done");
        fw.close();
        
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        
        while(scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                System.out.println(val);
                sum += val;
                count++;
            } else {
                if ("done".equals(scanner.next())) 
                    break;
                else {
                    System.out.format("Data format error.");
                    scanner.close();
                    return ;
                }
            }
        }
        
        scanner.close();
        System.out.format("平均值: %s%n", (sum / count));
        
    }
    
}
