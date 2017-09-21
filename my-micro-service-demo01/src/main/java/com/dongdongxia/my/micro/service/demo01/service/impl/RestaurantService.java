package com.dongdongxia.my.micro.service.demo01.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.dongdongxia.my.micro.service.demo01.entity.Entity;
import com.dongdongxia.my.micro.service.demo01.entity.Restaurant;
import com.dongdongxia.my.micro.service.demo01.repository.RestaurantRepository;
import com.dongdongxia.my.micro.service.demo01.service.BaseService;
/**
 * 
 * <P>Description: 餐厅服务的实现</P>
 * @ClassName: RestaurantService
 * @author java_liudong@163.com  2017年9月20日 下午5:06:34
 */
@Service
public class RestaurantService extends BaseService<Restaurant, String> {
    
    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository repository) {
        super(repository);
        this.restaurantRepository = repository;
    }

    @Override
    public void add(Restaurant entity) throws Exception {
        if (restaurantRepository.containsName(entity.getName())) {
            throw new Exception(String.format("%s - 餐厅已经存在啦", entity.getName()));
        }
        
        if (entity.getName() == null || "".equals(entity.getName())) {
            throw new Exception("餐厅的名称不能为空");
        }
        
        restaurantRepository.add(entity);
    }
    
    /**
     * 
     * <p>Title: findByName</p>
     * <p>Description: 根据名称查找餐厅</p>
     * @param name 名称
     * @return 所有的餐厅
     * @throws Exception 异常
     * @author java_liudong@163.com  2017年9月20日 下午5:54:52
     */
    public Collection<Restaurant> findByName(String name) throws Exception{
        if (name == null || "".equals(name)) {
            throw new Exception("餐厅的名称不能为空");
        }
        // 暂时返回的是所有的，不限制 名称
        return restaurantRepository.getAll();
    }

    /**
     * 
     * <p>Title: findById</p>
     * <p>Description: 根据ID查询数据</p>
     * @param id 主键
     * @return 数据
     * @throws Exception 异常
     * @author java_liudong@163.com  2017年9月21日 上午9:39:42
     */
    public Entity<Restaurant> findById(String id) throws Exception {
        return restaurantRepository.get(id);
    }
}
