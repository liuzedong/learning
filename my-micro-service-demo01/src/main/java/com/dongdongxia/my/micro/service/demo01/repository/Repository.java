package com.dongdongxia.my.micro.service.demo01.repository;
/**
 *
 * <P>Description: 具体的存储库的操作</P>
 * @ClassName: Repository
 * @param <TE> 实体
 * @param <T> 主键
 * @author java_liudong@163.com  2017年9月20日 下午3:57:34
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    /**
     * 
     * <p>Title: add</p>
     * <p>Description: 添加实体</p>
     * @param entity 实体，比如桌子
     * @author java_liudong@163.com  2017年9月20日 下午3:58:28
     */
    void add(TE entity);
    
    /**
     * 
     * <p>Title: remove</p>
     * <p>Description: 移除实体</p>
     * @param id 实体ID
     * @author java_liudong@163.com  2017年9月20日 下午3:59:12
     */
    void remove(T id);
    
    /**
     * 
     * <p>Title: update</p>
     * <p>Description: 修改实体</p>
     * @param entity 实体信息
     * @author java_liudong@163.com  2017年9月20日 下午3:59:45
     */
    void update(TE entity);
}
