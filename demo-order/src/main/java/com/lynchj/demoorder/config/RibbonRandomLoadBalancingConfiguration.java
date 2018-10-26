package com.lynchj.demoorder.config;

import com.lynchj.demoorder.annotation.AvoidScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：Ribbon 随机负载均衡策略配置类
 *                  那个服务引用就作用在那个服务上面
 *                  在启动类上方使用 @RibbonClient 引用
 * @CreateDate：7:04 PM 2018/10/25
 */
@Configuration
/** 用来标记使用的注解，方便排除或者引用 **/
@AvoidScan
public class RibbonRandomLoadBalancingConfiguration {

    @Resource
    IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig) {
        return new RandomRule();
    }

}
