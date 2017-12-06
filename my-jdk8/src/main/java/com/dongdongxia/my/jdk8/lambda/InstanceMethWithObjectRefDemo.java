package com.dongdongxia.my.jdk8.lambda;
/**
 * 
 * <P>Description: demo</P>
 * @ClassName: InstanceMethWithObjectRefDemo
 * @author java_liudong@163.com  2017年12月5日 下午2:29:28
 */
public class InstanceMethWithObjectRefDemo {

    static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int count;
        
        HighTemp[] weekDayHighs = {new HighTemp(89), new HighTemp(82), new HighTemp(90), new HighTemp(89), new HighTemp(89),
                new HighTemp(91), new HighTemp(84), new HighTemp(83)};
        
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(12));
        System.out.println(count + " days had a high of 12");
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println(count + " days had a high less than 89");
    }
}

interface MyFunc<T> {
    
    boolean func(T v1, T v2);
}

class HighTemp {
    
    private int hTemp;
    
    HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }
    
    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }
    
    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}