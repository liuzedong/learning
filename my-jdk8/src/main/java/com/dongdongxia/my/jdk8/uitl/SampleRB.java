package com.dongdongxia.my.jdk8.uitl;

import java.util.ListResourceBundle;

/**
 * 
 * <P>
 * Description: 中文默认资源包
 * </P>
 * 
 * @ClassName: SampleRB
 * @author java_liudong@163.com 2017年11月15日 上午10:46:14
 */
public class SampleRB extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[3][2];

        resources[0][0] = "title";
        resources[0][1] = "我的程序";
        resources[1][0] = "StopText";
        resources[1][1] = "停止";
        resources[2][0] = "StartText";
        resources[2][1] = "开始";

        return resources;
    }

}
