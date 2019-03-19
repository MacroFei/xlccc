package com.xlccc.ssm.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Equipment;
import com.xlccc.ssm.service.EquipmentService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    @RequestMapping("equipment_list")
    public String list(Model model , Page page ){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Equipment> es =  equipmentService.list();
        int total = (int) new PageInfo<>(es).getTotal();
        page.setTotal(total);
        int totalNumber = equipmentService.selectTotalNumber();
        model.addAttribute("totalNumber" , totalNumber);
        model.addAttribute("es",es);
        model.addAttribute("page",page);
        return "equipment_management";
    }
//        return "equipment-management";

    @RequestMapping("equipment_add")
    public String add(Equipment equipment , HttpSession httpSession){
        equipmentService.add(equipment);
        return "redirect:/equipment_list";
    }
    @RequestMapping("equipment_delete")
    public String delete(int id , HttpSession session){
        equipmentService.delete(id);
        return "redirect:/equipment_list";

    }

    @RequestMapping("equipment_edit")
    public String edit(int id , Model model ){
        Equipment e = equipmentService.get(id);
        model.addAttribute("e" , e);
        return "equipment_edit"; //  需要修改为编辑页面
    }

    @RequestMapping("equipment_update")
    public String update(Equipment equipment){
        equipmentService.update(equipment);
        return "redirect:/equipment_list";
    }

    @RequestMapping("equipment_deleteAll")
    public String deleteAll(String ids ){
        for (String idDemo: ids.split(",")
             ) {
            int id = Integer.parseInt(idDemo);
            equipmentService.delete(id);

        }
        return "redirect:/equipment_list";
    }

}
