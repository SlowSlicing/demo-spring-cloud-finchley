package com.lynchj.demoorder.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：大漠知秋
 * @Description：Ribbon 全局的负载均衡策略配置类
 * @CreateDate：6:32 PM 2018/10/25
 */
@Configuration
public class RibbonGlobalLoadBalancingConfiguration {

    /**
     * 随机规则
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
