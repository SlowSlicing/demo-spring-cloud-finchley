package com.lynchj.demogoods.controller;

import com.lynchj.demogoods.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author：大漠知秋
 * @Description：测试 FeignGetInterceptor 的 Controller
 * @CreateDate：2:38 PM 2018/10/25
 */
@RestController
@RequestMapping("/feignGet")
public class FeignGetInterceptorController {

    @RequestMapping(
            value = "/addUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    User addUser(User user) {
        user.setAge(user.getAge() + 1);
        user.setUsername(user.getUsername() + "1");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(
            value = "/updateUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    User updateUser(@RequestBody User user) {
        user.setAge(user.getAge() + 1);
        user.setUsername(user.getUsername() + "1");
        user.setBirthday(new Date());
        return user;
    }

}
