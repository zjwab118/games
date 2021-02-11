package com.wm.boot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wilson
 * @title DateUtil
 * @description 时间工具类
 * @date 2021.01.30 16:34
 */
public class DateUtil {

    public  static final String YYYYMMDD="yyyyMMdd";

    public  static DateFormat getFormat(String fromat){
       return new SimpleDateFormat(fromat);
    }

    public static Date now(){
        return  new Date();
    }

    public  static  Long getTimespan(){
        return  System.currentTimeMillis();
    }
}
