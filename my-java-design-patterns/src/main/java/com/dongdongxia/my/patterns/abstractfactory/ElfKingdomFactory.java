package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 精灵国家初始化</P>
 * @ClassName: ElfKingdomFactory
 * @author java_liudong@163.com  2017年8月28日 下午2:42:48
 */
public class ElfKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new ElfCastle();
    }

    @Override
    public King createKing() {
        return new ElfKing();
    }

    @Override
    public Army createArmy() {
        return new ElfArmy();
    }

}
