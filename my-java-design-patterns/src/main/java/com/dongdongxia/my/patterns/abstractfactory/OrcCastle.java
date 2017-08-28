package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 兽族城堡</P>
 * @ClassName: OrcCastle
 * @author java_liudong@163.com  2017年8月28日 下午2:34:56
 */
public class OrcCastle implements Castle {

    static final String DESCRIPTION = "这是兽族的城堡";
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
