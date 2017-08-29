package com.dongdongxia.my.patterns.adapter;
/**
 * 
 * <P>Description: 一个船长在划船</P>
 * @ClassName: Captain
 * @author java_liudong@163.com  2017年8月29日 上午9:43:20
 */
public class Captain implements RowingBoat {

    private RowingBoat rowingBoat;
    
    public Captain() { }
    
    public Captain(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }
    
    public void setRowingBoat(RowingBoat rowingBoat) {
        this.rowingBoat = rowingBoat;
    }
    
    @Override
    public void row() {
        rowingBoat.row();
    }

}
