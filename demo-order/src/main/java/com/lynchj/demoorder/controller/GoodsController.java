package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.GoodsFeign;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

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

    @RequestMapping(
            value = "/getBoolean",
            method = RequestMethod.GET,
            consumes = "application/x-java-serialization",
            produces = "application/x-java-serialization"
    )
    public Boolean getBoolean() {

        return goodsFeign.getBoolean();

    }

    @RequestMapping(
            value = "/testHttpMessageConverter",
            method = RequestMethod.GET
    )
    public HttpMessageModel testHttpMessageConverter(@RequestBody HttpMessageModel httpMessageModel) {

        httpMessageModel.setSex(true);
        httpMessageModel.setAge(24);
        httpMessageModel.setBirthday(new Date());

        return httpMessageModel;
    }

}

@Data
class HttpMessageModel {

    private String user;

    private String pwd;

    private Integer age;

    private Boolean sex;

    private Date birthday;

}
