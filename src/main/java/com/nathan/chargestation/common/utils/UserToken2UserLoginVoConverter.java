package com.nathan.chargestation.common.utils;

import com.nathan.chargestation.entity.User;
import com.nathan.chargestation.vo.UserLoginVo;
import org.springframework.beans.BeanUtils;

/**
 * @author shizewang
 * @version 1.0
 * @description：
 * @date 2021/2/21 1:36 上午
 */
public class UserToken2UserLoginVoConverter {

    public static UserLoginVo convert(User user, String token)  {

        UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(user,userLoginVo);
        userLoginVo.setToken(token);
        return userLoginVo;
    }
}
