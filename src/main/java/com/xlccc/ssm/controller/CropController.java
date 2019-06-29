package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Crop;
import com.xlccc.ssm.service.CropService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("")
public class CropController {
    @Autowired
    CropService cropService;

    @RequestMapping("crop_list")
    public String List(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Crop> cs = cropService.list();
        int total = (int) new PageInfo<>(cs).getTotal();
        page.setTotal(total);

        int totalNumber = cropService.selectTotalNumber();
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("cs", cs);
        model.addAttribute("page", page);
        return "crop_management";
    }

    @RequestMapping("crop_add")
    public String add(Crop crop, HttpSession session) {
        cropService.add(crop);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_delete")
    public String delete(int id, HttpSession session) {
        cropService.delete(id);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_edit")
    public String edit(int id, Model model) {
        Crop crop = cropService.get(id);
        model.addAttribute("crop", crop);
        return "crop_edit";
    }

    @RequestMapping("crop_update")
    public String update(Crop crop) {
        cropService.update(crop);
        return "redirect:/crop_list";
    }

    @RequestMapping("crop_deleteAll")
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            cropService.delete(id);
            System.out.print("ashjiodjaios+删除成功");
        }
        return "redirect:/crop_list";
    }

}
