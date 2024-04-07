package com.nathan.chargestation.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author shizewang
 * @version 1.0
 * @description： 角色枚举
 * @date 2021/2/21 1:46 上午
 */
@AllArgsConstructor
public enum RoleEnums {

    /**
     * 设备维修员
     */
    EQUIPMENT_REPAIRMAN(2, "EQUIPMENT_REPAIRMAN"),
    /**
     * 设备管理
     */
    EQUIPMENT_MANAGER(1, "EQUIPMENT_MANAGER"),
    /**
     * 超级管理员
     */
    SUPER_ADMIN(0, "SUPER_ADMIN"),
    ;
    public final Integer type;
    public final String role;
}
