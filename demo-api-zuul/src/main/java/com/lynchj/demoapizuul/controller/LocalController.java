package com.lynchj.demoapizuul.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：大漠知秋
 * @Description：网关本地的 Controller
 * @CreateDate：1:33 PM 2018/10/30
 */
@RestController
@RequestMapping(
        value = "/local",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class LocalController {

    @RequestMapping(value = "/testOne")
    public String testOne() {

        return "testOne";

    }

}
