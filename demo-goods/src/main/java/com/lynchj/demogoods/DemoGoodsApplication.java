package com.lynchj.demogoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author：大漠知秋
 * @Description：demo-goods 服务启动入口
 * @CreateDate：1:36 PM 2018/10/22
 */
@SpringBootApplication
/** 开启服务发现 */
@EnableDiscoveryClient
/** 开启 Feign 扫描支持 */
@EnableFeignClients
/** 启动断路器功能 */
@EnableHystrix
public class DemoGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGoodsApplication.class, args);
	}

}
