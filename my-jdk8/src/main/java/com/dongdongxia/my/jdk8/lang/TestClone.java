package com.dongdongxia.my.jdk8.lang;
/**
 * 
 * <P>Description: 测试Object 对象中的clone 方法</P>
 * @ClassName: TestClone
 * @author java_liudong@163.com  2017年11月10日 上午10:51:57
 */
public class TestClone implements Cloneable{

    int a;
    double b;
    TestClone cloneTest() {
        try {
            return (TestClone) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("不允许克隆");
            return this;
        }
    }
}

class CloneDemo {
    public static void main(String[] args) {
        TestClone x1 = new TestClone();
        TestClone x2;
        
        x1.a = 10;
        x1.b = 20.98;
        
        x2 = x1.cloneTest(); // 把x1 克隆 到x2
        System.out.format("x1: %s %s%n", x1.a, x1.b);
        System.out.format("x2: %s %s%n", x2.a, x2.b);
    }
}
