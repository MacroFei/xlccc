package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Irrigate;
import com.xlccc.ssm.service.IrrigateService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class IrrigateController {

    @Autowired
    IrrigateService irrigateService;

    @RequestMapping("irrigate_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Irrigate> is = irrigateService.list();
        int total = (int) new PageInfo<>(is).getTotal();
        page.setTotal(total);
        int totalNumber = irrigateService.selectTotalNumber();
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("is", is);
        model.addAttribute("page", page);
        return "irrigation_management";
    }

    @RequestMapping("irrigate_add")
    public String add(Irrigate irrigate, HttpSession session) {
        irrigateService.add(irrigate);
        return "irrigate_list";
    }

    @RequestMapping("irrigate_delete")
    public String delete(int id, Model model) {
        irrigateService.delete(id);
        return "redirect:/irrigate_list";
    }

    @RequestMapping("irrigate_edit")
    public String edit(int id, Model model) {
        Irrigate i = irrigateService.get(id);
        model.addAttribute("i", i);
        return "irrigation_edit";
    }

    @RequestMapping("irrigate_update")
    public String update(Irrigate i) {
        irrigateService.update(i);
        //return "redirect:/irrigate_list";
        return "redirect:/irrigate_list";
    }

    @RequestMapping("irrigate_deleteAll")
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            irrigateService.delete(id);

        }
        return "redirect:/irrigate_list";
    }


}
