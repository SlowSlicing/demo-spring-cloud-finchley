package com.lynchj.demoorder.feign.hystrix;

import com.lynchj.demoorder.feign.HystrixAndFeignFeign;
import org.springframework.stereotype.Component;

/**
 * @Author：大漠知秋
 * @Description：Hystrix 结合 Feign 案例
 * @CreateDate：10:23 AM 2018/10/29
 */
@Component
public class HystrixAndFeignHystrix implements HystrixAndFeignFeign {

    @Override
    public String getUser(String username) {

        return "No Hello " + username;

    }

}
