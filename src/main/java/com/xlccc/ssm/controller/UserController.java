package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("user_list")
    public String list(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> us = userService.list();
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        int totalNumber = userService.selectTotalNumber();
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("us", us);
        model.addAttribute("page", page);
//        model.addAttribute("totalNumber",totalNumber);
        return "user_management";
    }

    @RequestMapping("user_add")
    public String add(User user, HttpSession session) {
        userService.add(user);
        return "redirect:/user_list";
    }


    @RequestMapping("user_delete")
    public String delete(int id, HttpSession session) {
        userService.delete(id);
        return "redirect:/user_list";
    }

    @RequestMapping("user_edit")
    public String edit(int id, Model model) {
        User u = userService.get(id);
        model.addAttribute("u", u);
        return "user_edit";// 这里需要修改编辑页面
    }

    @RequestMapping("user_update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/user_list";
    }

    @RequestMapping("user_deleteAll")
    public String deleteAll(String ids) {
        for (String idDemo : ids.split(",")
                ) {
            int id = Integer.parseInt(idDemo);
            userService.delete(id);

        }
        return "redirect:/user_list";
    }


    @RequestMapping("user_update_password")
    public String updatePassword(User user) {
        System.out.print("idasdasda:" + user.getPasswordId());

        User u = userService.get(user.getPasswordId());
        if (u.getPassword().equals(user.getPassword())) {
            u.setPassword(user.getNewPassword());
            userService.update(u);
        }

        return "redirect:/user_list";
    }

}
