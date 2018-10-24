package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.GitHubFeign;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：使用 Feign 访问 Github 查询 API
 * @CreateDate：2:42 PM 2018/10/24
 */
@RestController
@RequestMapping(
        value = "/github",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class GitHubController {

    @Resource
    private GitHubFeign gitHubFeign;

    @RequestMapping(
            value = "/search/repositories",
            method = RequestMethod.GET
    )
    ResponseEntity<byte[]> searchRepo(@RequestParam("q") String q) {
        return gitHubFeign.searchRepo(q);
    }

}
