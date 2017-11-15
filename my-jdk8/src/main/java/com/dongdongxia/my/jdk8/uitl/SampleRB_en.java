package com.dongdongxia.my.jdk8.uitl;

import java.util.ListResourceBundle;
/**
 * 
 * <P>Description: 英文资源包</P>
 * @ClassName: SampleRB_cn
 * @author java_liudong@163.com  2017年11月15日 上午10:52:16
 */
public class SampleRB_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];
        
        resources[0][0] = "title";
        resources[0][1] = "My Program";
        resources[1][0] = "StopText";
        resources[1][1] = "Stop";
        resources[2][0] = "StartText";
        resources[2][1] = "Start";

        return resources;
    }

}
