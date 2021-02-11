package com.wm.boot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * @author wilson
 * @title JsonUtil
 * @description Json工具类
 * @date 2021.01.30 16:35
 */
public class JsonUtil {

    /***
     * @title isJson
     * @tescription 判断字符串是否JSON格式
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.11 15:18
     * @param str
     * @return boolean
    */
    public  boolean isJson(String str){
        try{
            JSON.parse(str);
            return  true;
        }catch (Exception ex){
            return  false;
        }
    }

    /***
     * @title isJson
     * @tescription 判断字符串是否JSON数组格式
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.11 15:18
     * @param str
     * @return boolean
     */
    public  boolean isJsonArr(String str){
        try{
            JSONArray.parse(str);
            return  true;
        }catch (Exception ex){
            return  false;
        }
    }

}
