package com.nathan.chargestation.controller;


import com.nathan.chargestation.common.utils.OptResult;
import com.nathan.chargestation.service.EquipmentInfoService;
import com.nathan.chargestation.vo.EquipmentInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equip")
public class EquipentInfoController {
    @Autowired
    private EquipmentInfoService equipmentInfoService;

    @PostMapping("/addEquip")
    public OptResult addEquipmentInfo (@RequestBody EquipmentInfoVo equipmentInfoVo){

        return equipmentInfoService.addEquipmentInfo(equipmentInfoVo);

    }


}
