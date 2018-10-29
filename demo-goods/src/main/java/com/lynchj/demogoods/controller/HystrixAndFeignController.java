package com.lynchj.demogoods.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：大漠知秋
 * @Description：Hystrix 结合 Feign 案例
 * @CreateDate：10:23 AM 2018/10/29
 */
@RestController
@RequestMapping("/hystrixAndFeign")
public class HystrixAndFeignController {

    @RequestMapping(value = "/getUser")
    public String getUser(String username) {

        if ("SpringCloud".equals(username)) {
            return "Hello " + username;
        } else {
            throw new RuntimeException();
        }

    }

}
