package com.xlccc.ssm.service;


import com.xlccc.ssm.pojo.AndroidPic;

import java.util.List;

public interface AndroidPicService {
    String type_single = "type_single";
    String type_detail = "type_detail";


    String type_logo = "type_logo";
    String type_logosettion = "type_logosettion";
    String type_gif = "type_gif";
    String type_pic = "type_pic";

    void add(AndroidPic androidPic);

    void delete(int id);

    void update(AndroidPic androidPic);

    AndroidPic get(int id);

    List list(int androidId , String type);

    List<AndroidPic> listByIdAndType(int androidId , String type);
}
