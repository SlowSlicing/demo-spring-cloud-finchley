package com.lynchj.demoorder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：Ribbon 客户端负载均衡 请求 Controller
 * @CreateDate：6:02 PM 2018/10/25
 */
@RestController
@RequestMapping(
        value = "/ribbon",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class RibbonRestTemplateController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.GET
    )
    public String getPort() {
        return restTemplate.getForObject("http://demo-goods/goods/getPort", String.class);
    }

}
