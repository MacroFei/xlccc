package com.xlccc.ssm.controller.android;

import com.xlccc.ssm.common.BaseResponse;
import com.xlccc.ssm.common.StatusCode;
import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("android_equipment")
public class AndroidEquipmentController {
    @Autowired
    EquipmentService equipmentService;

    BaseResponse responseSuccess = new BaseResponse(StatusCode.Success);
    BaseResponse responseFail = new BaseResponse(StatusCode.Fail);

    /**
     * 返回所有数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "selectAll_equipment")
    @ResponseBody
    public BaseResponse selectAll(User user) {
        List<Equipment> listEquipment = equipmentService.list(user.getCategory());
        if (listEquipment.size() != 0) {
            BaseResponse response = responseSuccess;
            response.setData(listEquipment);
            return response;
        } else {
            BaseResponse response = responseFail;
            return response;
        }
    }

    /**
     * 编辑功能，根据id进行编辑
     *
     * @param equipment
     * @return
     */

    @RequestMapping(value = "edit_equipment")
    @ResponseBody
    public BaseResponse editEquipment(Equipment equipment) {
        int edit = 0;
        if (equipment.getId() != null) {
            edit = equipmentService.update_1(equipment);
        }

        if (edit > 0) {
            BaseResponse response = responseSuccess;
            return response;
        } else {
            BaseResponse response = responseFail;
            return response;
        }
    }

    /**
     * 根据id进行单个删除
     *
     * @param equipment
     * @return
     */
    @RequestMapping(value = "delete_equipment")
    @ResponseBody
    public BaseResponse deleteEquipment(Equipment equipment) {
        equipment.setId(9);
        int delete = 0;
        if (equipment.getId() != null) {
            delete = equipmentService.delete_1(equipment.getId());
        }
        if (delete > 0) {
            BaseResponse response = responseSuccess;
            return response;
        } else {
            BaseResponse response = responseFail;
            return response;
        }
    }

    /**
     *批量删除，id通过拼接方式进行传递
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteAll_equipment")
    @ResponseBody
    public BaseResponse deleteAll(String id) {
        id = "7,8";
        String idDemo = null;
        idDemo = id;
        if (idDemo == null) {
            BaseResponse response = responseFail;
            return response;
        } else {
            int delete = 0;
            delete = equipmentService.deleteAll(id);
            if (delete > 0) {
                BaseResponse response = responseSuccess;
                return response;
            } else {
                BaseResponse response = responseFail;
                return response;
            }
        }
    }

    /**
     * 根据设备名模糊查询，app端如果serial_number为空，自动赋值为kong后进行传参
     * @param equipment
     * @return
     */
    @RequestMapping(value = "searchVariety_equipment")
    @ResponseBody
    public BaseResponse searchVariety(Equipment equipment) {
        equipment.setSerial_number("S");
        equipment.setCategory("A");
        List<Equipment> listEquipment = equipmentService.searchVariety(equipment.getSerial_number(), equipment.getCategory());
        if (listEquipment.size() != 0) {
            BaseResponse response = responseSuccess;//查询成功，code返回0
            response.setData(listEquipment);
            return response;
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }

    /**
     * 查看功能
     * @param equipment
     * @return
     */
    @RequestMapping(value = "select_equipment")
    @ResponseBody
    public BaseResponse select(Equipment equipment) {
        equipment.setId(9);
        if (equipment.getId() != null) {
            Equipment equipments = equipmentService.get(equipment.getId());
            if (equipments == null) {
                BaseResponse response = responseFail;//查询失败，code返回1
                return response;
            } else {
                BaseResponse response = responseSuccess;//查询成功，code返回0
                response.setData(equipments);
                return response;
            }
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }
}
