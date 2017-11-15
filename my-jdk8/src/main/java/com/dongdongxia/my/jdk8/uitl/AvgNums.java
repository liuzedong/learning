package com.dongdongxia.my.jdk8.uitl;

import java.util.Scanner;

/**
 * 
 * <P>Description: 计算通过键盘输入的， 值的平均值</P>
 * @ClassName: AvgNums
 * @author java_liudong@163.com  2017年11月15日 上午9:46:35
 */
public class AvgNums {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = 0;
        double sum = 0.0D;
        
        System.out.format("输入计算的平均值: %n");
        
        while(scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
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
