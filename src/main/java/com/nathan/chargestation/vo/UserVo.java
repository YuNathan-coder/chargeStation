package com.nathan.chargestation.vo;

import lombok.Data;

@Data
public class UserVo  {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

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



}
