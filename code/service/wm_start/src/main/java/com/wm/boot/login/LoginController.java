package com.wm.boot.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author wilson
 * @title LoginController
 * @description 登录处理类
 * @date 2021.02.06 17:37
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("")
    public Mono<?> login(){
        return  null;
    }
}
