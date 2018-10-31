package com.lynchj.demoorder.component;

import lombok.Data;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author：大漠知秋
 * @Description：当前服务的信息
 * @CreateDate：3:55 PM 2018/10/31
 */
@Data
@Component
public class ServiceInfo implements ApplicationListener<WebServerInitializedEvent> {

    private Integer port;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
    }

}
