package com.dongdongxia.my.micro.service.demo01.repository;

import java.util.Collection;

import com.dongdongxia.my.micro.service.demo01.entity.Entity;

/**
 * 
 * <P>Description: 存储库的只读接口</P>
 * @ClassName: ReadOnlyRepository
 * @param <TE> 实体
 * @param <T> 主键
 * @author java_liudong@163.com  2017年9月20日 下午3:50:57
 */
public interface ReadOnlyRepository<TE, T> {
    
    /**
     * 
     * <p>Title: contains</p>
     * <p>Description: 是否包含该桌子</p>
     * @param id 主键
     * @return 是否包含 true：包含， false 不包含
     * @author java_liudong@163.com  2017年9月20日 下午3:52:26
     */
    boolean contains(T id);
    
    /**
     * 
     * <p>Title: get</p>
     * <p>Description: 查询抽象主体的信息</p>
     * @param id 主键
     * @return 主体信息
     * @author java_liudong@163.com  2017年9月20日 下午3:53:49
     */
    Entity<TE> get(T id);
    
    /**
     * 
     * <p>Title: getAll</p>
     * <p>Description: 查询所有的主体</p>
     * @return 主体
     * @author java_liudong@163.com  2017年9月20日 下午3:55:26
     */
    Collection<TE> getAll();
}
