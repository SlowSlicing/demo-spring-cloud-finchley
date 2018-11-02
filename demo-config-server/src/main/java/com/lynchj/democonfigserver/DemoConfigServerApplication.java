package com.lynchj.democonfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author：大漠知秋
 * @Description：Config Server 服务启动入口
 * @CreateDate：4:35 PM 2018/11/1
 */
@SpringBootApplication
/** 开启配置中心服务 */
@EnableConfigServer
/** 开启服务发现 */
@EnableDiscoveryClient
public class DemoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigServerApplication.class, args);
	}

}
