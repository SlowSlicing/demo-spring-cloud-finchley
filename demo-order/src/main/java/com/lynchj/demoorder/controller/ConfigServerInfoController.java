package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.component.ConfigServerInfoProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：测试 Config Server Controller
 * @CreateDate：5:18 PM 2018/11/1
 */
@RestController
@RequestMapping(
        value = "configServerInfo",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class ConfigServerInfoController {

    @Resource
    private ConfigServerInfoProperties configServerInfoProperties;

    @RequestMapping(value = "getAll")
    public String getAll() {

        return configServerInfoProperties.getOne() + " === " + configServerInfoProperties.getTwo();

    }

}
