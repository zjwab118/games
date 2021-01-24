package com.wm.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SpringBootApplication
public class GameApiApplication {

    public static void main(String[] args) {
       SpringApplication.run(GameApiApplication.class, args);
        System.out.println("==========启动成功==========");
    }


}
