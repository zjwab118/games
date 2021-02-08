--########## 建表语句 ###########--
DROP TABLE IF EXISTS `sys_tenant`;
CREATE TABLE `sys_tenant` (
     `id` bigint(19) NOT NULL COMMENT '主键',
     `tenant_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '租户ID',
     `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
     `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编码',
     `log_url` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'logo',
     `company_name` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名称',
     `contact_phone` varchar (20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
     `status` int(10) NOT NULL DEFAULT 0 COMMENT '状态：-1-无效， 0-新增，1-有效',
     `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
     `create_by` bigint(19) NOT NULL COMMENT '创建用户',
     `create_time` bigint(19) NOT NULL COMMENT '创建日期',
     `update_by` bigint(19) NOT NULL COMMENT '修改用户',
     `update_time` bigint(19) NOT NULL COMMENT '修改日期',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='系统组户';

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` bigint(19) NOT NULL COMMENT '主键',
    `tenant_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '租户ID',
    `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
    `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
    `log_url` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像地址',
    `birth` date DEFAULT NULL COMMENT '生日',
    `email` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱地址',
    `mobile` varchar (20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
    `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
    `key` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '加密盐值',
    `status` int(10) NOT NULL DEFAULT 0 COMMENT '状态：-1-无效， 0-新增，1-有效',
    `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
    `create_by` bigint(19) NOT NULL COMMENT '创建用户',
    `create_time` bigint(19) NOT NULL COMMENT '创建日期',
    `update_by` bigint(19) NOT NULL COMMENT '修改用户',
    `update_time` bigint(19) NOT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='系统用户';

DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
    `id` bigint(19) NOT NULL COMMENT '主键',
    `user_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '用户ID',
    `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
    `auth_type` int(10) NOT NULL DEFAULT 1 COMMENT '认证类型：1-密码，2第三方认证如微信，3短信验证码，4邮箱验证码',
    `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
    `create_by` bigint(19) NOT NULL COMMENT '创建用户',
    `create_time` bigint(19) NOT NULL COMMENT '创建日期',
    `update_by` bigint(19) NOT NULL COMMENT '修改用户',
    `update_time` bigint(19) NOT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='系统账号';

DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
    `id` bigint(19) NOT NULL COMMENT '主键',
    `user_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '用户ID',
    `balance` decimal (18,2)  COMMENT '余额',
    `integral` int(10)  COMMENT '积分',
    `status` int(10) NOT NULL DEFAULT 1 COMMENT '状态：-1-无效， 0-新增，1-有效',
    `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
    `create_by` bigint(19) NOT NULL COMMENT '创建用户',
    `create_time` bigint(19) NOT NULL COMMENT '创建日期',
    `update_by` bigint(19) NOT NULL COMMENT '修改用户',
    `update_time` bigint(19) NOT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='用户账户';

DROP TABLE IF EXISTS `user_payment_record`;
CREATE TABLE `user_payment_record` (
     `id` bigint(19) NOT NULL COMMENT '主键',
     `tenant_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '租户ID',
     `user_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '用户ID',
     `amount` decimal (18,2) NOT NULL  COMMENT '交易金额：正数是收益，负数是支出',
     `entry_type` int (10) NOT NULL  COMMENT '交易类型：1-充值，2-兑奖，3-平台费用，4-投注，5-提现',
     `entry_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '交易条目ID',
     `entry` decimal (18,2)  COMMENT '交易条目',
     `status` int(10) NOT NULL DEFAULT 1 COMMENT '状态：0-新增，1-冻结中，2-已结算',
     `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
     `create_by` bigint(19) NOT NULL COMMENT '创建用户',
     `create_time` bigint(19) NOT NULL COMMENT '创建日期',
     `update_by` bigint(19) NOT NULL COMMENT '修改用户',
     `update_time` bigint(19) NOT NULL COMMENT '修改日期',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='用户支付记录';


DROP TABLE IF EXISTS `user_blank`;
CREATE TABLE `user_blank` (
     `id` bigint(19) NOT NULL COMMENT '主键',
     `tenant_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '租户ID',
     `user_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '用户ID',
     `name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开户行名称',
     `card_no`  varchar (20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '银行卡号',
     `branch_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支行名称',
     `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '默认标记',
     `status` int(10) NOT NULL DEFAULT 1 COMMENT '状态：0-新增，1-已验证',
     `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
     `create_by` bigint(19) NOT NULL COMMENT '创建用户',
     `create_time` bigint(19) NOT NULL COMMENT '创建日期',
     `update_by` bigint(19) NOT NULL COMMENT '修改用户',
     `update_time` bigint(19) NOT NULL COMMENT '修改日期',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='用户银行卡号';


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
    `id` bigint(19) NOT NULL COMMENT '主键',
    `tenant_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '租户ID',
    `user_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '用户ID',
    `order_no` varchar (20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
    `order_name` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
    `order_amount`  decimal (18,2)  COMMENT '订单金额',
    `remark` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
    `status` int(10) NOT NULL DEFAULT 1 COMMENT '状态：-1-已取消,0-新增待支付，1-支付失败，2-已支付',
    `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
    `create_by` bigint(19) NOT NULL COMMENT '创建用户',
    `create_time` bigint(19) NOT NULL COMMENT '创建日期',
    `update_by` bigint(19) NOT NULL COMMENT '修改用户',
    `update_time` bigint(19) NOT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='订单';

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
    `id` bigint(19) NOT NULL COMMENT '主键',
    `order_id` bigint(19) NOT NULL DEFAULT 0 COMMENT '订单ID',
    `item_name` varchar (50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
    `item_amount`  decimal (18,2)  COMMENT '金额',
    `item_count`  int (10)  COMMENT '金额',
    `total_amount`  decimal (18,2)  COMMENT '金额',
    `deleted` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '逻辑删除标记位',
    `create_by` bigint(19) NOT NULL COMMENT '创建用户',
    `create_time` bigint(19) NOT NULL COMMENT '创建日期',
    `update_by` bigint(19) NOT NULL COMMENT '修改用户',
    `update_time` bigint(19) NOT NULL COMMENT '修改日期',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COLLATE=utf8_general_ci COMMENT='订单明细';
