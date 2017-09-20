package com.dongdongxia.my.micro.service.demo01.repository;

import com.dongdongxia.my.micro.service.demo01.entity.Restaurant;
/**
 * 
 * <P>Description: 餐厅，存储库的操作接口</P>
 * @ClassName: RestaurantRepository
 * @author java_liudong@163.com  2017年9月20日 下午4:02:46
 */
public interface RestaurantRepository extends Repository<Restaurant, String> {

    /**
     * 
     * <p>Title: containsName</p>
     * <p>Description: 根据名称查询餐厅信息</p>
     * @param name 名称
     * @return true：存在餐厅，false：不存在该餐厅
     * @author java_liudong@163.com  2017年9月20日 下午4:03:52
     */
    boolean containsName(String name);
}
