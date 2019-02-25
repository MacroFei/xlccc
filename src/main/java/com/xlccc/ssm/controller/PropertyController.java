package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.Property;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.PropertyService;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    UserService userService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_add")
    public String add(Model model, Property property) {
        propertyService.add(property);
        return "redirect:admin_property_list?uid=" + property.getUid();

    }

    @RequestMapping("admin_property_delete")
    public String delete(int id){
        Property property = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?uid="+property.getUid();
    }

    @RequestMapping("admin_property_edit")
    public String edit (Model model , int id ){
        Property property = propertyService.get(id);
        User u = userService.get(property.getUid());
        property.setUser(u);
        model.addAttribute("p",property);
        return "admin/editProperty";
    }
    @RequestMapping("admin_property_update")
    public String update(Property p){
        propertyService.update(p);
        return "redirect:admin_property_list?uid="+p.getUid();
    }
    @RequestMapping("admin_property_list")
    public String list(int uid , Model model , Page page){
        User u = userService.get(uid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> ps = propertyService.list(uid);
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&uid="+u.getId());

        model.addAttribute("ps",ps);
        model.addAttribute("u",u);
        model.addAttribute("page",page);
        return "admin/listProperty";

    }


}
