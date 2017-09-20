package com.dongdongxia.my.micro.service.demo01.service;

import java.util.Collection;

import com.dongdongxia.my.micro.service.demo01.repository.Repository;

/**
 * 
 * <P>Description: 抽象基础服务</P>
 * @ClassName: BaseService
 * @param <TE> 实体
 * @param <T> 主键
 * @author java_liudong@163.com  2017年9月20日 下午4:21:52
 */
public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> inRepository;

    public BaseService(Repository<TE, T> repository) {
        super(repository);
        this.inRepository = repository;
    }
    
    /**
     * 
     * <p>Title: add</p>
     * <p>Description: 添加一个实体</p>
     * @param entity 实体
     * @throws Exception 异常
     * @author java_liudong@163.com  2017年9月20日 下午4:33:05
     */
    public void add(TE entity) throws Exception {
        inRepository.add(entity);
    }
    
    /***
     * 
     * <p>Title: getAll</p>
     * <p>Description: 查询所有实体信息</p>
     * @return 所有实体信息
     * @author java_liudong@163.com  2017年9月20日 下午4:24:23
     */
    public Collection<TE> getAll() {
        return inRepository.getAll();
    }
}
