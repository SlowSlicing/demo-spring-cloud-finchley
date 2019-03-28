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

/**
 * 拦截使用 Get 请求，并且使用的时 POJO 请求方式的 Feign 请求
 *
 * @author 大漠知秋
 * @date 2019-03-27 17:35
 */
@Component
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 如果是 GET 方式并且 请求体 不为空，那么把请求体转换成请求参数，防止自动转换成 POST 方式
     *  * 并不推荐使用 GET 方式传输请求体内容，建议更改为 POST 方式
     *
     * @param template Feign 低层发送 Http 请求模板工具
     */
    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.name().equals(template.method())
                && null != template.body()) {
            try {
                JsonNode jsonNode = objectMapper.readTree(template.body());
                template.body(null);

                Map<String, Collection<String>> queries = new HashMap<>(16);
                buildQuery(jsonNode, "", queries);
                template.queries(queries);
            } catch (IOException e) {
                log.error("【拦截 GET 请求 POJO 方式】-出错了：{}", ExceptionUtils.getStackFrames(e));
                throw new RuntimeException();
            }
        }
    }

    /**
     * 构建请求参数
     *
     * @param jsonNode 原始数据
     * @param path json 节点
     * @param queries 构建购的请求参数集合
     */
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
