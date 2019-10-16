package com.xlccc.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IrrigateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IrrigateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSerial_numberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerial_numberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerial_numberEqualTo(String value) {
            addCriterion("serial_number =", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberLessThan(String value) {
            addCriterion("serial_number <", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberLike(String value) {
            addCriterion("serial_number like", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberNotLike(String value) {
            addCriterion("serial_number not like", value, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberIn(List<String> values) {
            addCriterion("serial_number in", values, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serial_number");
            return (Criteria) this;
        }

        public Criteria andSerial_numberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serial_number");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIsNull() {
            addCriterion("greenhouse is null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIsNotNull() {
            addCriterion("greenhouse is not null");
            return (Criteria) this;
        }

        public Criteria andGreenhouseEqualTo(String value) {
            addCriterion("greenhouse =", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNotEqualTo(String value) {
            addCriterion("greenhouse <>", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseGreaterThan(String value) {
            addCriterion("greenhouse >", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseGreaterThanOrEqualTo(String value) {
            addCriterion("greenhouse >=", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseLessThan(String value) {
            addCriterion("greenhouse <", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseLessThanOrEqualTo(String value) {
            addCriterion("greenhouse <=", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseLike(String value) {
            addCriterion("greenhouse like", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNotLike(String value) {
            addCriterion("greenhouse not like", value, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseIn(List<String> values) {
            addCriterion("greenhouse in", values, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNotIn(List<String> values) {
            addCriterion("greenhouse not in", values, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseBetween(String value1, String value2) {
            addCriterion("greenhouse between", value1, value2, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andGreenhouseNotBetween(String value1, String value2) {
            addCriterion("greenhouse not between", value1, value2, "greenhouse");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionIsNull() {
            addCriterion("working_condition is null");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionIsNotNull() {
            addCriterion("working_condition is not null");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionEqualTo(String value) {
            addCriterion("working_condition =", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionNotEqualTo(String value) {
            addCriterion("working_condition <>", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionGreaterThan(String value) {
            addCriterion("working_condition >", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionGreaterThanOrEqualTo(String value) {
            addCriterion("working_condition >=", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionLessThan(String value) {
            addCriterion("working_condition <", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionLessThanOrEqualTo(String value) {
            addCriterion("working_condition <=", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionLike(String value) {
            addCriterion("working_condition like", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionNotLike(String value) {
            addCriterion("working_condition not like", value, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionIn(List<String> values) {
            addCriterion("working_condition in", values, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionNotIn(List<String> values) {
            addCriterion("working_condition not in", values, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionBetween(String value1, String value2) {
            addCriterion("working_condition between", value1, value2, "working_condition");
            return (Criteria) this;
        }

        public Criteria andWorking_conditionNotBetween(String value1, String value2) {
            addCriterion("working_condition not between", value1, value2, "working_condition");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeIsNull() {
            addCriterion("irrigated_time is null");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeIsNotNull() {
            addCriterion("irrigated_time is not null");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeEqualTo(String value) {
            addCriterion("irrigated_time =", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeNotEqualTo(String value) {
            addCriterion("irrigated_time <>", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeGreaterThan(String value) {
            addCriterion("irrigated_time >", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeGreaterThanOrEqualTo(String value) {
            addCriterion("irrigated_time >=", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeLessThan(String value) {
            addCriterion("irrigated_time <", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeLessThanOrEqualTo(String value) {
            addCriterion("irrigated_time <=", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeLike(String value) {
            addCriterion("irrigated_time like", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeNotLike(String value) {
            addCriterion("irrigated_time not like", value, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeIn(List<String> values) {
            addCriterion("irrigated_time in", values, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeNotIn(List<String> values) {
            addCriterion("irrigated_time not in", values, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeBetween(String value1, String value2) {
            addCriterion("irrigated_time between", value1, value2, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andIrrigated_timeNotBetween(String value1, String value2) {
            addCriterion("irrigated_time not between", value1, value2, "irrigated_time");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}