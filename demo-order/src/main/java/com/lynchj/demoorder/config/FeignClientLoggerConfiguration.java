package com.lynchj.demoorder.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：大漠知秋
 * @Description：Feign Client Logger Level Configuration
 * @CreateDate：4:53 PM 2018/10/24
 */
@Configuration
public class FeignClientLoggerConfiguration {

    @Bean
    Logger.Level FeignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

}
