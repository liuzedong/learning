package com.dongdongxia.my.micro.service.demo01.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dongdongxia.my.micro.service.demo01.entity.Entity;
import com.dongdongxia.my.micro.service.demo01.entity.Restaurant;
import com.dongdongxia.my.micro.service.demo01.service.impl.RestaurantService;

/**
 * 
 * <P>Description: 餐厅API接口</P>
 * @ClassName: RestaurantController
 * @author java_liudong@163.com  2017年9月20日 下午5:40:05
 */
@RestController
@RequestMapping("/v1/restaurant")
public class RestaurantController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);
    
    protected RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
    /**
     * 
     * <p>Title: findByName</p>
     * <p>Description: 根据名称查找餐厅， 名称不区分大小写
     * http://.../restaurant/rest
     * </p>
     * @param name 餐厅名称 
     * @return 返回一个非空的餐厅集合
     * @author java_liudong@163.com  2017年9月20日 下午5:45:17
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam(value = "name") String name) {
        LOGGER.info(String.format("餐厅服务 findByName() invoked:%s for %s", 
                restaurantService.getClass().getName(),
                name));
        name = name.toLowerCase().trim();
        Collection<Restaurant> restaurants;
        try {
            restaurants = restaurantService.findByName(name);
        } catch (Exception e) {
            LOGGER.warn("查找餐厅失败", e);
            return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurants.size() > 0 ? new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK) :
            new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 
     * <p>Title: findById</p>
     * <p>Description: 根据ID查找餐厅</p>
     * @param id 主键
     * @return 餐厅信息
     * @author java_liudong@163.com  2017年9月20日 下午6:16:08
     */
    @RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity<Restaurant>> findById(@PathVariable(value = "restaurant_id") String id) {
        LOGGER.info(String.format("餐厅服务 findById() invoked:%s for %s", 
                restaurantService.getClass().getName(),
                id));
        id.trim();
        Entity<Restaurant> restaurant;
        try {
            restaurant = restaurantService.findById(id);
        } catch (Exception e) {
            LOGGER.warn("查找餐厅失败", e);
            return new ResponseEntity<Entity<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurant != null ? new ResponseEntity<>(restaurant, HttpStatus.OK) : new ResponseEntity<Entity<Restaurant>>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 
     * <p>Title: add</p>
     * <p>Description: 添加餐厅</p>
     * @param restaurant 餐厅信息
     * @return 餐厅信息
     * @author java_liudong@163.com  2017年9月21日 上午9:45:29
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant) {
        LOGGER.info(String.format("餐厅服务 add() invoked:%s for %s", 
                restaurantService.getClass().getName(),
                restaurant.getName()));
        try {
            restaurantService.add(restaurant);
        } catch (Exception e) {
            LOGGER.warn("餐厅添加失败 : ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
