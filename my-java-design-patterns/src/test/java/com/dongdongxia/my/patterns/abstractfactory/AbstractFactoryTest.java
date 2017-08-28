package com.dongdongxia.my.patterns.abstractfactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * <P>Description: 抽象工厂的测试类</P>
 * @ClassName: AbstractFactoryTest
 * @author java_liudong@163.com  2017年8月28日 下午3:05:55
 */
public class AbstractFactoryTest {

    private App app = new App();
    private KingdomFactory elfFactory;
    private KingdomFactory orcFactory;
    
    /**
     * 
     * <p>Title: setUp</p>
     * <p>Description: 测试前，初始化精灵王国工厂和兽族王国工厂</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:08:19
     */
    @Before
    public void setUp() {
        elfFactory = new ElfKingdomFactory();
        orcFactory = new OrcKingdomFactory();
    }
    
    /**
     * 
     * <p>Title: king</p>
     * <p>Description: 测试使用抽象工厂创建国王</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:09:22
     */
    @Test
    public void king() {
        final King elfKing = app.getKing(elfFactory);
        assertTrue(elfKing instanceof ElfKing);
        assertEquals(ElfKing.DESCRIPTION, elfKing.getDescription());
        final King orcKing = app.getKing(orcFactory);
        assertTrue(orcKing instanceof OrcKing);
        assertEquals(OrcKing.DESCRIPTION, orcKing.getDescription());
    }
    
    /**
     * 
     * <p>Title: castle</p>
     * <p>Description: 测试使用工厂获取城堡</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:18:53
     */
    @Test
    public void castle() {
        final Castle elfCastle = app.getCastle(elfFactory);
        assertTrue(elfCastle instanceof ElfCastle);
        assertEquals(ElfCastle.DESCRIPTION, elfCastle.getDescription());
        final Castle orcCastle = app.getCastle(orcFactory);
        assertTrue(orcCastle instanceof OrcCastle);
        assertEquals(OrcCastle.DESCRIPTION, orcCastle.getDescription());
    }
    
    /**
     * 
     * <p>Title: army</p>
     * <p>Description: 测试使用抽象工厂创建军队</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:22:39
     */
    @Test
    public void army() {
        final Army elfArmy = app.getArmy(elfFactory);
        assertTrue(elfArmy instanceof ElfArmy);
        assertEquals(ElfArmy.DESCRIPTION, elfArmy.getDescription());
        final Army orcArmy = app.getArmy(orcFactory);
        assertTrue(orcArmy instanceof OrcArmy);
        assertEquals(OrcArmy.DESCRIPTION, orcArmy.getDescription());
    }
    
    /**
     * 
     * <p>Title: createElfKingdom</p>
     * <p>Description: 使用抽象工厂创建精灵王国</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:26:07
     */
    @Test
    public void createElfKingdom() {
        app.createKingdom(elfFactory);
        final King king = app.getKing();
        final Castle castle = app.getCastle();
        final Army army = app.getArmy();
        
        assertTrue(king instanceof ElfKing);
        assertEquals(ElfKing.DESCRIPTION, king.getDescription());
        
        assertTrue(castle instanceof ElfCastle);
        assertEquals(ElfCastle.DESCRIPTION, castle.getDescription());
        
        assertTrue(army instanceof ElfArmy);
        assertEquals(ElfArmy.DESCRIPTION, army.getDescription());
    }
    
    /**
     * 
     * <p>Title: createOrcKingdom</p>
     * <p>Description: 使用抽象工厂创建兽族王国</p>
     * @author java_liudong@163.com  2017年8月28日 下午3:30:59
     */
    @Test
    public void createOrcKingdom() {
        app.createKingdom(orcFactory);
        final King king = app.getKing();
        final Castle castle = app.getCastle();
        final Army army = app.getArmy();
        
        assertTrue(king instanceof OrcKing);
        assertEquals(OrcKing.DESCRIPTION, king.getDescription());
        
        assertTrue(castle instanceof OrcCastle);
        assertEquals(OrcCastle.DESCRIPTION, castle.getDescription());
        
        assertTrue(army instanceof OrcArmy);
        assertEquals(OrcArmy.DESCRIPTION, army.getDescription());
    }
    
}
