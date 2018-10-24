package com.lynchj.demoorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author：大漠知秋
 * @Description：使用 Feign 访问 Github 查询 API
 * @CreateDate：2:36 PM 2018/10/24
 */
@FeignClient(name = "github-client", url = "https://api.github.com")
public interface GitHubFeign {

    @RequestMapping(
            value = "/search/repositories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    String searchRepo(@RequestParam("q") String q);

}
