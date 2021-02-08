package com.wm.boot.user.po;

import com.wm.boot.core.Po;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author wilson
 * @title UserPo
 * @description 用户
 * @date 2021.02.06 17:53
 */
@Data
@Table("sys_user")
public class UserPo extends Po {
}
