package com.nathan.chargestation.controller;


import com.nathan.chargestation.common.enums.ErrorCodeEnums;
import com.nathan.chargestation.common.utils.IdGenerate;
import com.nathan.chargestation.common.utils.OptResult;
import com.nathan.chargestation.entity.User;
import com.nathan.chargestation.service.UserService;
import com.nathan.chargestation.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author:NathanYu
     * @Description: 添加用户
     * @Date: 2022/7/21 9:01
     * @param
     * @return OptResult
     */
    @PostMapping("/addUser")
    public OptResult addUser (@RequestBody UserVo userVo) {


        return userService.addUser(userVo);

    }

    /**
     * @Author:NathanYu
     * @Description: 根据登录名查询用户
     * @Date: 2022/7/21 9:01
     * @param loginName
     * @return OptResult
     */
    @GetMapping("/findUser")
    public OptResult findByLoginName (@RequestParam String loginName) {
        User user = new User();
        user = userService.findByLoginName(loginName);
        if(user == null) {
            return OptResult.error(ErrorCodeEnums.USER_NOT_EXISTS);
        }
        return OptResult.ok(user);
    }


    /**
     * 重置密码为初始密码
      * @param id
     * @return
     */
    @PutMapping("/rest")
    public OptResult restPassword (@RequestParam Integer id) {
        return userService.restPassword(id);
    }


    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @param newPasswordAgain
     * @return
     */
    @PutMapping("/changePassword")
    public OptResult changePassword (@RequestParam Integer id,
                                     @RequestParam String oldPassword,
                                     @RequestParam String newPassword, 
                                     @RequestParam String newPasswordAgain) {
        if (!newPassword.equals(newPasswordAgain)) {
            return OptResult.error(ErrorCodeEnums.TWO_PASSWORD_NOT_SAME);
        }
        return userService.changePassword(id, oldPassword, newPassword);

    }

    @GetMapping("/findAllUser")
    public OptResult findAllUser (@RequestBody User user) {

        List<User> userList = userService.findAllUser(user);

        if (userList.size()  == 0) {
            return OptResult.error("没有查询到对应的用户");
        }

        return OptResult.ok(userList);

    }


}
