package com.dongdongxia.my.micro.service.demo01.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <P>Description: 餐厅实体，内部有很多的桌子</P>
 * @ClassName: Restaurant
 * @author java_liudong@163.com  2017年9月20日 下午3:50:31
 */
public class Restaurant extends BaseEntity<String> {
    
    /**
     * 所有的桌子
     */
    private List<Table> tables = new ArrayList<>();
    
    public Restaurant(String id, String name, List<Table> tables) {
        super(id, name);
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
    
}
