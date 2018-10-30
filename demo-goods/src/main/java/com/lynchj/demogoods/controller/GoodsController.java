package com.lynchj.demogoods.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：大漠知秋
 * @Description Goods 服务的 Controller
 * @CreateDate：11:18 AM 2018/10/24
 */
@RestController
@RequestMapping(
        value = "/goods",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class GoodsController {

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.GET
    )
    public String getPort(HttpServletRequest request) {

//        throw new RuntimeException();
        return String.valueOf(request.getServerPort());

    }

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.POST
    )
    public String getPortByPost(HttpServletRequest request) {

        return String.valueOf(request.getServerPort());

    }

}
