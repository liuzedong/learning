package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 王国初始化</P>
 * @ClassName: KingdomFactory
 * @author java_liudong@163.com  2017年8月28日 下午2:40:18
 */
public interface KingdomFactory {

    /**
     * 
     * <p>Title: createCastle</p>
     * <p>Description: 初始化城堡</p>
     * @return 城堡
     * @author java_liudong@163.com  2017年8月28日 下午2:40:47
     */
    Castle createCastle();
    
    /**
     * 
     * <p>Title: createKing</p>
     * <p>Description: 初始化国王</p>
     * @return 国王
     * @author java_liudong@163.com  2017年8月28日 下午2:41:24
     */
    King createKing();
    
    /**
     * 
     * <p>Title: createArmy</p>
     * <p>Description: 初始化军队</p>
     * @return 军队
     * @author java_liudong@163.com  2017年8月28日 下午2:41:48
     */
    Army createArmy();
}
