package com.lynchj.demoorder.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @Author：大漠知秋
 * @Description：拦截使用 Get 请求，并且使用的时 POJO 请求方式的 Feign 请求
 * @CreateDate：2:24 PM 2018/10/25
 */
@Component
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.name().equals(template.method())
                && null != template.body()) {
            try {
                JsonNode jsonNode = objectMapper.readTree(template.body());
                template.body(null);

                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(jsonNode, "", queries);
                template.queries(queries);
            } catch (IOException e) {
                log.error("【拦截GET请求POJO方式】-出错了：{}", ExceptionUtils.getStackFrames(e));
                throw new RuntimeException();
            }
        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        // 叶子节点
        if (!jsonNode.isContainerNode()) {
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.get(path);
            if (null == values) {
                values = new ArrayList<>();
                queries.put(path, values);
            }
            values.add(jsonNode.asText());
            return;
        }
        // 数组节点
        if (jsonNode.isArray()) {
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else {  // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }

}
