package com.wm.boot.exception;

import com.wm.boot.enums.EMessage;

/**
 * @author wilson
 * @title ArgsExecption
 * @description 参数异常
 * @date 2021.01.30 16:58
 */
public class ArgsException extends  ServiceException{
    public ArgsException() {
        super(EMessage.EXCEPTION_ARGS);
    }
    public ArgsException(EMessage msg) {
        super(msg);
    }
}
