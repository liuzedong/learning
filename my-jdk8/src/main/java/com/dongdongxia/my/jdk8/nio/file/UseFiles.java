package com.dongdongxia.my.jdk8.nio.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * <P>Description: 使用Files 工具类</P>
 * @ClassName: UseFiles
 * @author java_liudong@163.com  2017年11月7日 上午10:24:05
 */
public class UseFiles {

    static final String FILE_STR = "/home/liuzedong/下载/01175707169.txt";
    static final Path FILE_PATH = Paths.get(FILE_STR);
    
    
    public static void main(String[] args) {
        // 检测文件或者目录是否存在
        boolean exists = Files.exists(FILE_PATH);
        System.out.println(exists);
        
        // 检测文件不存在
        boolean notExists = Files.notExists(FILE_PATH);
        System.out.println(notExists);
        
        // 检测路径是否为目录
        boolean directory = Files.isDirectory(FILE_PATH);
        System.out.format("是否为目录： %s%n", directory);
        
        // 检测路径是否为文件
        boolean regularFile = Files.isRegularFile(FILE_PATH);
        System.out.format("是否为普通文件: %s%n", regularFile);
        
        // 向文件中写入值, 如果文件存在，就追加
        try {
            Path write = Files.write(FILE_PATH, "我是栋栋侠\r\n".getBytes("UTF-8"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            System.out.format("写入的路径: %s%n", write);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 检测文件读权限， 写权限， 执行权限
        boolean executable = Files.isExecutable(FILE_PATH);
        System.out.format("是否拥有执行权限: %s%n", executable);
        boolean readable = Files.isReadable(FILE_PATH);
        System.out.format("是否拥有读权限: %s%n", readable);
        boolean writable = Files.isWritable(FILE_PATH);
        System.out.format("是否拥有写权限: %s%n", writable);
        
        // 复制文件
        try {
            Path copy = Files.copy(FILE_PATH, Paths.get("/home/liuzedong/下载/备份.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.format("复制到： %s%n", copy);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        // 移动文件
        try {
            Path move = Files.move(Paths.get("/home/liuzedong/下载/备份.txt"), Paths.get("/home/liuzedong/下载/备份2.txt"), StandardCopyOption.REPLACE_EXISTING);
            System.out.format("移动到： %s%n", move);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        // 设置作者， 这个作者必须是系统上的用户，不然会报错的
        try {
            UserPrincipal lookupPrincipalByName = FILE_PATH.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("liuzedong");
            Path setOwner = Files.setOwner(FILE_PATH, lookupPrincipalByName);
            System.out.format("%s 设置作者 %n", setOwner);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        
        // 读取文件的所有属性
        try {
            Map<String, Object> readAttributes = Files.readAttributes(FILE_PATH, "*");
            System.out.println(readAttributes);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        // 使用对象来装载属性
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(FILE_PATH, BasicFileAttributes.class);
            System.out.println("所有的属性 中的 创建时间： " + readAttributes.creationTime());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        // 删除文件
        try {
            boolean deleteIfExists = Files.deleteIfExists(FILE_PATH);
            System.out.format("是否删除成功： %s%n", deleteIfExists);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        // 下面的是创建文件， 读取文件， 写入文件
        try {
            byte[] readAllBytes = Files.readAllBytes(Paths.get("/home/liuzedong/下载/svnImport.txt"));
            System.out.format("获取的页面内容 : %s%n", new String(readAllBytes), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 使用读取行，来读取文件
        try {
            List<String> readAllLines = Files.readAllLines(Paths.get("/home/liuzedong/下载/svnImport.txt"));
            for (String line : readAllLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 向文件中写入字符
        try {
            List<String> list = new ArrayList<String>();
            list.add("我是栋栋侠");
            list.add("我是栋栋侠");
            list.add("我是栋栋侠");
            list.add("我是栋栋侠");
            list.add("我是栋栋侠");
            list.add("我是栋栋侠");
            list.add("我是栋栋侠3");
            list.add("我是栋栋侠2");
            Path write = Files.write(FILE_PATH, list, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.APPEND, StandardOpenOption.DELETE_ON_CLOSE);
            System.out.format("写入到： %s%n", write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
