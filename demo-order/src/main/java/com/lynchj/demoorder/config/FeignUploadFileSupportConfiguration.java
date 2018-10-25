package com.lynchj.demoorder.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * @Author：大漠知秋
 * @Description：Feign Client 进行上传文件配置类
 * @CreateDate：3:48 PM 2018/10/25
 */
@Configuration
public class FeignUploadFileSupportConfiguration {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder();
    }

}
