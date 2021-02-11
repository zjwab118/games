package com.wm.boot.core;

import lombok.Data;

/**
 * @author wilson
 * @title LoginInfo
 * @description 登录信息
 * @date 2021.01.30 07:47
 */
@Data
public class LoginInfo {

    private  Long userId;
    private  String userName;

    private  String account;

    private  String tenantName;
    private  Long tenantId;

    private String roleJson;

    private  String perimsionJson;

}
