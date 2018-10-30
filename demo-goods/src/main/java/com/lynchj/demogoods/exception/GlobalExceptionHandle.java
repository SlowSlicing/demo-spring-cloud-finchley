package com.lynchj.demogoods.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：大漠知秋
 * @Description：全局异常处理器
 * @CreateDate：3:28 PM 2018/10/30
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        if (e instanceof RuntimeException) {
            return "demo-goods-全局捕获-自定义的错误信息";
        } else {
            return "demo-goods-全局捕获-系统繁忙，请稍后再试";
        }
    }

}
