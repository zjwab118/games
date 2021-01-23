package com.wm.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApiApplication.class, args);

        System.out.println("==========启动成功==========");
    }

}
