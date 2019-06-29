package com.xlccc.ssm.controller;

import com.xlccc.ssm.pojo.Android;
import com.xlccc.ssm.pojo.AndroidPic;
import com.xlccc.ssm.service.AndroidPicService;
import com.xlccc.ssm.service.AndroidService;
import com.xlccc.ssm.util.ImageUtil;
import com.xlccc.ssm.util.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class AndroidPicController2 {
    @Autowired
    AndroidService androidService;
    @Autowired
    AndroidPicService androidPicService;
//    @RequestMapping("android_get_detail_pictures")
//    @ResponseBody
//    public Result getPictures(){
//        Android android = new Android();
//        android.setId(2);
//        Android androidDemo = androidService.get(android.getId());
//        List<LogoPic> logoPicList = new ArrayList<>();
//        List<AndroidPic> androidPicList = androidPicService.listByIdAndType(android.getId() , AndroidPicService.type_detail);
//        for (AndroidPic ap : androidPicList
//                ) {
//            String fileName = "http:localhost:8888/ssm/img/magspaceDetail/"+ap.getName()+"_"+ap.getId()+".jpg";
//            //ap.setUrl(fileName);
//            //ap.setTitle(androidDemo.getName());
//            LogoPic lp = new LogoPic();
//            lp.setId(ap.getId());
//            lp.setTitle(androidDemo.getName());
//            lp.setPic(fileName);
//
//            logoPicList.add(lp);
//        }
//        //  System.out.println(androidPicList.toString());
//
//        return Result.success(logoPicList);
//
//    }
    @RequestMapping("admin_androidPic_add_more")
    public String add(AndroidPic androidPic, HttpSession session, UploadedImageFile[] uploadedImageFiles) {
        for (UploadedImageFile image: uploadedImageFiles
             ) {
            androidPicService.add(androidPic);
            String name = image.getImage().getOriginalFilename();

            // name = name.substring(0, name.length() - 4);
            String fileName = name + "_" + androidPic.getId() + ".jpg";

            if (name.endsWith(".gif")) {

                name = name.substring(0, name.length() - 4);
                fileName = name + "_" + androidPic.getId() + ".gif";
            }
            if (name.endsWith(".png")) {

                name = name.substring(0, name.length() - 4);
                fileName = name + "_" + androidPic.getId() + ".png";
            }
            if (name.endsWith(".jpg")) {

                name = name.substring(0, name.length() - 4);
                fileName = name + "_" + androidPic.getId() + ".jpg";
            }
            else{
                name = name.substring(0, name.length() - 4);
                fileName = name + "_" + androidPic.getId() + ".jpg";
            }
            androidPic.setName(name);

            androidPicService.update(androidPic);


            // fileName = androidPic.getName() + "_" + androidPic.getId() + ".jpg";
            String imageFolder;
            String imageFolder_small = null;
            String imageFolder_middle = null;
            if (AndroidPicService.type_single.equals(androidPic.getType())) {
                imageFolder = session.getServletContext().getRealPath("img/magspaceSingle");
                imageFolder_small = session.getServletContext().getRealPath("img/magspaceSingle_small");
                imageFolder_middle = session.getServletContext().getRealPath("img/magspaceSingle_middle");
//            imageFolder_git = session.getServletContext().getRealPath("img/magspace_gif");
            } else if (AndroidPicService.type_gif.equals(androidPic.getType())) {
                imageFolder = session.getServletContext().getRealPath("img/magspaceGif");

            } else if (AndroidPicService.type_logo.equals(androidPic.getType())) {
                imageFolder = session.getServletContext().getRealPath("img/magspaceLogo");

            } else if (AndroidPicService.type_logosettion.equals(androidPic.getType())) {
                imageFolder = session.getServletContext().getRealPath("img/magspaceLogosetting");

            } else if (AndroidPicService.type_pic.equals(androidPic.getType())) {
                imageFolder = session.getServletContext().getRealPath("img/magspacePic");

            } else {
                imageFolder = session.getServletContext().getRealPath("img/magspaceDetail");
            }

            File f = new File(imageFolder, fileName);
            f.getParentFile().mkdirs();

            try { //修改图片大小  雨女无瓜
                image.getImage().transferTo(f);
                BufferedImage img = ImageUtil.change2jpg(f);

                ImageIO.write(img, "jpg", f);

                if (AndroidPicService.type_single.equals(androidPic.getType())) {
                    File f_small = new File(imageFolder_small, fileName);
                    File f_middle = new File(imageFolder_middle, fileName);

                    ImageUtil.resizeImage(f, 56, 56, f_small);
                    ImageUtil.resizeImage(f, 217, 190, f_middle);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        return "redirect:admin_androidPic_list_more?androidId=" + androidPic.getAndroid_id();
    }

    @RequestMapping("admin_androidPic_delete_more")
    public String delete(int id, HttpSession session) {
        AndroidPic ap = androidPicService.get(id);
        String fileName = ap.getId() + ".jpg";
        String imageFolder;
        String imageFloder_small = null;
        String imageFloder_middle = null;

        if (AndroidPicService.type_single.equals(ap.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/magspaceSingle");
            imageFloder_small = session.getServletContext().getRealPath("img/magspaceSingle_small");
            imageFloder_middle = session.getServletContext().getRealPath("img/magspaceSingle_middle");
            File imageFile = new File(imageFolder, fileName);
            File f_small = new File(imageFloder_small, fileName);
            File f_middle = new File(imageFloder_middle, fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();
        } else if (AndroidPicService.type_gif.equals(ap.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/magspace_gif");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();

        } else if (AndroidPicService.type_logo.equals(ap.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/magspace_logo");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();

        } else if (AndroidPicService.type_logosettion.equals(ap.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/magspace_logosettion");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();

        } else if (AndroidPicService.type_pic.equals(ap.getType())) {
            imageFolder = session.getServletContext().getRealPath("img/magspace_pic");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();

        } else {
            imageFolder = session.getServletContext().getRealPath("img/magspaceDetail");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();
        }

        androidPicService.delete(id);

        return "redirect:admin_androidPic_list_more?androidId=" + ap.getAndroid_id();

    }

    /**
     * list ok
     *
     * @param androidId
     * @param model
     * @return
     */
    @RequestMapping("admin_androidPic_list_more")
    public String list(int androidId, Model model, HttpServletRequest request) {

        Android android = androidService.get(androidId);
        System.out.println(android.toString());
        List<AndroidPic> pisSingle = androidPicService.list(androidId, AndroidPicService.type_single);
        List<AndroidPic> pisDetail = androidPicService.list(androidId, AndroidPicService.type_detail);

        List<AndroidPic> pisGif = androidPicService.list(androidId , AndroidPicService.type_gif);
        List<AndroidPic> pisLogo = androidPicService.list(androidId , AndroidPicService.type_logo);
        List<AndroidPic> pisLogosettion = androidPicService.list(androidId , AndroidPicService.type_logosettion);
        List<AndroidPic> pisPic = androidPicService.list(androidId , AndroidPicService.type_pic);

        String contextPath = request.getContextPath();
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();//本机IP
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

       // String filesDemo = Thread.currentThread().getContextClassLoader().getResource("/").getPath() + "upload/";
      //  model.addAttribute("filesDemo", filesDemo);
        model.addAttribute("addr", addr);
        model.addAttribute("android", android);
        model.addAttribute("pisSingle", pisSingle);
        model.addAttribute("pisDetail", pisDetail);
        model.addAttribute("pisGif",pisGif);
        model.addAttribute("pisLogo",pisLogo);
        model.addAttribute("pisLogosettion",pisLogosettion);
        model.addAttribute("pisPic",pisPic);

//        if(androidId == 3){
//            return "admin/listAndroidPicDj";
//        }else if(androidId == 2){
//            return "admin/listAndroidPicKz";
//        }else if (androidId == 4) {
//            return "admin/listAndroidPicSp";
//        }
//        return "admin/listAndroidPic";
        return "admin/listAndroidPicDemo";

    }
}
