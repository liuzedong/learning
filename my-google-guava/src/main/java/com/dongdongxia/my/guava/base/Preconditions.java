package com.dongdongxia.my.guava.base;

import javax.annotation.Nullable;

import com.dongdongxia.my.guava.annotations.GwtCompatible;

/**
 * 
 * <P>Description: 判断校验</P>
 * @ClassName: Preconditions
 * @author java_liudong@163.com  2017年8月30日 上午11:51:08
 */
@GwtCompatible
public final class Preconditions {

    private Preconditions() { }
    
    /**
     * 
     * <p>Title: checkArgument</p>
     * <p>Description: 直接校验true or false</p>
     * @param expression true or false
     * @author java_liudong@163.com  2017年8月30日 下午2:33:00
     */
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * 
     * <p>Title: checkArgument</p>
     * <p>Description: 根据入参，返回的错误描述</p>
     * @param expression true or false
     * @param errorMessage false is 错误描述
     * @author java_liudong@163.com  2017年8月30日 下午2:38:19
     */
    public static void checkArgument(boolean expression, @Nullable Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
    
    /**
     * 
     * <p>Title: checkArgument</p>
     * <p>Description: 判断</p>
     * @param expression 表达式
     * @param errorMessageTemplate 字符串模板
     * @param errorMessageArgs 填充字符串
     * @author java_liudong@163.com  2017年8月30日 下午3:14:11
     */
    public static void checkArgument(
            boolean expression,
            @Nullable String errorMessageTemplate,
            @Nullable Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
        }
    }
    
    
    /**
     * 
     * <p>Title: format</p>
     * <p>Description: 格式化字符串</p>
     * @param template 字符串
     * @param args 填充字符串
     * @return 格式化后字符串
     * @author java_liudong@163.com  2017年8月30日 下午2:44:51
     */
    static String format(String template, @Nullable Object... args) {
        template = String.valueOf(template); // null -> "null" , 如果为null就直接转换为 字符串的 "null"
        
        // 使用%s 进行替换, 此处给的初始值大小，超过时， StringBuilder会自动扩展
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart); // 占位符起始位置
            if (placeholderStart == -1) {
                break ;
            }
            builder.append(template, templateStart, placeholderStart); // 先添加 模板的，起点到占位符的结束点
            builder.append(args[i++]);
            templateStart = placeholderStart + 2; // +2 是因为%s 占用两位
        }
        builder.append(template, templateStart, template.length()); // 最后占位符，到最后的字符全部添加到模板字符创中
        
        // 如果，占位符少于格式化字符串，就把参数格式个剩下的参数打印出来
        if (i < args.length) {
            builder.append(" [");
            builder.append(args.length);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }
        return builder.toString();
    }
}
