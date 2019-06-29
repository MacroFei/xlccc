package com.xlccc.ssm.pojo;

public class AndroidPic {
    private Integer id;

    private Integer android_id;

    private String name;

    private String type;

    private String remark;

    private String url ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAndroid_id() {
        return android_id;
    }

    public void setAndroid_id(Integer android_id) {
        this.android_id = android_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "AndroidPic{" +
                "id=" + id +
                ", android_id=" + android_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}