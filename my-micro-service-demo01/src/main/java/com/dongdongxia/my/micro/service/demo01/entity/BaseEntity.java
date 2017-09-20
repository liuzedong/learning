package com.dongdongxia.my.micro.service.demo01.entity;
/**
 * 
 * <P>Description: 基础实体，用来抽象具体的方法</P>
 * @ClassName: BaseEntity
 * @param <T> 主键类型
 * @author java_liudong@163.com  2017年9月20日 下午3:49:47
 */
public class BaseEntity<T> extends Entity<T> {
    
    private T id;

    public BaseEntity(T id, String name) {
        this.id = id;
        super.name = name;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        super.name = name;
    }
}
