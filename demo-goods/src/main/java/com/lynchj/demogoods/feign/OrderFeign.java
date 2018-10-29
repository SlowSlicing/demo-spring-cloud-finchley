package com.lynchj.demogoods.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author：大漠知秋
 * @Description：访问 Order 服务的 Feign
 * @CreateDate：11:19 AM 2018/10/24
 */
@FeignClient(value = "demo-order")
public interface OrderFeign {

    @RequestMapping(
            value = "/order/getPort",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String getPort();

    @RequestMapping(
            value = "/order/getPort",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String getPortByPost();

}
