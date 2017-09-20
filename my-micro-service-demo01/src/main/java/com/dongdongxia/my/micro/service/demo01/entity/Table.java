package com.dongdongxia.my.micro.service.demo01.entity;

import java.math.BigInteger;

/**
 * 
 * <P>Description: 桌子，餐厅桌子的实体</P>
 * @ClassName: Table
 * @author java_liudong@163.com  2017年9月20日 下午3:39:42
 */
public class Table extends BaseEntity<BigInteger> {

    /**
     * 容量
     */
    private int capacity;
    
    public Table(BigInteger id, String name, int capacity) {
        super(id, name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
