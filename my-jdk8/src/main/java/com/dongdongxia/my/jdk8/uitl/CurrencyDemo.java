package com.dongdongxia.my.jdk8.uitl;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

/**
 * 
 * <P>Description: 货币对象的使用示例</P>
 * @ClassName: CurrencyDemo
 * @author java_liudong@163.com  2017年11月14日 下午3:31:11
 */
public class CurrencyDemo {

    public static void main(String[] args) {
        Currency c;
        
        c = Currency.getInstance(Locale.CHINA);
        
        // 打印当前地区的货币符号
        System.out.format("货币符号: %s%n", c.getSymbol());
        System.out.format("默认分数位数: %s%n", c.getDefaultFractionDigits());
        System.out.format("货币描述码: %s%n", c.getCurrencyCode());
        
        // 打印出所有的 货币描述: 货币码: 货币地区
        Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
        availableCurrencies.spliterator().forEachRemaining(
                (cur) -> System.out.println(cur.getSymbol() + " : " + cur.getCurrencyCode() + " : " + cur.getDisplayName()));
    }
}
