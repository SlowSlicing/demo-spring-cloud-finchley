package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.HystrixAndFeignFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：Hystrix 结合 Feign 案例
 * @CreateDate：10:23 AM 2018/10/29
 */
@RestController
@RequestMapping("/hystrixAndFeign")
public class HystrixAndFeignController {

    @Resource
    private HystrixAndFeignFeign hystrixAndFeignFeign;

    @RequestMapping(value = "/getUser")
    public String getUser(String username) {

        return hystrixAndFeignFeign.getUser(username);

    }

}
