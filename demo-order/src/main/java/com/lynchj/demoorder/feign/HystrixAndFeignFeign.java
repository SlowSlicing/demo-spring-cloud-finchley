package com.lynchj.demoorder.feign;

import com.lynchj.demoorder.feign.hystrix.HystrixAndFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author：大漠知秋
 * @Description：Hystrix 结合 Feign 案例
 * @CreateDate：10:23 AM 2018/10/29
 */
@FeignClient(name = "demo-goods", fallback = HystrixAndFeignHystrix.class)
public interface HystrixAndFeignFeign {

    @RequestMapping(value = "/hystrixAndFeign/getUser")
    String getUser(@RequestParam(name = "username") String username);

}
