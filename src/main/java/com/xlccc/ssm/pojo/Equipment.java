package com.xlccc.ssm.pojo;

public class Equipment {
    private Integer id;

    private String serial_number;

    private String unit_type;

    private String device_class;

    private String working_condition;

    private String province;

    private String city;

    private String district;

    private String company;

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

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type == null ? null : unit_type.trim();
    }

    public String getDevice_class() {
        return device_class;
    }

    public void setDevice_class(String device_class) {
        this.device_class = device_class == null ? null : device_class.trim();
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}