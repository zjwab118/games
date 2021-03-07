package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wilson
 * @title HomeController
 * @description Test
 * @date 2021.03.07 08:07
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public  String Index(){
        return  "Hello Spring Boot";
    }

}
