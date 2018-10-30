package com.lynchj.demoapizuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @Author：大漠知秋
 * @Description：Zuul Fallback 机制
 * @CreateDate：5:15 PM 2018/9/27
 */
@Component
public class ZuulFallback implements FallbackProvider {

    /**
     * 可以配置指定的路由，值为 serviceId，如：demo-order
     */
    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() {
                // 返回状态吗
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public String getStatusText() {
                // 错误原因
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() {
                // 定义自己的错误信息
                return new ByteArrayInputStream(("microservice error").getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }

            @Override
            public int getRawStatusCode() {
                // TODO Auto-generated method stub
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }
        };
    }

}
