package com.wm.boot.annotation;

import java.lang.annotation.*;

/**
 * @author wilson
 * @title CheckPermissions
 * @description 参数检查注解
 * @date 2021.01.30 16:38ß
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckArgs {
    String[] value();
}
