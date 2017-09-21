package com.dongdongxia.my.micro.service.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * <P>Description: Spring boot启动器</P>
 * @ClassName: RestSampleApp
 * @author java_liudong@163.com  2017年9月20日 上午11:40:27
 */
@EnableEurekaServer
@SpringBootApplication
public class RestSampleApp {

    /**
     * 
     * <p>Title: main</p>
     * <p>Description: 启动接口</p>
     * @param args 入参
     * @author java_liudong@163.com  2017年9月20日 下午3:51:11
     */
    public static void main(String[] args) {
        SpringApplication.run(RestSampleApp.class, args);
    }
}
