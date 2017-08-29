package com.dongdongxia.my.patterns.adapter;
/**
 * 
 * <P>Description: 渔船的适配器，用来扩展渔船的功能</P>
 * @ClassName: FishingBoatAdapter
 * @author java_liudong@163.com  2017年8月29日 上午9:48:14
 */
public class FishingBoatAdapter implements RowingBoat {

    private FishingBoat boat;
    
    public FishingBoatAdapter() {
        boat = new FishingBoat();
    }
    
    @Override
    public void row() {
        boat.sail();
    }

}
