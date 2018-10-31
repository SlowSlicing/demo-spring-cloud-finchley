package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.component.ServiceInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author：大漠知秋
 * @Description：灰度发布测试 Controller
 * @CreateDate：3:05 PM 2018/10/31
 */
@RestController
@RequestMapping(
        value = "/gray",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class GrayController {

    @Resource
    private ServiceInfo serviceInfo;

    @RequestMapping(value = "/getPort")
    public String getPort(HttpServletRequest request) {
        return String.valueOf(serviceInfo.getPort());
    }

}
