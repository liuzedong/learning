package com.dongdongxia.my.patterns.abstractfactory;
/**
 * 
 * <P>Description: 初始化兽族王国</P>
 * @ClassName: OrcKingdomFactory
 * @author java_liudong@163.com  2017年8月28日 下午2:44:37
 */
public class OrcKingdomFactory implements KingdomFactory {

    @Override
    public Castle createCastle() {
        return new OrcCastle();
    }

    @Override
    public King createKing() {
        return new OrcKing();
    }

    @Override
    public Army createArmy() {
        return new OrcArmy();
    }

}
