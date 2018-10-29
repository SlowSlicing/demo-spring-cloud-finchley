package com.lynchj.demogoods.controller;

import com.lynchj.demogoods.feign.OrderFeign;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：访问 Order 服务的 Controller
 * @CreateDate：11:18 AM 2018/10/24
 */
@RestController
@RequestMapping(
        value = "/order",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class OrderController {

    @Resource
    private OrderFeign orderFeign;

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.GET
    )
    public String getPort() {

        return orderFeign.getPort();

    }

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.POST
    )
    public String getPortByPost() {

        return orderFeign.getPortByPost();

    }

}
