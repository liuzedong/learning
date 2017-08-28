package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 精灵军队</P>
 * @ClassName: ElfArmy
 * @author java_liudong@163.com  2017年8月28日 下午2:31:32
 */
public class ElfArmy implements Army {

    static final String DESCRIPTION = "这是一个精灵军队";
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
