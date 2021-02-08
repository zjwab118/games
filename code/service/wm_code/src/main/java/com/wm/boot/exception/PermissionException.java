package com.wm.boot.exception;

import com.wm.boot.enums.EMessage;

/**
 * @author wilson
 * @title ArgsExecption
 * @description 参数异常
 * @date 2021.01.30 16:58
 */
public class PermissionException extends  ServiceException{
    public PermissionException() {
        super(EMessage.EXCEPTION_PERMISSION);
    }
    public PermissionException(EMessage msg) {
        super(msg);
    }
}
