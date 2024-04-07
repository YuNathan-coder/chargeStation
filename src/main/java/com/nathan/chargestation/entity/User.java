package com.nathan.chargestation.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nathan.chargestation.common.consts.Constast;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:NathanYu
 * @Description: 用户实体表
 * @Date: 2022/7/21 3:14
 * @param

 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;
    /**
     * 地址
     */
    private String address;
    /**
     * 电话
     */
    private String phone;
    /**
     * 用户类型
     * 0：超级管理员
     * 1：设备管理
     * 2：设备维修员
     */
    private Integer type;
    /**
     * 盐加密
     */
    private String salt;
    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = Constast.TIME_FORM)
    private Date registeredTime;


}