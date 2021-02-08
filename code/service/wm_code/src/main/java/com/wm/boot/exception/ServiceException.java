package com.wm.boot.exception;

import com.wm.boot.enums.EMessage;
import lombok.Data;

/**
 * @author wilson
 * @title ServiceExecption
 * @description 服务异常
 * @date 2021.01.30 16:58
 */
@Data
public class ServiceException extends RuntimeException {

    private int code;
    private String message;
    public ServiceException() {
       new ServiceException(EMessage.EXCEPTION_SERVICE);
    }
    public ServiceException(EMessage msg) {
        super(msg.getText());
        this.code = msg.getValue();
        this.message = msg.getText();
    }
}
