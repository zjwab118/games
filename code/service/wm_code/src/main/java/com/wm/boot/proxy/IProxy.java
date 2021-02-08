package com.wm.boot.proxy;

/**
 * @author wilson
 * @title IHttpProxy
 * @description Http接口代理
 * @date 2021.02.06 08:07
 */
public interface IProxy {
    Object getInstance(Class<?> type);


}
