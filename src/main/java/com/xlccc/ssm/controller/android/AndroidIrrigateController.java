package com.xlccc.ssm.controller.android;

import com.xlccc.ssm.common.BaseResponse;
import com.xlccc.ssm.common.StatusCode;
import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.IrrigateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("android_irrigate")
public class AndroidIrrigateController {

    @Autowired
    IrrigateService irrigateService;

    BaseResponse responseSuccess = new BaseResponse(StatusCode.Success);
    BaseResponse responseFail = new BaseResponse(StatusCode.Fail);


    /**
     * 返回所有数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "selectAll_irrigate")
    @ResponseBody
    public BaseResponse selectAll(User user) {
        List<Irrigate> listUser = irrigateService.list(user.getCategory());
        if (listUser.size() != 0) {
            BaseResponse response = responseSuccess;//成功返回code 0
            response.setData(listUser);//查询有值
            return response;
        } else {
            BaseResponse response = responseFail;//失败返回code -1
            return response;
        }
    }

    /**
     * 编辑功能，根据id进行编辑
     *
     * @param irrigate
     * @return
     */
    @RequestMapping(value = "edit_irrigate")
    @ResponseBody
    public BaseResponse editIrrigate(Irrigate irrigate) {
//        irrigate.setSerial_number("SSS001");
//        irrigate.setId(9);
//        irrigate.setGreenhouse("陈某的大棚");
        int edit = 0;
        if (irrigate.getId() != null) {
            edit = irrigateService.update_1(irrigate);
        }

        if (edit > 0) {
            BaseResponse response = responseSuccess;//修改成功，code返回0
            return response;
        } else {
            BaseResponse response = responseFail;//修改失败，code返回1
            return response;
        }

    }

    /**
     * 根据id进行单个删除
     *
     * @param irrigate
     * @return
     */
    @RequestMapping(value = "delete_irrigate")
    @ResponseBody
    public BaseResponse deleteIrrigate(Irrigate irrigate) {
        int delete = 0;
       // irrigate.setId(9);
        if (irrigate.getId() != null) {
            delete = irrigateService.delete_1(irrigate.getId());
        }
        if (delete > 0) {
            BaseResponse response = responseSuccess;//删除成功，code返回0
            return response;
        } else {
            BaseResponse response = responseFail;//删除失败，code返回1
            return response;
        }
    }

    /**
     * 批量删除，id通过拼接方式进行传递
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteAll_irrigate")
    @ResponseBody
    public BaseResponse deleteAll(String id) {
//        id = "4,5,6";
        String idDemo = null ;
        idDemo = id;
        if( idDemo == null  ){
            BaseResponse response= responseFail;//删除失败，code返回1
            return response;
        }
        else{
            int delete = 0;
            delete = irrigateService.deleteAll(id);
            if (delete > 0) {
                BaseResponse   response = responseSuccess;//删除成功，code返回0
                return response;
            } else {
                BaseResponse   response = responseFail;//删除失败，code返回1
                return response;
            }

        }
    }
    /**
     * 根据设备名模糊查询，app端如果serial_number为空，自动赋值为kong后进行传参
     * @param irrigate
     * @return
     */
    @RequestMapping(value = "searchVariety_irrigate")
    @ResponseBody
    public BaseResponse searchVariety(Irrigate irrigate) {
//        irrigate.setSerial_number("S");
//        irrigate.setCategory("A");
        List<Irrigate> listIrrigate = irrigateService.searchVariety(irrigate.getSerial_number(), irrigate.getCategory());
        if (listIrrigate.size() != 0) {
            BaseResponse response = responseSuccess;//查询成功，code返回0
            response.setData(listIrrigate);
            return response;
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }

    /**
     * 查看功能
     * @param irrigate
     * @return
     */
    @RequestMapping(value = "select_irrigate")
    @ResponseBody
    public BaseResponse select(Irrigate irrigate) {
//        irrigate.setId(9);
        if (irrigate.getId() != null) {
            Irrigate irrigates = irrigateService.get(irrigate.getId());
            if (irrigates == null) {
                BaseResponse response = responseFail;//查询失败，code返回1
                return response;
            } else {
                BaseResponse response = responseSuccess;//查询成功，code返回0
                response.setData(irrigates);
                return response;
            }
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }

}
