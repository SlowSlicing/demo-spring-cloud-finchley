package com.lynchj.demoorder.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;

/**
 * @Author：大漠知秋
 * @Description：自动去刷新配置中心的配置
 * @CreateDate：10:31 AM 2018/11/2
 */
@Slf4j
@ConditionalOnClass(RefreshEndpoint.class)
@ConditionalOnProperty(
        value = "spring.cloud.config.auto-refresh-config.enabled",
        havingValue = "true"
)
@AutoConfigureAfter(RefreshAutoConfiguration.class)
@ConfigurationProperties(prefix = "spring.cloud.config.auto-refresh-config")
@Configuration
public class AutoRefreshConfigServerConfiguration implements SchedulingConfigurer {

    /** 间隔刷新时间 */
    private long refreshInterval;

    public long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    /** 刷新的端点 */
    @Resource
    private RefreshEndpoint refreshEndpoint;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        final long interval = getRefreshIntervalInMilliseconds();

        log.info(String.format("Scheduling config refresh task with %s second delay", refreshInterval));
        scheduledTaskRegistrar.addFixedDelayTask(new IntervalTask(
                () -> {
                    refreshEndpoint.refresh();
                }, interval, interval
        ));
    }

    /** 以毫秒为单位返回刷新间隔。 */
    private long getRefreshIntervalInMilliseconds() {
        return refreshInterval;
    }

    /** 如果没有在上下文中注册，则启用调度程序。 */
    @ConditionalOnMissingBean(ScheduledAnnotationBeanPostProcessor.class)
    @EnableScheduling
    @Configuration
    protected static class EnableSchedulingConfigProperties {

    }

}
