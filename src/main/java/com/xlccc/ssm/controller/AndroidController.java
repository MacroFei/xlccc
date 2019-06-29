package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Android;
import com.xlccc.ssm.pojo.AndroidPic;
import com.xlccc.ssm.service.AndroidPicService;
import com.xlccc.ssm.service.AndroidService;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AndroidController {
    @Autowired
    AndroidService androidService;
    @Autowired
    AndroidPicService androidPicService;

    @RequestMapping("admin_android_list")
    public String list(Model model , Page page ){
        PageHelper.offsetPage(page.getStart() , page.getCount());
        List<Android> as  = androidService.list();

        int total = (int) new PageInfo<>(as).getTotal();
        page.setTotal(total);
//        page.setParam("&");
        model.addAttribute("as",as);
        model.addAttribute("page",page);
        return "admin/listAndroid";
    }

    @RequestMapping("admin_android_add")
    public String add(Model model , Android android )
    {
        androidService.add(android);
        return "redirct:/admin_android_list";
    }
    @RequestMapping("admin_android_delete")
    public String delete(int id ){
        androidService.delete(id );
        return "redirct:/admin_android_list";
    }
    @RequestMapping("admin_android_edit")
    public String edit(Model model , int androidId ){
        Android a =  androidService.get(androidId);
        model.addAttribute("a",a);
        return "admin/editAndroid";
    }
    @RequestMapping("admin_android_update")
    public String update(Android android){
        androidService.update(android);
        return "redirect:/admin_android_list";
    }

    @RequestMapping("android_get_detail_pictures")
    @ResponseBody
    public Result getPictures(){
//@RequestBody Android android
//        List<AndroidPic> androidPicList =androidPicService.list(android.getId(),AndroidPicService.type_detail);
//
//        for (AndroidPic ap: androidPicList
//             ) {
//            String fileName = "http:localhost:8080/ssm/img/magspaceDetail/"+ap.getName()+"_"+ap.getId()+".jpg";
//            ap.setUrl(fileName);
//        }
//        System.out.println(androidPicList.toString());

        return Result.success();
        //return Result.success(androidPicList);
    }

}
