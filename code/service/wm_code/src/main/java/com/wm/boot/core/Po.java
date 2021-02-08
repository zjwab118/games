package com.wm.boot.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author wilson
 * @title PO
 * @description PO基类
 * @date 2021.01.30 07:47
 */
@Data
public class Po implements Serializable {

 @Id
 @ApiModelProperty(value = "ID")
 private long id;
 @ApiModelProperty(value = "创建人")
 private String deleted;
 private long createBy;
 @ApiModelProperty(value = "修改人")
 private long updateBy;
 @ApiModelProperty(value = "修改时间")
 private long updateTime;
 @ApiModelProperty(value = "创建时间")
 private long createTime;

 /**
  * 是否是内部Api调用
  */
 @JsonIgnore
 private boolean izApi;

 /**
  * 是否 手动操控 （如果为true 则可以手动指定创建人和修改人 如果为空则默认）
  */
 @JsonIgnore
 private boolean izManual;
}
