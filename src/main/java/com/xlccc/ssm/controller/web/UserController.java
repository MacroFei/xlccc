package com.xlccc.ssm.controller.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.common.Result;
import com.xlccc.ssm.common.ResultGenerator;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.MD5Util;
import com.xlccc.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("user_list")
    public String list(Model model, Page page, HttpSession session) {

        PageHelper.offsetPage(page.getStart(), page.getCount());
        int totalNumber = 0;
        List<User> us = userService.list();
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        totalNumber = userService.selectTotalNumber();
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("us", us);
        model.addAttribute("page", page);
        return "user_management";
    }


    @RequestMapping("user_add")
    public String add(User user) {
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

    @RequestMapping(value = "update_password", method = RequestMethod.POST)
    @ResponseBody
    public Result update_password(User user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        userService.update(user);
        return ResultGenerator.genSuccessResult();
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

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user, HttpSession session) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        if (resultUser == null) {
            return ResultGenerator.genFailResult("账号或密码错误");
        } else {
            session.setAttribute("category", resultUser.getCategory());
            session.setAttribute("sessionId", resultUser.getId());
            return ResultGenerator.genSuccessResult(resultUser);
        }
    }


    /**
     * 用户校验是否登录，拦截
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(HttpSession session) {
        if (session.getAttribute("sessionId") == null) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("存在");
        }
    }

    /**
     * 用户退出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(HttpSession session) {
        session.removeAttribute("category");
        session.removeAttribute("sessionId");
        session.invalidate();
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(User user) {
        user.setRole(1);
        boolean flag = userService.select(user);
        if (flag == true) {
            return ResultGenerator.genFailResult("FAIL");
        } else {
            int resultTotal = 0;
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
            resultTotal = userService.addUser(user);
            if (resultTotal > 0) {
                return ResultGenerator.genSuccessResult();
            } else {
                return ResultGenerator.genFailResult("FAIL");
            }
        }
    }

    /**
     * 根据姓名模糊查找用户信息
     *
     * @param model
     * @param values
     * @param session
     * @param page
     * @return
     */
    @RequestMapping("selectUserName")
    public String selectUserName(Model model, String values, HttpSession session, Page page) {

        String name = values;
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> us = userService.selectName(name);
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        int totalNumber = userService.selectTotalNumber();
        model.addAttribute("totalNumber", totalNumber);
        model.addAttribute("us", us);
        model.addAttribute("page", page);
        return "user_management";


    }
}
