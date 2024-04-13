package com.nathan.chargestation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nathan.chargestation.common.enums.ErrorCodeEnums;
import com.nathan.chargestation.common.utils.OptResult;
import com.nathan.chargestation.entity.EquipmentInfo;
import com.nathan.chargestation.entity.User;
import com.nathan.chargestation.mapper.EquipmentInfoMapper;
import com.nathan.chargestation.service.EquipmentInfoService;
import com.nathan.chargestation.vo.EquipmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EquipmentInfoServicelmpl extends ServiceImpl<EquipmentInfoMapper, EquipmentInfo> implements EquipmentInfoService {

    @Autowired
    private EquipmentInfoMapper equipmentInfoMapper;

    /**
     * 添加设备
     * @param equipmentInfoVo
     * @return
     */
    @Override
    public OptResult addEquipmentInfo(EquipmentInfoVo equipmentInfoVo) {

        EquipmentInfo equipmentInfo = new EquipmentInfo();

        if (findByImei(equipmentInfoVo.getImei()) != null){
            return OptResult.error(ErrorCodeEnums.IMEI_EXISTS);
        }

        equipmentInfo.setImei(equipmentInfoVo.getImei());
        equipmentInfo.setName(equipmentInfoVo.getName());
        equipmentInfo.setLocation(equipmentInfoVo.getLocation());
        equipmentInfo.setType(equipmentInfoVo.getType());
        equipmentInfo.setCreateTime(new Date());

        super.save(equipmentInfo);

        return OptResult.ok(equipmentInfo);
    }

    /**
     * 通过imei号查找设备
     * @param imei
     * @return
     */
    @Override
    public EquipmentInfo findByImei(String imei) {
        QueryWrapper<EquipmentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("imei",imei);
        return super.getOne(queryWrapper,false);
    }


    /**
     * 查找所有设备
     * @return
     */
    @Override
    public List<EquipmentInfo> findAllEquipmentInfo() {
        QueryWrapper<EquipmentInfo> queryWrapper = new QueryWrapper<>();

        List<EquipmentInfo> equipmentInfoList = super.list(queryWrapper);
        return equipmentInfoList;
    }

    /**
     * 查找所有报警设备
     */
    @Override
    public List<EquipmentInfo> findAlarmEquipment() {

        QueryWrapper<EquipmentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("alarm_state","报警");

        List<EquipmentInfo> alarmEquipmentInfoList = super.list(queryWrapper);

        return alarmEquipmentInfoList;
    }
}

