package com.xlccc.ssm.controller.android;


import com.xlccc.ssm.common.BaseResponse;
import com.xlccc.ssm.common.StatusCode;
import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.CropService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("android_crop")
public class AndroidCropController {
    @Autowired
    CropService cropService;


    BaseResponse responseSuccess = new BaseResponse(StatusCode.Success);
    BaseResponse responseFail = new BaseResponse(StatusCode.Fail);

    /**
     * 返回所有数据
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "selectAll_crop")
    @ResponseBody
    public BaseResponse selectAll(User user) {
        List<Crop> listUser = cropService.list(user.getCategory());
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
     * @param crop
     * @return
     */
    @RequestMapping(value = "edit_crop")
    @ResponseBody
    public BaseResponse editCrop(Crop crop) {
        int edit = 0;
        if (crop.getId() != null) {
            edit = cropService.update_1(crop);
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
     * @param crop
     * @return
     */
    @RequestMapping(value = "delete_crop")
    @ResponseBody
    public BaseResponse deleteCrop(Crop crop) {
        int delete = 0;
        if (crop.getId() != null) {
            delete = cropService.delete_1(crop.getId());
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
    @RequestMapping(value = "deleteAll_crop")
    @ResponseBody
    public BaseResponse deleteAll(String id) {
        String idDemo = null ;
        idDemo = id;
        if( idDemo == null  ){
            BaseResponse response= responseFail;//删除失败，code返回1
            return response;
        }
        else{
        int delete = 0;
        delete = cropService.deleteAll(id);
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
     * 根据品种名称模糊查询,app前端如果variety为空，自动赋值为kong后进行传参
     *
     * @param crop
     * @return
     */
    @RequestMapping(value = "searchVariety_crop")
    @ResponseBody
    public BaseResponse searchVariety(Crop crop) {
        crop.setCategory("A");
        List<Crop> listCrop = cropService.searchVariety(crop.getVariety(), crop.getCategory());
        if (listCrop.size() != 0) {
            BaseResponse response = responseSuccess;//查询成功，code返回0
            response.setData(listCrop);
            return response;
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }

    /**
     * 查看功能
     *
     * @param crop
     * @return
     */
    @RequestMapping(value = "select_crop")
    @ResponseBody
    public BaseResponse select(Crop crop) {
        crop.setId(9);
        if (crop.getId() != null) {
            Crop crops = cropService.get(crop.getId());
            if (crops == null) {
                BaseResponse response = responseFail;//查询失败，code返回1
                return response;
            } else {
                BaseResponse response = responseSuccess;//查询成功，code返回0
                response.setData(crops);
                return response;
            }
        } else {
            BaseResponse response = responseFail;//查询失败，code返回1
            return response;
        }
    }
}
