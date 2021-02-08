package com.wm.boot.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wm.boot.enums.EMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author wilson
 * @title API
 * @description API返回值封装
 * @date 2021.01.30 07:48
 */
@Data
@ApiModel(value="视图层返回Api对象",
        description="视图层返回Api对象  success:成功状态  code:编号  msg:信息  timestamp:时间戳  data:数据 time:时间开销")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "成功状态")
    private boolean success;

    @ApiModelProperty(value = "消息")
    private String msg;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "时间戳")
    private long timestamp;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "时间开销")
    private int time;


    /**
     * 构造函数
     */
    public Result() {
        // 初始化值
        this.success = true;
        this.msg = EMessage.SUCCESS.getText();
        this.code = HttpStatus.OK.value();
        this.timestamp = System.currentTimeMillis();
    }

    // ================================== 静态方法 ===================================

    /**
     * 返回成功状态
     * @return ResultVo<Object>
     */
    public static<T> Result<T> success() {
        return new Result<>();
    }

    /**
     * 返回成功状态
     * @param data 返回数据
     * @param <T> 泛型
     * @return ResultVo<T>
     */
    public static <T> Result<T> success(T data) {
        Result<T> ret = success();
        ret.setData(data);
        return ret;
    }

    /**
     * 返回错误状态
     * @return ResultVo<T>
     */
    public static <T> Result<T> error() {
        Result<T> ret = new Result<>();
        ret.setMsg(EMessage.ERROR.getText());
        ret.setCode(EMessage.ERROR.getValue());
        ret.setSuccess(false);
        return ret;
    }
    /**
     * 返回错误状态
     * @param msg 返回信息
     * @return ResultVo<T>
     */
    public static <T> Result<T> error(String msg) {
        Result<T> ret = error();
        ret.setMsg(msg);
        return ret;
    }
    /**
     * 返回错误状态
     * @param code 错误编号
     * @param msg 返回信息
     * @return ResultVo<T>
     */
    public static <T> Result<T> error(int code, String msg) {
        Result<T> ret = error(msg);
        ret.setCode(code);
        return ret;
    }

    /**
     * 返回成功状态
     * @param code 错误编号
     * @param data 返回数据
     * @param <T> 泛型
     * @return ResultVo<T>
     */
    @JsonIgnore//返回对象时忽略此属性
    public static <T> Result<T> error(int code, String msg, T data) {
        Result<T> ret = error(code,msg);
        ret.setData(data);
        return ret;
    }

}
