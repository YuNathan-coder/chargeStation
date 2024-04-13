package com.nathan.chargestation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备信息实体表
 *
 */
@Data
@TableName("equipment_info")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class EquipmentInfo implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 工作状态
     */
    private String operateState;

    /**
     * 告警状态
     */
    private String alarmState;

    /**
     * 车连接状态
     */
    private String vehicleAttachmentState;

    /**
     * 直流或者交流
     */
    private String type;

    /**
     * 直流充电电压
     */
    private String dcVoltage;

    /**
     * 直流充电电流
     */
    private String dcCurrent;

    /**
     * 交流 A 相充电电压
     */
    private String acaVoltage;

    /**
     * 交流 B 相充电电压
     */
    private String acbVoltage;

    /**
     * 交流 C 相充电电压
     */
    private String accVoltage;

    /**
     * 交流 A 相充电电流
     */
    private String acaCurrent;

    /**
     * 交流 B 相充电电流
     */
    private String acbCurrent;

    /**
     * 交流 C 相充电电流
     */
    private String accCurrent;

    /**
     * 预约标志
     */
    private String reservationState;

    /**
     * 环境温度
     */
    private String environmentTemperature;

    /**
     * 充电枪温度
     */
    private String gunTemperature;

    /**
     * 累计充电电量
     */
    private String accumulatePower;

    /**
     * 枪归位状态
     */
    private String gunState;

    /**
     * 地锁状态
     */
    private String groundLockState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 数据更新时间
     */
    private Date updateTime;




}
