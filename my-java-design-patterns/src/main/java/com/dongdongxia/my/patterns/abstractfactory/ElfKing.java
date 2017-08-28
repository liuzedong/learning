package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 精灵国王</P>
 * @ClassName: ElfKing
 * @author java_liudong@163.com  2017年8月28日 下午2:25:19
 */
public class ElfKing implements King {
    
    static final String DESCRIPTION = "这是一个精灵国王";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
