package com.wm.boot.utils;

import com.wm.boot.core.LoginInfo;

/**
 * @author wilson
 * @title UserUtil
 * @description 用户工具类
 * @date 2021.02.11 15:10
 */
public class UserUtil {

   static ThreadLocal<LoginInfo> userSession = new ThreadLocal<LoginInfo>();
    /***
     * @title getUserId
     * @tescription 获取当前登录用户
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.11 15:20
     * @return long
    */
    public  static  Long getUserId(){
        if(null==userSession.get()){
            return  null;
        }
        return  userSession.get().getUserId();
    }

    /***
     * @title getTenantId
     * @tescription 获取当前租户
     * @version 1.1.0
     * @author wilson
     * @date 2021.02.11 15:20
     * @return long
     */
    public  static  long getTenantId(){
        return  2020020100000001L;
    }
}
