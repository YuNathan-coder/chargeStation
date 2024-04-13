package com.nathan.chargestation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nathan.chargestation.common.utils.OptResult;
import com.nathan.chargestation.entity.EquipmentInfo;
import com.nathan.chargestation.entity.Loginfo;
import com.nathan.chargestation.vo.EquipmentInfoVo;

import java.util.List;


/**
 * <p>
 * InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author luoyi-
 * @since 2019-11-23
 */
public interface EquipmentInfoService extends IService<EquipmentInfo> {


    /**
     * 添加设备
     * @param equipmentInfoVo
     * @return
     */
    OptResult addEquipmentInfo (EquipmentInfoVo equipmentInfoVo);


    /**
     * 通过imei号查找设备
     * @param imei
     * @return
     */
    EquipmentInfo findByImei (String imei);


    /**
     * 查找所有设备
     * @return
     */
    List<EquipmentInfo> findAllEquipmentInfo();

    /**
     * 查找所有报警设备
     */
    List<EquipmentInfo> findAlarmEquipment();
}
