package com.oa.fourth.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OaBranchAihExample {
    /**
     * oa_branch_aih
     */
    protected String orderByClause;

    /**
     * oa_branch_aih
     */
    protected boolean distinct;

    /**
     * oa_branch_aih
     */
    protected List<Criteria> oredCriteria;

    /**
     * oa_branch_aih
     */
    protected int limitStart = -1;

    /**
     * oa_branch_aih
     */
    protected int limitEnd = -1;

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public OaBranchAihExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     *
     * @mbg.generated 2017-08-15
     */
    public int getLimitEnd() {
        return limitEnd;
    }

    /**
     * oa_branch_aih 2017-08-15
     */
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

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBcodeznIsNull() {
            addCriterion("bcodeZN is null");
            return (Criteria) this;
        }

        public Criteria andBcodeznIsNotNull() {
            addCriterion("bcodeZN is not null");
            return (Criteria) this;
        }

        public Criteria andBcodeznEqualTo(String value) {
            addCriterion("bcodeZN =", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznNotEqualTo(String value) {
            addCriterion("bcodeZN <>", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznGreaterThan(String value) {
            addCriterion("bcodeZN >", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznGreaterThanOrEqualTo(String value) {
            addCriterion("bcodeZN >=", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznLessThan(String value) {
            addCriterion("bcodeZN <", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznLessThanOrEqualTo(String value) {
            addCriterion("bcodeZN <=", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznLike(String value) {
            addCriterion("bcodeZN like", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznNotLike(String value) {
            addCriterion("bcodeZN not like", value, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznIn(List<String> values) {
            addCriterion("bcodeZN in", values, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznNotIn(List<String> values) {
            addCriterion("bcodeZN not in", values, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznBetween(String value1, String value2) {
            addCriterion("bcodeZN between", value1, value2, "bcodezn");
            return (Criteria) this;
        }

        public Criteria andBcodeznNotBetween(String value1, String value2) {
            addCriterion("bcodeZN not between", value1, value2, "bcodezn");
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

        public Criteria andBclassifyIsNull() {
            addCriterion("bclassify is null");
            return (Criteria) this;
        }

        public Criteria andBclassifyIsNotNull() {
            addCriterion("bclassify is not null");
            return (Criteria) this;
        }

        public Criteria andBclassifyEqualTo(String value) {
            addCriterion("bclassify =", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyNotEqualTo(String value) {
            addCriterion("bclassify <>", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyGreaterThan(String value) {
            addCriterion("bclassify >", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyGreaterThanOrEqualTo(String value) {
            addCriterion("bclassify >=", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyLessThan(String value) {
            addCriterion("bclassify <", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyLessThanOrEqualTo(String value) {
            addCriterion("bclassify <=", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyLike(String value) {
            addCriterion("bclassify like", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyNotLike(String value) {
            addCriterion("bclassify not like", value, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyIn(List<String> values) {
            addCriterion("bclassify in", values, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyNotIn(List<String> values) {
            addCriterion("bclassify not in", values, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyBetween(String value1, String value2) {
            addCriterion("bclassify between", value1, value2, "bclassify");
            return (Criteria) this;
        }

        public Criteria andBclassifyNotBetween(String value1, String value2) {
            addCriterion("bclassify not between", value1, value2, "bclassify");
            return (Criteria) this;
        }

        public Criteria andPjIdIsNull() {
            addCriterion("pj_id is null");
            return (Criteria) this;
        }

        public Criteria andPjIdIsNotNull() {
            addCriterion("pj_id is not null");
            return (Criteria) this;
        }

        public Criteria andPjIdEqualTo(Integer value) {
            addCriterion("pj_id =", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdNotEqualTo(Integer value) {
            addCriterion("pj_id <>", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdGreaterThan(Integer value) {
            addCriterion("pj_id >", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pj_id >=", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdLessThan(Integer value) {
            addCriterion("pj_id <", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdLessThanOrEqualTo(Integer value) {
            addCriterion("pj_id <=", value, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdIn(List<Integer> values) {
            addCriterion("pj_id in", values, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdNotIn(List<Integer> values) {
            addCriterion("pj_id not in", values, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdBetween(Integer value1, Integer value2) {
            addCriterion("pj_id between", value1, value2, "pjId");
            return (Criteria) this;
        }

        public Criteria andPjIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pj_id not between", value1, value2, "pjId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRentAreaIsNull() {
            addCriterion("rent_area is null");
            return (Criteria) this;
        }

        public Criteria andRentAreaIsNotNull() {
            addCriterion("rent_area is not null");
            return (Criteria) this;
        }

        public Criteria andRentAreaEqualTo(Float value) {
            addCriterion("rent_area =", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotEqualTo(Float value) {
            addCriterion("rent_area <>", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaGreaterThan(Float value) {
            addCriterion("rent_area >", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("rent_area >=", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaLessThan(Float value) {
            addCriterion("rent_area <", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaLessThanOrEqualTo(Float value) {
            addCriterion("rent_area <=", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaIn(List<Float> values) {
            addCriterion("rent_area in", values, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotIn(List<Float> values) {
            addCriterion("rent_area not in", values, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaBetween(Float value1, Float value2) {
            addCriterion("rent_area between", value1, value2, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotBetween(Float value1, Float value2) {
            addCriterion("rent_area not between", value1, value2, "rentArea");
            return (Criteria) this;
        }

        public Criteria andProjectStatIsNull() {
            addCriterion("project_stat is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatIsNotNull() {
            addCriterion("project_stat is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatEqualTo(String value) {
            addCriterion("project_stat =", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatNotEqualTo(String value) {
            addCriterion("project_stat <>", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatGreaterThan(String value) {
            addCriterion("project_stat >", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatGreaterThanOrEqualTo(String value) {
            addCriterion("project_stat >=", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatLessThan(String value) {
            addCriterion("project_stat <", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatLessThanOrEqualTo(String value) {
            addCriterion("project_stat <=", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatLike(String value) {
            addCriterion("project_stat like", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatNotLike(String value) {
            addCriterion("project_stat not like", value, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatIn(List<String> values) {
            addCriterion("project_stat in", values, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatNotIn(List<String> values) {
            addCriterion("project_stat not in", values, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatBetween(String value1, String value2) {
            addCriterion("project_stat between", value1, value2, "projectStat");
            return (Criteria) this;
        }

        public Criteria andProjectStatNotBetween(String value1, String value2) {
            addCriterion("project_stat not between", value1, value2, "projectStat");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNull() {
            addCriterion("branch_name is null");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNotNull() {
            addCriterion("branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andBranchNameEqualTo(String value) {
            addCriterion("branch_name =", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotEqualTo(String value) {
            addCriterion("branch_name <>", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThan(String value) {
            addCriterion("branch_name >", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("branch_name >=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThan(String value) {
            addCriterion("branch_name <", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThanOrEqualTo(String value) {
            addCriterion("branch_name <=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLike(String value) {
            addCriterion("branch_name like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotLike(String value) {
            addCriterion("branch_name not like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameIn(List<String> values) {
            addCriterion("branch_name in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotIn(List<String> values) {
            addCriterion("branch_name not in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameBetween(String value1, String value2) {
            addCriterion("branch_name between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotBetween(String value1, String value2) {
            addCriterion("branch_name not between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaIsNull() {
            addCriterion("subordinate_area is null");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaIsNotNull() {
            addCriterion("subordinate_area is not null");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaEqualTo(String value) {
            addCriterion("subordinate_area =", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaNotEqualTo(String value) {
            addCriterion("subordinate_area <>", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaGreaterThan(String value) {
            addCriterion("subordinate_area >", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaGreaterThanOrEqualTo(String value) {
            addCriterion("subordinate_area >=", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaLessThan(String value) {
            addCriterion("subordinate_area <", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaLessThanOrEqualTo(String value) {
            addCriterion("subordinate_area <=", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaLike(String value) {
            addCriterion("subordinate_area like", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaNotLike(String value) {
            addCriterion("subordinate_area not like", value, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaIn(List<String> values) {
            addCriterion("subordinate_area in", values, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaNotIn(List<String> values) {
            addCriterion("subordinate_area not in", values, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaBetween(String value1, String value2) {
            addCriterion("subordinate_area between", value1, value2, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andSubordinateAreaNotBetween(String value1, String value2) {
            addCriterion("subordinate_area not between", value1, value2, "subordinateArea");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryIsNull() {
            addCriterion("license_category is null");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryIsNotNull() {
            addCriterion("license_category is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryEqualTo(String value) {
            addCriterion("license_category =", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryNotEqualTo(String value) {
            addCriterion("license_category <>", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryGreaterThan(String value) {
            addCriterion("license_category >", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("license_category >=", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryLessThan(String value) {
            addCriterion("license_category <", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryLessThanOrEqualTo(String value) {
            addCriterion("license_category <=", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryLike(String value) {
            addCriterion("license_category like", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryNotLike(String value) {
            addCriterion("license_category not like", value, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryIn(List<String> values) {
            addCriterion("license_category in", values, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryNotIn(List<String> values) {
            addCriterion("license_category not in", values, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryBetween(String value1, String value2) {
            addCriterion("license_category between", value1, value2, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andLicenseCategoryNotBetween(String value1, String value2) {
            addCriterion("license_category not between", value1, value2, "licenseCategory");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelIsNull() {
            addCriterion("principal_tel is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelIsNotNull() {
            addCriterion("principal_tel is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelEqualTo(String value) {
            addCriterion("principal_tel =", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelNotEqualTo(String value) {
            addCriterion("principal_tel <>", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelGreaterThan(String value) {
            addCriterion("principal_tel >", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelGreaterThanOrEqualTo(String value) {
            addCriterion("principal_tel >=", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelLessThan(String value) {
            addCriterion("principal_tel <", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelLessThanOrEqualTo(String value) {
            addCriterion("principal_tel <=", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelLike(String value) {
            addCriterion("principal_tel like", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelNotLike(String value) {
            addCriterion("principal_tel not like", value, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelIn(List<String> values) {
            addCriterion("principal_tel in", values, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelNotIn(List<String> values) {
            addCriterion("principal_tel not in", values, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelBetween(String value1, String value2) {
            addCriterion("principal_tel between", value1, value2, "principalTel");
            return (Criteria) this;
        }

        public Criteria andPrincipalTelNotBetween(String value1, String value2) {
            addCriterion("principal_tel not between", value1, value2, "principalTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleIsNull() {
            addCriterion("admin_people is null");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleIsNotNull() {
            addCriterion("admin_people is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleEqualTo(String value) {
            addCriterion("admin_people =", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleNotEqualTo(String value) {
            addCriterion("admin_people <>", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleGreaterThan(String value) {
            addCriterion("admin_people >", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("admin_people >=", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleLessThan(String value) {
            addCriterion("admin_people <", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleLessThanOrEqualTo(String value) {
            addCriterion("admin_people <=", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleLike(String value) {
            addCriterion("admin_people like", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleNotLike(String value) {
            addCriterion("admin_people not like", value, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleIn(List<String> values) {
            addCriterion("admin_people in", values, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleNotIn(List<String> values) {
            addCriterion("admin_people not in", values, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleBetween(String value1, String value2) {
            addCriterion("admin_people between", value1, value2, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleNotBetween(String value1, String value2) {
            addCriterion("admin_people not between", value1, value2, "adminPeople");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelIsNull() {
            addCriterion("admin_people_tel is null");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelIsNotNull() {
            addCriterion("admin_people_tel is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelEqualTo(String value) {
            addCriterion("admin_people_tel =", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelNotEqualTo(String value) {
            addCriterion("admin_people_tel <>", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelGreaterThan(String value) {
            addCriterion("admin_people_tel >", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelGreaterThanOrEqualTo(String value) {
            addCriterion("admin_people_tel >=", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelLessThan(String value) {
            addCriterion("admin_people_tel <", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelLessThanOrEqualTo(String value) {
            addCriterion("admin_people_tel <=", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelLike(String value) {
            addCriterion("admin_people_tel like", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelNotLike(String value) {
            addCriterion("admin_people_tel not like", value, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelIn(List<String> values) {
            addCriterion("admin_people_tel in", values, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelNotIn(List<String> values) {
            addCriterion("admin_people_tel not in", values, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelBetween(String value1, String value2) {
            addCriterion("admin_people_tel between", value1, value2, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAdminPeopleTelNotBetween(String value1, String value2) {
            addCriterion("admin_people_tel not between", value1, value2, "adminPeopleTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIsNull() {
            addCriterion("area_admin is null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIsNotNull() {
            addCriterion("area_admin is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminEqualTo(String value) {
            addCriterion("area_admin =", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotEqualTo(String value) {
            addCriterion("area_admin <>", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminGreaterThan(String value) {
            addCriterion("area_admin >", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminGreaterThanOrEqualTo(String value) {
            addCriterion("area_admin >=", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminLessThan(String value) {
            addCriterion("area_admin <", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminLessThanOrEqualTo(String value) {
            addCriterion("area_admin <=", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminLike(String value) {
            addCriterion("area_admin like", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotLike(String value) {
            addCriterion("area_admin not like", value, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminIn(List<String> values) {
            addCriterion("area_admin in", values, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotIn(List<String> values) {
            addCriterion("area_admin not in", values, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminBetween(String value1, String value2) {
            addCriterion("area_admin between", value1, value2, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminNotBetween(String value1, String value2) {
            addCriterion("area_admin not between", value1, value2, "areaAdmin");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelIsNull() {
            addCriterion("area_admin_tel is null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelIsNotNull() {
            addCriterion("area_admin_tel is not null");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelEqualTo(String value) {
            addCriterion("area_admin_tel =", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelNotEqualTo(String value) {
            addCriterion("area_admin_tel <>", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelGreaterThan(String value) {
            addCriterion("area_admin_tel >", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelGreaterThanOrEqualTo(String value) {
            addCriterion("area_admin_tel >=", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelLessThan(String value) {
            addCriterion("area_admin_tel <", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelLessThanOrEqualTo(String value) {
            addCriterion("area_admin_tel <=", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelLike(String value) {
            addCriterion("area_admin_tel like", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelNotLike(String value) {
            addCriterion("area_admin_tel not like", value, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelIn(List<String> values) {
            addCriterion("area_admin_tel in", values, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelNotIn(List<String> values) {
            addCriterion("area_admin_tel not in", values, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelBetween(String value1, String value2) {
            addCriterion("area_admin_tel between", value1, value2, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andAreaAdminTelNotBetween(String value1, String value2) {
            addCriterion("area_admin_tel not between", value1, value2, "areaAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminIsNull() {
            addCriterion("head_admin is null");
            return (Criteria) this;
        }

        public Criteria andHeadAdminIsNotNull() {
            addCriterion("head_admin is not null");
            return (Criteria) this;
        }

        public Criteria andHeadAdminEqualTo(String value) {
            addCriterion("head_admin =", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminNotEqualTo(String value) {
            addCriterion("head_admin <>", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminGreaterThan(String value) {
            addCriterion("head_admin >", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminGreaterThanOrEqualTo(String value) {
            addCriterion("head_admin >=", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminLessThan(String value) {
            addCriterion("head_admin <", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminLessThanOrEqualTo(String value) {
            addCriterion("head_admin <=", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminLike(String value) {
            addCriterion("head_admin like", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminNotLike(String value) {
            addCriterion("head_admin not like", value, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminIn(List<String> values) {
            addCriterion("head_admin in", values, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminNotIn(List<String> values) {
            addCriterion("head_admin not in", values, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminBetween(String value1, String value2) {
            addCriterion("head_admin between", value1, value2, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminNotBetween(String value1, String value2) {
            addCriterion("head_admin not between", value1, value2, "headAdmin");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelIsNull() {
            addCriterion("head_admin_tel is null");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelIsNotNull() {
            addCriterion("head_admin_tel is not null");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelEqualTo(String value) {
            addCriterion("head_admin_tel =", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelNotEqualTo(String value) {
            addCriterion("head_admin_tel <>", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelGreaterThan(String value) {
            addCriterion("head_admin_tel >", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelGreaterThanOrEqualTo(String value) {
            addCriterion("head_admin_tel >=", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelLessThan(String value) {
            addCriterion("head_admin_tel <", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelLessThanOrEqualTo(String value) {
            addCriterion("head_admin_tel <=", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelLike(String value) {
            addCriterion("head_admin_tel like", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelNotLike(String value) {
            addCriterion("head_admin_tel not like", value, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelIn(List<String> values) {
            addCriterion("head_admin_tel in", values, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelNotIn(List<String> values) {
            addCriterion("head_admin_tel not in", values, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelBetween(String value1, String value2) {
            addCriterion("head_admin_tel between", value1, value2, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andHeadAdminTelNotBetween(String value1, String value2) {
            addCriterion("head_admin_tel not between", value1, value2, "headAdminTel");
            return (Criteria) this;
        }

        public Criteria andOfficeStateIsNull() {
            addCriterion("office_state is null");
            return (Criteria) this;
        }

        public Criteria andOfficeStateIsNotNull() {
            addCriterion("office_state is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeStateEqualTo(String value) {
            addCriterion("office_state =", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateNotEqualTo(String value) {
            addCriterion("office_state <>", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateGreaterThan(String value) {
            addCriterion("office_state >", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateGreaterThanOrEqualTo(String value) {
            addCriterion("office_state >=", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateLessThan(String value) {
            addCriterion("office_state <", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateLessThanOrEqualTo(String value) {
            addCriterion("office_state <=", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateLike(String value) {
            addCriterion("office_state like", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateNotLike(String value) {
            addCriterion("office_state not like", value, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateIn(List<String> values) {
            addCriterion("office_state in", values, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateNotIn(List<String> values) {
            addCriterion("office_state not in", values, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateBetween(String value1, String value2) {
            addCriterion("office_state between", value1, value2, "officeState");
            return (Criteria) this;
        }

        public Criteria andOfficeStateNotBetween(String value1, String value2) {
            addCriterion("office_state not between", value1, value2, "officeState");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneIsNull() {
            addCriterion("threelicense_one is null");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneIsNotNull() {
            addCriterion("threelicense_one is not null");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneEqualTo(String value) {
            addCriterion("threelicense_one =", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneNotEqualTo(String value) {
            addCriterion("threelicense_one <>", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneGreaterThan(String value) {
            addCriterion("threelicense_one >", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneGreaterThanOrEqualTo(String value) {
            addCriterion("threelicense_one >=", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneLessThan(String value) {
            addCriterion("threelicense_one <", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneLessThanOrEqualTo(String value) {
            addCriterion("threelicense_one <=", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneLike(String value) {
            addCriterion("threelicense_one like", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneNotLike(String value) {
            addCriterion("threelicense_one not like", value, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneIn(List<String> values) {
            addCriterion("threelicense_one in", values, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneNotIn(List<String> values) {
            addCriterion("threelicense_one not in", values, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneBetween(String value1, String value2) {
            addCriterion("threelicense_one between", value1, value2, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andThreelicenseOneNotBetween(String value1, String value2) {
            addCriterion("threelicense_one not between", value1, value2, "threelicenseOne");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNull() {
            addCriterion("license is null");
            return (Criteria) this;
        }

        public Criteria andLicenseIsNotNull() {
            addCriterion("license is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseEqualTo(String value) {
            addCriterion("license =", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotEqualTo(String value) {
            addCriterion("license <>", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThan(String value) {
            addCriterion("license >", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("license >=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThan(String value) {
            addCriterion("license <", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLessThanOrEqualTo(String value) {
            addCriterion("license <=", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseLike(String value) {
            addCriterion("license like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotLike(String value) {
            addCriterion("license not like", value, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseIn(List<String> values) {
            addCriterion("license in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotIn(List<String> values) {
            addCriterion("license not in", values, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseBetween(String value1, String value2) {
            addCriterion("license between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andLicenseNotBetween(String value1, String value2) {
            addCriterion("license not between", value1, value2, "license");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationIsNull() {
            addCriterion("tax_registration is null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationIsNotNull() {
            addCriterion("tax_registration is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationEqualTo(String value) {
            addCriterion("tax_registration =", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNotEqualTo(String value) {
            addCriterion("tax_registration <>", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationGreaterThan(String value) {
            addCriterion("tax_registration >", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationGreaterThanOrEqualTo(String value) {
            addCriterion("tax_registration >=", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationLessThan(String value) {
            addCriterion("tax_registration <", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationLessThanOrEqualTo(String value) {
            addCriterion("tax_registration <=", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationLike(String value) {
            addCriterion("tax_registration like", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNotLike(String value) {
            addCriterion("tax_registration not like", value, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationIn(List<String> values) {
            addCriterion("tax_registration in", values, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNotIn(List<String> values) {
            addCriterion("tax_registration not in", values, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationBetween(String value1, String value2) {
            addCriterion("tax_registration between", value1, value2, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andTaxRegistrationNotBetween(String value1, String value2) {
            addCriterion("tax_registration not between", value1, value2, "taxRegistration");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNull() {
            addCriterion("organization_code is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIsNotNull() {
            addCriterion("organization_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeEqualTo(String value) {
            addCriterion("organization_code =", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotEqualTo(String value) {
            addCriterion("organization_code <>", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThan(String value) {
            addCriterion("organization_code >", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("organization_code >=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThan(String value) {
            addCriterion("organization_code <", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLessThanOrEqualTo(String value) {
            addCriterion("organization_code <=", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeLike(String value) {
            addCriterion("organization_code like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotLike(String value) {
            addCriterion("organization_code not like", value, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeIn(List<String> values) {
            addCriterion("organization_code in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotIn(List<String> values) {
            addCriterion("organization_code not in", values, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeBetween(String value1, String value2) {
            addCriterion("organization_code between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andOrganizationCodeNotBetween(String value1, String value2) {
            addCriterion("organization_code not between", value1, value2, "organizationCode");
            return (Criteria) this;
        }

        public Criteria andStaCertificateIsNull() {
            addCriterion("sta_certificate is null");
            return (Criteria) this;
        }

        public Criteria andStaCertificateIsNotNull() {
            addCriterion("sta_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andStaCertificateEqualTo(String value) {
            addCriterion("sta_certificate =", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateNotEqualTo(String value) {
            addCriterion("sta_certificate <>", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateGreaterThan(String value) {
            addCriterion("sta_certificate >", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("sta_certificate >=", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateLessThan(String value) {
            addCriterion("sta_certificate <", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateLessThanOrEqualTo(String value) {
            addCriterion("sta_certificate <=", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateLike(String value) {
            addCriterion("sta_certificate like", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateNotLike(String value) {
            addCriterion("sta_certificate not like", value, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateIn(List<String> values) {
            addCriterion("sta_certificate in", values, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateNotIn(List<String> values) {
            addCriterion("sta_certificate not in", values, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateBetween(String value1, String value2) {
            addCriterion("sta_certificate between", value1, value2, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andStaCertificateNotBetween(String value1, String value2) {
            addCriterion("sta_certificate not between", value1, value2, "staCertificate");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseIsNull() {
            addCriterion("account_open_license is null");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseIsNotNull() {
            addCriterion("account_open_license is not null");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseEqualTo(String value) {
            addCriterion("account_open_license =", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseNotEqualTo(String value) {
            addCriterion("account_open_license <>", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseGreaterThan(String value) {
            addCriterion("account_open_license >", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("account_open_license >=", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseLessThan(String value) {
            addCriterion("account_open_license <", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseLessThanOrEqualTo(String value) {
            addCriterion("account_open_license <=", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseLike(String value) {
            addCriterion("account_open_license like", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseNotLike(String value) {
            addCriterion("account_open_license not like", value, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseIn(List<String> values) {
            addCriterion("account_open_license in", values, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseNotIn(List<String> values) {
            addCriterion("account_open_license not in", values, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseBetween(String value1, String value2) {
            addCriterion("account_open_license between", value1, value2, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andAccountOpenLicenseNotBetween(String value1, String value2) {
            addCriterion("account_open_license not between", value1, value2, "accountOpenLicense");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeIsNull() {
            addCriterion("institution_credit_code is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeIsNotNull() {
            addCriterion("institution_credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeEqualTo(String value) {
            addCriterion("institution_credit_code =", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeNotEqualTo(String value) {
            addCriterion("institution_credit_code <>", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeGreaterThan(String value) {
            addCriterion("institution_credit_code >", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("institution_credit_code >=", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeLessThan(String value) {
            addCriterion("institution_credit_code <", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("institution_credit_code <=", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeLike(String value) {
            addCriterion("institution_credit_code like", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeNotLike(String value) {
            addCriterion("institution_credit_code not like", value, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeIn(List<String> values) {
            addCriterion("institution_credit_code in", values, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeNotIn(List<String> values) {
            addCriterion("institution_credit_code not in", values, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeBetween(String value1, String value2) {
            addCriterion("institution_credit_code between", value1, value2, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andInstitutionCreditCodeNotBetween(String value1, String value2) {
            addCriterion("institution_credit_code not between", value1, value2, "institutionCreditCode");
            return (Criteria) this;
        }

        public Criteria andSealStatusIsNull() {
            addCriterion("seal_status is null");
            return (Criteria) this;
        }

        public Criteria andSealStatusIsNotNull() {
            addCriterion("seal_status is not null");
            return (Criteria) this;
        }

        public Criteria andSealStatusEqualTo(String value) {
            addCriterion("seal_status =", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusNotEqualTo(String value) {
            addCriterion("seal_status <>", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusGreaterThan(String value) {
            addCriterion("seal_status >", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("seal_status >=", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusLessThan(String value) {
            addCriterion("seal_status <", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusLessThanOrEqualTo(String value) {
            addCriterion("seal_status <=", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusLike(String value) {
            addCriterion("seal_status like", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusNotLike(String value) {
            addCriterion("seal_status not like", value, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusIn(List<String> values) {
            addCriterion("seal_status in", values, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusNotIn(List<String> values) {
            addCriterion("seal_status not in", values, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusBetween(String value1, String value2) {
            addCriterion("seal_status between", value1, value2, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andSealStatusNotBetween(String value1, String value2) {
            addCriterion("seal_status not between", value1, value2, "sealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalHasIsNull() {
            addCriterion("personal_has is null");
            return (Criteria) this;
        }

        public Criteria andPersonalHasIsNotNull() {
            addCriterion("personal_has is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalHasEqualTo(String value) {
            addCriterion("personal_has =", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasNotEqualTo(String value) {
            addCriterion("personal_has <>", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasGreaterThan(String value) {
            addCriterion("personal_has >", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasGreaterThanOrEqualTo(String value) {
            addCriterion("personal_has >=", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasLessThan(String value) {
            addCriterion("personal_has <", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasLessThanOrEqualTo(String value) {
            addCriterion("personal_has <=", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasLike(String value) {
            addCriterion("personal_has like", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasNotLike(String value) {
            addCriterion("personal_has not like", value, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasIn(List<String> values) {
            addCriterion("personal_has in", values, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasNotIn(List<String> values) {
            addCriterion("personal_has not in", values, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasBetween(String value1, String value2) {
            addCriterion("personal_has between", value1, value2, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalHasNotBetween(String value1, String value2) {
            addCriterion("personal_has not between", value1, value2, "personalHas");
            return (Criteria) this;
        }

        public Criteria andPersonalSealIsNull() {
            addCriterion("personal_seal is null");
            return (Criteria) this;
        }

        public Criteria andPersonalSealIsNotNull() {
            addCriterion("personal_seal is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalSealEqualTo(String value) {
            addCriterion("personal_seal =", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealNotEqualTo(String value) {
            addCriterion("personal_seal <>", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealGreaterThan(String value) {
            addCriterion("personal_seal >", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealGreaterThanOrEqualTo(String value) {
            addCriterion("personal_seal >=", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealLessThan(String value) {
            addCriterion("personal_seal <", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealLessThanOrEqualTo(String value) {
            addCriterion("personal_seal <=", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealLike(String value) {
            addCriterion("personal_seal like", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealNotLike(String value) {
            addCriterion("personal_seal not like", value, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealIn(List<String> values) {
            addCriterion("personal_seal in", values, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealNotIn(List<String> values) {
            addCriterion("personal_seal not in", values, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealBetween(String value1, String value2) {
            addCriterion("personal_seal between", value1, value2, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealNotBetween(String value1, String value2) {
            addCriterion("personal_seal not between", value1, value2, "personalSeal");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusIsNull() {
            addCriterion("personal_seal_status is null");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusIsNotNull() {
            addCriterion("personal_seal_status is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusEqualTo(String value) {
            addCriterion("personal_seal_status =", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusNotEqualTo(String value) {
            addCriterion("personal_seal_status <>", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusGreaterThan(String value) {
            addCriterion("personal_seal_status >", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusGreaterThanOrEqualTo(String value) {
            addCriterion("personal_seal_status >=", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusLessThan(String value) {
            addCriterion("personal_seal_status <", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusLessThanOrEqualTo(String value) {
            addCriterion("personal_seal_status <=", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusLike(String value) {
            addCriterion("personal_seal_status like", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusNotLike(String value) {
            addCriterion("personal_seal_status not like", value, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusIn(List<String> values) {
            addCriterion("personal_seal_status in", values, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusNotIn(List<String> values) {
            addCriterion("personal_seal_status not in", values, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusBetween(String value1, String value2) {
            addCriterion("personal_seal_status between", value1, value2, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalSealStatusNotBetween(String value1, String value2) {
            addCriterion("personal_seal_status not between", value1, value2, "personalSealStatus");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterion("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterion("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterion("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterion("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterion("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterion("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterion("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("operation_time not between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    /**
     * oa_branch_aih
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * oa_branch_aih 2017-08-15
     */
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