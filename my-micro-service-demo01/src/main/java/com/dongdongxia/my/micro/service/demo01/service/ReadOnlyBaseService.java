package com.dongdongxia.my.micro.service.demo01.service;

import com.dongdongxia.my.micro.service.demo01.repository.Repository;

/**
 * 
 * <P>Description: 只读公共服务抽象对象</P>
 * @ClassName: ReadOnlyBaseService
 * @param <TE> 实体
 * @param <T> 主键
 * @author java_liudong@163.com  2017年9月20日 下午4:15:48
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private Repository<TE, T> repository;

    ReadOnlyBaseService(Repository<TE, T> repository) {
        this.repository = repository;
    }

    public Repository<TE, T> getRepository() {
        return repository;
    }

    public void setRepository(Repository<TE, T> repository) {
        this.repository = repository;
    }
    
    
}
