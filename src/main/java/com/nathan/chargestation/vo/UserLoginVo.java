package com.nathan.chargestation.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.nathan.chargestation.common.consts.Constast;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserLoginVo  implements Serializable {


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



    /**
     * token
     */

    private String token;




}
