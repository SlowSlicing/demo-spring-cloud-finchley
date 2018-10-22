package com.lynchj.demoeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author：大漠知秋
 * @Description：注册中心启动入口
 * @CreateDate：1:12 PM 2018/10/22
 */
@SpringBootApplication
/** 开启 Eureka 注册中心服务 */
@EnableEurekaServer
public class DemoEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaServerApplication.class, args);
    }

}
