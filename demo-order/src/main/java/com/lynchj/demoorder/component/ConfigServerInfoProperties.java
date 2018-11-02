package com.lynchj.demoorder.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("demo")
public class ConfigServerInfoProperties {

    private String one;

    private String two;

}
