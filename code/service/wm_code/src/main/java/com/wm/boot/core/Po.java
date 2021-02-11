package com.wm.boot.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wm.boot.utils.DateUtil;
import com.wm.boot.utils.IdUtil;
import com.wm.boot.utils.UserUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author wilson
 * @title PO
 * @description PO基类
 * @date 2021.01.30 07:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Po implements Serializable, Persistable<Long> {

 @Id
 @ApiModelProperty(value = "ID")
 private Long id;

 /*删除除标记*/
 @ReadOnlyProperty
 @JsonIgnore
 private String deleted;

 @ReadOnlyProperty
 @ApiModelProperty(value = "创建人")
 private Long createBy;

 @ReadOnlyProperty
 @ApiModelProperty(value = "创建时间")
 private Long createTime;

 @ApiModelProperty(value = "修改人")
 private Long updateBy;

 @ApiModelProperty(value = "修改时间")
 private Long updateTime;

 /***
  * @title isNew
  * @tescription 判断是否新增操作
  * @version 1.1.0
  * @author wilson
  * @date 2021.02.11 15:14
  * @return boolean
  */
 @Override
 public boolean isNew() {
  if (null == id) {
   IdUtil.newLongID(this.getClass());
   this.deleted = "N";
   this.createTime = DateUtil.getTimespan();
   this.createBy = UserUtil.getUserId();
   return true;
  }
  this.updateTime = DateUtil.getTimespan();
  this.updateBy = UserUtil.getUserId();
  return false;
 }
}
