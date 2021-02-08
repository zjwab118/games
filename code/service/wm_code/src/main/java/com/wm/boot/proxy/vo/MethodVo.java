package com.wm.boot.proxy.vo;

import io.swagger.models.HttpMethod;
import lombok.Data;

import java.util.Map;

/**
 * @author wilson
 * @title MethodVo
 * @description 方法信息
 * @date 2021.02.06 08:11
 */
@Data
public class MethodVo {
    //接口地址
    private String url;
private HttpMethod method;
    //url 参数
    private Map<String,Object> urlParam;

    private  Map<String,Object> header;

    private  Object requestBody;

    //返回值类型
    private Class<?> returnType;

    private  boolean isFlux;
}
