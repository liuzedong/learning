package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 精灵城堡</P>
 * @ClassName: ElfCastle
 * @author java_liudong@163.com  2017年8月28日 下午2:36:34
 */
public class ElfCastle implements Castle {

    static final String DESCRIPTION = "这是精灵国城堡";
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
