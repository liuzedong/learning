package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * 
 * <P>Description: 当前文件系统的使用情况</P>
 * @ClassName: DiskUsage
 * @author java_liudong@163.com  2017年11月7日 下午5:09:10
 */
public class DiskUsage {

    static final long K = 1024L;
    
    static void printFileStore(FileStore store) throws IOException{
        long total = store.getTotalSpace() / K / K;
        long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / K / K;
        long avail = store.getUsableSpace() / K / K;
        
        String s = store.toString();
        if (s.length() > 20) {
            System.out.println(s);
            s = "";
        }
        System.out.format("%-20s %12d %12d %12d\n", s, total, used, avail);
    }
    
    
    public static void main(String[] args) throws IOException{
        System.out.format("%-20s %12s %12s %12s\n", "FileSystem", "kbytes", "使用", "还剩");
        if (args.length == 0) {
            FileSystem fs = FileSystems.getDefault();
            for (FileStore store : fs.getFileStores()) {
                printFileStore(store);
            }
        }
    }
    
}
