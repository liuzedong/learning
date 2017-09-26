package com.dongdongxia.my.use.example.svn;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNCommitClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * 
 * <P>Description: svn 的使用， 工具类</P>
 * @ClassName: SVNTools
 * @author java_liudong@163.com  2017年9月26日 上午9:54:27
 */
public class SVNTools {

    private static final String SVN_ROOT_URL = "http://10.168.8.88:18001/svn/pubmi/root";
    private static final String SVN_USERNAME = "zdliuc";
    private static final String SVN_PASSWORD = "zdliuc";
    
    // 驱动选项
    private static final ISVNOptions OPTIONS = SVNWCUtil.createDefaultOptions(true);
    // SVN认证
    private static final ISVNAuthenticationManager AUTHMANAGER = SVNWCUtil.createDefaultAuthenticationManager(SVN_USERNAME, SVN_PASSWORD.toCharArray());
    // SVN客户端
    private static final SVNClientManager scm = SVNClientManager.newInstance(OPTIONS, AUTHMANAGER);
    
    
    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 启动程序</p>
     * @param args 入参
     * @author java_liudong@163.com  2017年9月26日 上午9:57:29
     * @throws SVNException 
     */
    public static void main(String[] args) throws SVNException {
        // 获取提交客户端
        SVNCommitClient commitClient = scm.getCommitClient();
        
        // 目标目录地址
        
        
        
        // 创建目录
        String webUrl = SVN_ROOT_URL + "/" + "web";
        SVNCommitInfo info = commitClient.doMkDir(new SVNURL[]{SVNURL.parseURIEncoded(webUrl)}, "mkdir: test directory");
        printLog(info);
    }
    
    /**
     * 
     * <p>Title: printLog</p>
     * <p>Description: 打印输出信息</p>
     * @param info 输出信息的主体
     * @author java_liudong@163.com  2017年9月26日 上午10:35:35
     */
    private static void printLog(SVNCommitInfo info) {
        System.out.println(String.format("作者：%s, 时间：%s, 版本号：%d", info.getAuthor(), info.getDate(), info.getNewRevision()));
    }
    
    
    
}
