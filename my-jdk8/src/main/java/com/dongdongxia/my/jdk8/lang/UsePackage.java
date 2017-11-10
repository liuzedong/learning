package com.dongdongxia.my.jdk8.lang;
/**
 * 
 * <P>Description: 使用Package 查询当前版本中使用包</P>
 * @ClassName: UsePackage
 * @author java_liudong@163.com  2017年11月10日 下午3:11:30
 */
public class UsePackage {

    public static void main(String[] args) {
        Package[] pkgs;
        
        pkgs = Package.getPackages();
        
        for (int i = 0; i < pkgs.length; i++) {
            System.out.format("%s %s   -  %s %s %s %n", i, 
                    pkgs[i].getName(), 
                    pkgs[i].getImplementationTitle(), 
                    pkgs[i].getImplementationVendor(),
                    pkgs[i].getImplementationVersion());
        }
    }
    
}
