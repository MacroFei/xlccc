package com.xlccc.ssm.controller;

import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.ImageUtil;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    @RequestMapping("admin_user_add")
    public String add(User u, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {

        userService.add(u);
        File imageFolder = new File(session.getServletContext().getRealPath("img/user"));
        File file = new File(imageFolder, u.getId() + ".jpg");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
        return "redirect:/admin_user_list";
    }
}
