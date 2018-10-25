package com.lynchj.demoorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：大漠知秋
 * @Description：demo-order 服务启动入口
 * @CreateDate：1:36 PM 2018/10/22
 */
@SpringBootApplication
/** 开启服务发现 */
@EnableDiscoveryClient
/** 开启 Feign 扫描支持 */
@EnableFeignClients
public class DemoOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOrderApplication.class, args);
    }

    /**
     * Ribbon Http 请求 客户端负载均衡器
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
