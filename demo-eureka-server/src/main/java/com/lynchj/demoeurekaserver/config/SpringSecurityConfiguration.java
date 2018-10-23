package com.lynchj.demoeurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author：大漠知秋
 * @Description：Spring Security 配置
 * @CreateDate：2:54 PM 2018/10/23
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        // 关闭 CSRF
        http.csrf().disable();
    }

}
