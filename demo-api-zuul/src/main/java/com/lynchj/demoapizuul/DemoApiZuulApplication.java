package com.lynchj.demoapizuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author：大漠知秋
 * @Description：demo-api-zuul 服务启动入口
 * @CreateDate：7:22 PM 2018/10/29
 */
@SpringBootApplication
/** 开启服务发现 */
@EnableDiscoveryClient
/** 开启网关代理 */
@EnableZuulProxy
public class DemoApiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiZuulApplication.class, args);
    }

}
