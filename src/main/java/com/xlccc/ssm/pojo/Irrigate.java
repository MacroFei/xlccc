package com.xlccc.ssm.pojo;

import java.util.Date;

public class Irrigate {
    private Integer id;

    private String serial_number;

    private String greenhouse;

    private String working_condition;

    private String province;

    private String city;

    private String district;

    private String category;

    private String tag;

    private Date date;

    private String irrigated_time;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number == null ? null : serial_number.trim();
    }

    public String getGreenhouse() {
        return greenhouse;
    }

    public void setGreenhouse(String greenhouse) {
        this.greenhouse = greenhouse == null ? null : greenhouse.trim();
    }

    public String getWorking_condition() {
        return working_condition;
    }

    public void setWorking_condition(String working_condition) {
        this.working_condition = working_condition == null ? null : working_condition.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIrrigated_time() {
        return irrigated_time;
    }

    public void setIrrigated_time(String irrigated_time) {
        this.irrigated_time = irrigated_time == null ? null : irrigated_time.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}