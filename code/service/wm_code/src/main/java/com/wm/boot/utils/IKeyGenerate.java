package com.wm.boot.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author wilson
 * @title IKeyGenerate
 * @description 主键生成器
 * @date 2021.02.08 19:54
 */
public interface IKeyGenerate {

    /***
     * @title newUUID
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.08 19:56
     * @return java.lang.String
    */
     default  String newUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase().replaceAll("-","");
    }

    /***
     * @title newLongID
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.08 19:57

     * @return java.lang.Long
    */
    default Long newLongID(){
        return System.currentTimeMillis()*1000+ new Random().nextInt();
    }

    /***
     * @title newLongIDs
     * @tescription TODO
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.08 19:57
     * @param clazz
     * @return java.lang.Long
    */
    Long newLongID(Class<?> clazz);
}
