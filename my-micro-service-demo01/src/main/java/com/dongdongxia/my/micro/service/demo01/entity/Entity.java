package com.dongdongxia.my.micro.service.demo01.entity;
/**
 * 
 * <P>Description: 抽象实体，所有实体都拥有的属性</P>
 * @ClassName: Entity
 * @param <T> 主键类型
 * @author java_liudong@163.com  2017年9月20日 下午3:50:11
 */
public abstract class Entity<T> {

    /**
     * 主键ID
     */
    T id;
    /**
     * 名称
     */
    String name;
    
}
