package com.xlccc.ssm.controller.android;


import com.xlccc.ssm.common.BaseResponse;
import com.xlccc.ssm.common.StatusCode;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("android_user")
public class AndroidUserController {
    @Autowired
    UserService userService;


    BaseResponse responseSuccess = new BaseResponse(StatusCode.Success);
    BaseResponse responseFail = new BaseResponse(StatusCode.Fail);
    /**
     * 返回所有数据
     * @param user
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public BaseResponse login(User user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        if (resultUser == null) {
            BaseResponse response = responseFail;
            return response;//账号密码错误，返回code -1
        } else {
            if (resultUser.getUuid().equals("1")) {
                BaseResponse response = responseFail;//失败返回code -1
                response.setData("1");//1表示已登陆
                return response;
            } else {
                int uu = userService.updateUUID("1",resultUser.getId());
                if (uu > 0) {
                    BaseResponse response = responseSuccess;
                    response.setData(resultUser);//登陆成功返回code 0和user对象(其中包含uuid)
                    return response;
                } else {
                    BaseResponse response = responseFail;
                    response.setData("2");//状态码修改失败
                    return response;
                }
            }

        }
    }


    /**
     * 退出功能
     * 成功则返回code 0
     *
     * @return
     */
    @RequestMapping(value = "logout")
    @ResponseBody
    public BaseResponse logout(User user) {
        int uu = userService.updateUUID("0",user.getId());
        if (uu > 0) {
            BaseResponse response = responseSuccess;//退出成功，返回code0（安卓本地清理数据）
            return response;
        } else {
            BaseResponse response = responseFail;//退出失败，返回code0（安卓本地清理数据）
            return response;
        }
    }

    /**
     * 用户更新密码
     * 验证Android端上传的信息中uuid是否存在
     * 存在则更新信息
     * 成功则返回code 0 和 用户信息
     * 失败则返回code -1
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "update_password")
    @ResponseBody
    public BaseResponse updatePassword(User user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        int update = userService.updatePassword(user);
        if (update>0){
            BaseResponse response = responseSuccess;//密码修改成功，code返回0
            return response;
        }else {
            BaseResponse response = responseFail;//密码修改失败，code返回1
            return response;
        }
    }

}
