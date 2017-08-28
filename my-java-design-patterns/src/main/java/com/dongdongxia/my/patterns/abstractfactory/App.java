package com.dongdongxia.my.patterns.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <P>Description: 抽象工厂的使用</P>
 * @ClassName: App
 * @author java_liudong@163.com  2017年8月28日 下午2:46:04
 */
public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    private King king;
    private Castle castle;
    private Army army;
    
    /**
     * 
     * <p>Title: createKingdom</p>
     * <p>Description: 创建王国</p>
     * @param factory 创建王国的工厂
     * @author java_liudong@163.com  2017年8月28日 下午2:49:02
     */
    public void createKingdom(final KingdomFactory factory) {
        setKing(factory.createKing());
        setArmy(factory.createArmy());
        setCastle(factory.createCastle());
    }

    /**
     * 
     * <p>Title: getKing</p>
     * <p>Description: 使用王国工厂创建国王</p>
     * @param factory 王国工厂
     * @return 国王
     * @author java_liudong@163.com  2017年8月28日 下午2:57:34
     */
    King getKing(final KingdomFactory factory) {
        return factory.createKing();
    }
    
    public King getKing() {
        return king;
    }
    
    private void setKing(final King king) {
        this.king = king;
    }
    
    /**
     * 
     * <p>Title: getCastle</p>
     * <p>Description: 使用王国工厂创建城堡</p>
     * @param factory 王国工厂
     * @return 城堡
     * @author java_liudong@163.com  2017年8月28日 下午2:58:19
     */
    Castle getCastle(final KingdomFactory factory) {
        return factory.createCastle();
    }
    
    public Castle getCastle() {
        return castle;
    }
    
    private void setCastle(final Castle castle) {
        this.castle = castle;
    }
    
    /**
     * 
     * <p>Title: getArmy</p>
     * <p>Description: 使用王国工厂创建军队</p>
     * @param factory 王国工厂
     * @return 军队
     * @author java_liudong@163.com  2017年8月28日 下午2:59:00
     */
    Army getArmy(final KingdomFactory factory) {
        return factory.createArmy();
    }
    
    public Army getArmy() {
        return army;
    }
    
    private void setArmy(final Army army) {
        this.army = army;
    }
    
    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 启动程序</p>
     * @param args 入参
     * @author java_liudong@163.com  2017年8月28日 下午3:01:08
     */
    public static void main(String[] args) {
        App app = new App();
        
        LOGGER.info("精灵王国创建");
        app.createKingdom(new ElfKingdomFactory());
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        LOGGER.info(app.getKing().getDescription());
        
        LOGGER.info("兽族王国创建");
        app.createKingdom(new OrcKingdomFactory());
        LOGGER.info(app.getArmy().getDescription());
        LOGGER.info(app.getCastle().getDescription());
        LOGGER.info(app.getKing().getDescription());
    }
}
