package com.dongdongxia.my.micro.service.demo01.service.impl;

import com.dongdongxia.my.micro.service.demo01.entity.Restaurant;
import com.dongdongxia.my.micro.service.demo01.repository.RestaurantRepository;
import com.dongdongxia.my.micro.service.demo01.service.BaseService;
/**
 * 
 * <P>Description: 餐厅服务的实现</P>
 * @ClassName: RestaurantService
 * @author java_liudong@163.com  2017年9月20日 下午5:06:34
 */
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
}
