package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Data;
import com.xlccc.ssm.service.DataService;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping("data_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Data> ds = dataService.list();
        int total = (int) new PageInfo<>(ds).getTotal();
        page.setTotal(total);
        int totalNumber = dataService.selectTotalNumber();
//        System.out.print(totalNumber);
//        System.out.println("hello");
        model.addAttribute("ds", ds);
        model.addAttribute("page", page);
        model.addAttribute("totalNumber", totalNumber);
        return "dataManagement";
    }

    @RequestMapping("data_add")
    public String add(Data d, HttpSession session, UploadedImageFile uploadedImageFile) {
        dataService.add(d);
//        File imageFolder = new File(httpSession.getServletContext().getRealPath("img/data"));
//        File file = new File(imageFolder,d.getId()+".jpg");

        return "redirect:/data_list";
    }

    @RequestMapping("data_delete")
    public String delete(int id, HttpSession session) {
        dataService.delete(id);
        return "redirect:/data_list";
    }

    @RequestMapping("data_edit")
    public String edit(int id, Model model) {
        Data d = dataService.get(id);
        model.addAttribute("d", d);
        return "dataManagement";
//        return "admin/editData";
    }

//    @RequestMapping("data_edit")
//    public String edit(int id, Model model) {
//        Data d = dataService.get(id);
//        List<Data> ds = new ArrayList<Data>();
//        ds.add(d);
//        model.addAttribute("ds", ds);
////        return "admin/editData";
//        return "dataManagement";
//    }

    @RequestMapping("data_update")
    public String update(Data d) {
        dataService.update(d);
        return "redirect:/data_list";
    }

//    @RequestMapping("data_deleteAll")
//    public String deleteAll(String[] checkbox, Model model) {
////d
////        System.out.print(checkbox.to);
////        checkbox.toString();
//
////        for (int i = 0; i < checkbox.length; i++) {
////            dataService.delete(checkbox.);
////        }
//        //return "redirect:/data_list";
//    }

    @RequestMapping("data_get")
    public String get( int  id){
        Data data = dataService.get( id );

        return "redirect:/data_list";
    }

    @RequestMapping("data_deleteAll")
    public String deleteAll(String ids) {

        for (String demo : ids.split(",")
                ) {
            int id = Integer.parseInt(demo);
            dataService.delete(id);
        }

        return "redirect:/data_list";
    }

    @RequestMapping(value = "data_area_list" , method = RequestMethod.POST)
    @ResponseBody
   public String dataAreaList(Data data , HttpSession session){

        String province = data.getProvince();

        String city = data.getCity();

        String district = data.getDistrict();

         return "redirect:/data_list";

    }

}
