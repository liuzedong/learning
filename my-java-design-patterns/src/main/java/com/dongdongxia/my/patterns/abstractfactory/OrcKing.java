package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 兽族国王实体</P>
 * @ClassName: OrcKing
 * @author java_liudong@163.com  2017年8月28日 下午2:20:33
 */
public class OrcKing implements King {

    static final String DESCRIPTION = "这是一个兽族国王";
    
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
