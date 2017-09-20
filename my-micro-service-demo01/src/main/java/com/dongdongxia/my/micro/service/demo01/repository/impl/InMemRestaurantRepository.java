package com.dongdongxia.my.micro.service.demo01.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.dongdongxia.my.micro.service.demo01.entity.Entity;
import com.dongdongxia.my.micro.service.demo01.entity.Restaurant;
import com.dongdongxia.my.micro.service.demo01.repository.RestaurantRepository;
/**
 * 
 * <P>Description: 具体餐厅存储库的实现</P>
 * @ClassName: InMemRestaurantRepository
 * @author java_liudong@163.com  2017年9月20日 下午4:06:36
 */
public class InMemRestaurantRepository implements RestaurantRepository {

    // 暂时使用一个默认的Map进行装入实体，实际情况为数据库
    private Map<String, Restaurant> entities;
    
    public InMemRestaurantRepository() {
        entities = new HashMap<>();
    }
    
    @Override
    public void add(Restaurant entity) {
        entities.put(entity.getName(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(Restaurant entity) {
        if (entities.containsKey(entity.getName())) {
            entities.put(entity.getName(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("暂时没有此实现");
    }

    @Override
    public Entity<Restaurant> get(String id) {
        throw new UnsupportedOperationException("暂时没有此实现");
    }

    @Override
    public Collection<Restaurant> getAll() {
        return entities.values();
    }

    @Override
    public boolean containsName(String name) {
        return entities.containsKey(name);
    }

}
