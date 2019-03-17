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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("")
public class DataController {

    @Autowired
    DataService dataService;

    @RequestMapping("data_list")
    public String list(Model model , Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Data> ds = dataService.list();
        int total = (int) new PageInfo<>(ds).getTotal();
        page.setTotal(total);
        int totalNumber = dataService.selectTotalNumber();
        System.out.print(totalNumber);
        model.addAttribute("ds",ds);
        model.addAttribute("page",page);
        model.addAttribute("totalNumber",totalNumber);
        return "dataManagement";
    }

    @RequestMapping("data_add")
    public String add(Data d  , HttpSession session , UploadedImageFile uploadedImageFile ){
        dataService.add(d);
//        File imageFolder = new File(httpSession.getServletContext().getRealPath("img/data"));
//        File file = new File(imageFolder,d.getId()+".jpg");

        return "redirect:/data_list";
    }
    @RequestMapping("data_delete")
    public String delete(int id , HttpSession session){
        dataService.delete(id);
        return "redirect:/data_list";
    }
    @RequestMapping("admin_data_edit")
    public String edit(int id , Model model ){
        Data d  = dataService.get(id);
        model.addAttribute("d",d);
        return "admin/editData";
    }
    @RequestMapping("data_update")
    public String update(Data d ){
        dataService.update(d);
        return "redirect:/data_list";
    }

}
