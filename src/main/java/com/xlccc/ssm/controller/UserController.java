package com.xlccc.ssm.controller;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String list(Model model, Page page) {
        List<User> us = userService.list(page);
        int total = userService.total();
        page.setTotal(total);
        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }
}
