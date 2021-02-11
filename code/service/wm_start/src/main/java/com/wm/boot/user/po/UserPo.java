package com.wm.boot.user.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wm.boot.core.Po;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

/**
 * @author wilson
 * @title UserPo
 * @description 用户
 * @date 2021.02.06 17:53
 */
@Data
@Table("sys_user")
public class UserPo extends Po {

    @JsonIgnore
    private Long tenantId; //租户ID

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "头像地址")
    private String logUrl;

    @ApiModelProperty(value = "生日")
    private Date birthDate;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @JsonIgnore
    @ApiModelProperty(value = "密码")
    private String password;

    @JsonIgnore
    @ApiModelProperty(value = "加密盐值")
    private String key;

    @ReadOnlyProperty
    @ApiModelProperty(value = "状态：-1-无效， 0-新增，1-有效")
    private int status;
}
