package com.lynchj.demogoods.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：大漠知秋
 * @Description：Feign 上传文件 Controller
 * @CreateDate：3:27 PM 2018/10/25
 */
@RestController
@RequestMapping("/upload")
public class FeignUploadFileController {

    @RequestMapping(
            value = "/file",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String file(MultipartFile file) {
        System.err.println("原始文件名：" + file.getOriginalFilename());
        System.out.println("文件大小：" + file.getSize());
        return "上传成功";
    }

}
