package com.lynchj.demoorder.controller;

import com.lynchj.demoorder.feign.FeignUploadFileFeign;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：Feign 上传文件 Controller
 * @CreateDate：3:27 PM 2018/10/25
 */
@RestController
@RequestMapping("/upload")
public class FeignUploadFileController {

    @Resource
    private FeignUploadFileFeign feignUploadFileFeign;

    @RequestMapping(
            value = "/file",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<byte[]> file(@RequestPart("file") MultipartFile file) {
        return feignUploadFileFeign.file(file);
    }

}
