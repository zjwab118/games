package com.wm.boot.exception;

import com.wm.boot.enums.EMessage;

/**
 * @author wilson
 * @title ArgsExecption
 * @description 参数异常
 * @date 2021.01.30 16:58
 */
public class TokenException extends  ServiceException{
    public TokenException() {
        super(EMessage.EXCEPTION_TOKEN);
    }
    public TokenException(EMessage msg) {
        super(msg);
    }
}
