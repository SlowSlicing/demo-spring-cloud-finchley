package com.lynchj.demohystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author：大漠知秋
 * @Description：Hystrix Dashboard 服务启动入口
 * @CreateDate：11:27 AM 2018/10/29
 */
@SpringBootApplication
/** 开启 Hystrix Dashboard 监控功能 */
@EnableHystrixDashboard
public class DemoHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHystrixDashboardApplication.class, args);
    }

}
