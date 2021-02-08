package com.wm.boot.proxy;

import com.wm.boot.proxy.vo.MethodVo;
import io.swagger.models.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wilson
 * @title JdkProxy
 * @description JDK动态代理
 * @date 2021.02.06 13:59
 */
@Slf4j
public class JdkProxy implements IProxy {

    @Override
    public Object getInstance(Class<?> type) {
        //STEP 1: 取baseURl
        String baseUrl="";
        RequestMapping requestMapping = type.getAnnotation(RequestMapping.class);
        if(requestMapping!=null){
            baseUrl=requestMapping.value()[0];
        }
        log.info("API:"+baseUrl);
        //STEP2 初始化代理请求
        IHttpProxy httpRequst = new WebClientHttpProxy();
        httpRequst.init(baseUrl);

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{type}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //STEP3 提取方法信息

                Annotation[] annotations = method.getAnnotations();
                MethodVo info = new MethodVo();
                for (Annotation an:annotations) {
                    if(an instanceof GetMapping){
                        info.setMethod(HttpMethod.GET);
                        info.setUrl(((GetMapping) an).value()[0]);
                    }
                    else if(an instanceof PostMapping){
                        info.setMethod(HttpMethod.POST);
                        info.setUrl(((PostMapping) an).value()[0]);
                    }

                }
                Object invoke = method.invoke(info, args);
                log.info("方法信息:"+info);
                return invoke;
            }
        });
    }
}
