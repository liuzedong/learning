package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 兽族军队</P>
 * @ClassName: OrcArmy
 * @author java_liudong@163.com  2017年8月28日 下午2:30:04
 */
public class OrcArmy implements Army {

    static final String DESCRIPTION = "这是一个兽族军队";
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
