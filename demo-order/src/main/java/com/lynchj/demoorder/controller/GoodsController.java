package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.GoodsFeign;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：访问 Goods 服务的 Controller
 * @CreateDate：11:18 AM 2018/10/24
 */
@RestController
@RequestMapping(
        value = "/goods",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class GoodsController {

    @Resource
    private GoodsFeign goodsFeign;

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.GET
    )
    public String getPort() {

//        throw new IllegalStateException();
        return goodsFeign.getPort();

    }

    @RequestMapping(
            value = "/getPort",
            method = RequestMethod.POST
    )
    public String getPortByPost() {

        return goodsFeign.getPortByPost();

    }

}
