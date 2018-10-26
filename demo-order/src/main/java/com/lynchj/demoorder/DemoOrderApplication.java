package com.lynchj.demoorder;

import com.lynchj.demoorder.annotation.AvoidScan;
import com.lynchj.demoorder.config.RibbonRandomLoadBalancingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
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
/** 配置针对单个服务的 Ribbon 负载均衡策略 **/
@RibbonClient(
        name = "demo-goods", configuration = RibbonRandomLoadBalancingConfiguration.class
)
/** 此处配置根据标识 @AvoidScan 过滤掉需要单独配置的 Ribbon 负载均衡策略，不然就会作用于全局，启动就会报错 */
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION, value = AvoidScan.class
        )
)
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
