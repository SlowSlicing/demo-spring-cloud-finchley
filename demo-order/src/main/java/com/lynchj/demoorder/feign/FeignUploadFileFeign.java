package com.lynchj.demoorder.feign;

import com.lynchj.demoorder.config.FeignUploadFileSupportConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author：大漠知秋
 * @Description：Feign 上传文件
 * @CreateDate：3:27 PM 2018/10/25
 */
@FeignClient(name = "demo-goods", configuration = FeignUploadFileSupportConfiguration.class)
public interface FeignUploadFileFeign {

    @RequestMapping(
            value = "/upload/file",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    ResponseEntity<byte[]> file(@RequestPart("file") MultipartFile file);

}
