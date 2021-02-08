package com.wm.boot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wilson
 * @title CheckPermissions
 * @description 权限检查注解
 * @date 2021.01.30 16:38ß
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermissions {
    String[] value();
}
