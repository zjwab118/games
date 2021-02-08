package com.wm.boot;

import com.wm.boot.proxy.IProxy;
import com.wm.boot.proxy.JdkProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wilson
 * @title Application
 * @description Application
 * @date 2021.02.06 14:11
 */
@Configuration
public class Application {
    @Bean
    IProxy proxy(){
        return  new JdkProxy();
    }

    public static void main(String[] args) {

    }
}
