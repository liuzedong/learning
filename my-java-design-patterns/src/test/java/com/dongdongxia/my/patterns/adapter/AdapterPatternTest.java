package com.dongdongxia.my.patterns.adapter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * 
 * <P>Description: 适配器模式的测试类</P>
 * @ClassName: AdapterPatternTest
 * @author java_liudong@163.com  2017年8月29日 上午9:55:50
 */
public class AdapterPatternTest {

    private Map<String, Object> beans;
    
    private static final String FISHING_BEAN = "fisher";
    
    private static final String ROWING_BEAN = "captain";
    
    /**
     * 
     * <p>Title: setup</p>
     * <p>Description: 初始化船夫和渔船的适配器</p>
     * @author java_liudong@163.com  2017年8月29日 上午10:08:58
     */
    @Before
    public void setup() {
        beans = new HashMap<>();
        
        FishingBoatAdapter fishingBoatAdapter = spy(new FishingBoatAdapter());
        beans.put(FISHING_BEAN, fishingBoatAdapter);
        
        Captain captain = new Captain();
        captain.setRowingBoat((FishingBoatAdapter) beans.get(FISHING_BEAN));
        beans.put(ROWING_BEAN, captain);
    }
    
    /**
     * 
     * <p>Title: testAdapter</p>
     * <p>Description: 测试适配器</p>
     * @author java_liudong@163.com  2017年8月29日 上午10:09:36
     */
    @Test
    public void testAdapter() {
        RowingBoat captain = (RowingBoat) beans.get(ROWING_BEAN);
        
        captain.row();
        
        RowingBoat adapter = (RowingBoat) beans.get(FISHING_BEAN);
        verify(adapter).row();
    }
    
}
