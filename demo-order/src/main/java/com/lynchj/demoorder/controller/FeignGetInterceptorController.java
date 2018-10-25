package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.FeignGetInterceptorFeign;
import com.lynchj.demoorder.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：测试 FeignGetInterceptor 的 Controller
 * @CreateDate：2:38 PM 2018/10/25
 */
@RestController
@RequestMapping("/feignGet")
public class FeignGetInterceptorController {

    @Resource
    private FeignGetInterceptorFeign feignGetInterceptorFeign;

    @RequestMapping(
            value = "/addUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    ResponseEntity<byte[]> addUser(User user) {
        return feignGetInterceptorFeign.addUser(user);
    }

    @RequestMapping(
            value = "/updateUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    ResponseEntity<byte[]> updateUser(@RequestBody User user) {
        return feignGetInterceptorFeign.updateUser(user);
    }

}
