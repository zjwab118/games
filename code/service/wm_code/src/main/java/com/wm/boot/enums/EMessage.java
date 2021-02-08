package com.wm.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wilson
 * @title EMessage
 * @description 消息常量
 * @date 2021.01.30 16:47
 */
@AllArgsConstructor
@Getter
public enum EMessage {
    SUCCESS(200,"OK"),
    ERROR(800,"ERROR"),
    EXCEPTION_ARGS(600,"参数异常"),
    EXCEPTION_PERMISSION(700,"权限异常"),
    EXCEPTION_TOKEN(900,"Token异常"),
    EXCEPTION_SERVICE(800,"服务异常"),
    ;
    private  int value;
    private  String text;
}
