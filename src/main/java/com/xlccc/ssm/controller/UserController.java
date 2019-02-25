package com.xlccc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlccc.ssm.pojo.User;
import com.xlccc.ssm.service.UserService;
import com.xlccc.ssm.util.ImageUtil;
import com.xlccc.ssm.util.Page;
import com.xlccc.ssm.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> us = userService.list();
        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);
        model.addAttribute("us", us);
        model.addAttribute("page", page);
        return "admin/listUser";

//        List<User> us = userService.list(page);
//        int total = userService.total();
//        page.setTotal(total);
//        model.addAttribute("us", us);
//        model.addAttribute("page", page);
//
//        return "admin/listUser";
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

    @RequestMapping("admin_user_delete")
    public String delete(int id, HttpSession session) {
        userService.delete(id);
        File imageFolder = new File(session.getServletContext().getRealPath("img/user"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return "redirect:/admin_user_list";
    }

    @RequestMapping("admin_user_edit")
    public String edit(int id, Model model) {
        User u = userService.get(id);
        model.addAttribute("u", u);
        return "admin/editUser";
    }

    @RequestMapping("admin_user_update")
    public String update(User u, HttpSession session, UploadedImageFile uploadedImageFile) {

        userService.update(u);
        MultipartFile image = uploadedImageFile.getImage();
        if (null != image && !image.isEmpty()) {
            File imageFolder = new File(session.getServletContext().getRealPath("img/user"));
            File file = new File(imageFolder, u.getId() + ".jpg");
            try {
                image.transferTo(file);
            } catch (IOException e) {
                System.out.print("文件转换错误");
                e.printStackTrace();
            }
            BufferedImage img = ImageUtil.change2jpg(file);
            try {
                ImageIO.write(img, "jpg", file);
            } catch (IOException e) {
                System.out.print("文件上传错误");
                e.printStackTrace();

            }
        }

        return "redirect:/admin_user_list";
    }
}
