package com.nathan.chargestation.vo;

import lombok.Data;

import java.util.Date;

/**
 * 添加充电站的实体表
 *
 */
@Data
public class EquipmentInfoVo {

    /**
     * 充电枪编号
     */
    private String imei;

    /**
     * 充电站名字
     */
    private String name;

    /**
     * 充电站位置
     */
    private String location;

    /**
     * 直流或者交流
     */
    private String type;

}
