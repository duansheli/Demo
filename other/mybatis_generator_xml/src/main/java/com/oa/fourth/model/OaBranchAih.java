package com.oa.fourth.model;

import java.util.Date;

public class OaBranchAih {
    /**
     * 网点名称
     */
    private String bname;

    /**
     * 中文代码
     */
    private String bcodezn;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 网点类型
     */
    private String bclassify;

    /**
     * 主键
     */
    private Integer pjId;

    /**
     * 地址详情
     */
    private String address;

    /**
     * 租赁面积
     */
    private Float rentArea;

    /**
     * 工程状态(1-开业、2-临时办公、3-试营业、4-装修、5-装修筹备、6-装修完成、7-已退租。)
     */
    private String projectStat;

    /**
     * 分公司名称
     */
    private String branchName;

    /**
     * 
     */
    private String subordinateArea;

    /**
     * 营业执照类别
     */
    private String licenseCategory;

    /**
     * 网点负责人
     */
    private String principal;

    /**
     * 负责人联系方式
     */
    private String principalTel;

    /**
     * 行政对接人
     */
    private String adminPeople;

    /**
     * 行政对接人联系方式
     */
    private String adminPeopleTel;

    /**
     * 地区总行政
     */
    private String areaAdmin;

    /**
     * 地区总行政联系方式
     */
    private String areaAdminTel;

    /**
     * 总部对接行政
     */
    private String headAdmin;

    /**
     * 总部对接行政联系方式
     */
    private String headAdminTel;

    /**
     * 办公状态
     */
    private String officeState;

    /**
     * 是否三证合一
     */
    private String threelicenseOne;

    /**
     * 营业执照
     */
    private String license;

    /**
     * 税务登记证
     */
    private String taxRegistration;

    /**
     * 组织机构代码证
     */
    private String organizationCode;

    /**
     * 统计证
     */
    private String staCertificate;

    /**
     * 开户许可证
     */
    private String accountOpenLicense;

    /**
     * 机构信用代码证
     */
    private String institutionCreditCode;

    /**
     * 公章是否寄回
     */
    private String sealStatus;

    /**
     * 是否有负责人章
     */
    private String personalHas;

    /**
     * 负责人章姓名
     */
    private String personalSeal;

    /**
     * 私章是否寄回
     */
    private String personalSealStatus;

    /**
     * 备注
     */
    private String comment;

    /**
     * 操作时间
     */
    private Date operationTime;

    /**
     * 数据状态（0：已删除、1：正常、2：历史记录）
     */
    private Integer isDelete;

    /**
     * 网点名称
     * @return bname 网点名称
     */
    public String getBname() {
        return bname;
    }

    /**
     * 网点名称
     * @param bname 网点名称
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * 中文代码
     * @return bcodeZN 中文代码
     */
    public String getBcodezn() {
        return bcodezn;
    }

    /**
     * 中文代码
     * @param bcodezn 中文代码
     */
    public void setBcodezn(String bcodezn) {
        this.bcodezn = bcodezn == null ? null : bcodezn.trim();
    }

    /**
     * 省份
     * @return province 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 城市
     * @return city 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 网点类型
     * @return bclassify 网点类型
     */
    public String getBclassify() {
        return bclassify;
    }

    /**
     * 网点类型
     * @param bclassify 网点类型
     */
    public void setBclassify(String bclassify) {
        this.bclassify = bclassify == null ? null : bclassify.trim();
    }

    /**
     * 主键
     * @return pj_id 主键
     */
    public Integer getPjId() {
        return pjId;
    }

    /**
     * 主键
     * @param pjId 主键
     */
    public void setPjId(Integer pjId) {
        this.pjId = pjId;
    }

    /**
     * 地址详情
     * @return address 地址详情
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址详情
     * @param address 地址详情
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 租赁面积
     * @return rent_area 租赁面积
     */
    public Float getRentArea() {
        return rentArea;
    }

    /**
     * 租赁面积
     * @param rentArea 租赁面积
     */
    public void setRentArea(Float rentArea) {
        this.rentArea = rentArea;
    }

    /**
     * 工程状态(1-开业、2-临时办公、3-试营业、4-装修、5-装修筹备、6-装修完成、7-已退租。)
     * @return project_stat 工程状态(1-开业、2-临时办公、3-试营业、4-装修、5-装修筹备、6-装修完成、7-已退租。)
     */
    public String getProjectStat() {
        return projectStat;
    }

    /**
     * 工程状态(1-开业、2-临时办公、3-试营业、4-装修、5-装修筹备、6-装修完成、7-已退租。)
     * @param projectStat 工程状态(1-开业、2-临时办公、3-试营业、4-装修、5-装修筹备、6-装修完成、7-已退租。)
     */
    public void setProjectStat(String projectStat) {
        this.projectStat = projectStat == null ? null : projectStat.trim();
    }

    /**
     * 分公司名称
     * @return branch_name 分公司名称
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 分公司名称
     * @param branchName 分公司名称
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    /**
     * 
     * @return subordinate_area 
     */
    public String getSubordinateArea() {
        return subordinateArea;
    }

    /**
     * 
     * @param subordinateArea 
     */
    public void setSubordinateArea(String subordinateArea) {
        this.subordinateArea = subordinateArea == null ? null : subordinateArea.trim();
    }

    /**
     * 营业执照类别
     * @return license_category 营业执照类别
     */
    public String getLicenseCategory() {
        return licenseCategory;
    }

    /**
     * 营业执照类别
     * @param licenseCategory 营业执照类别
     */
    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory == null ? null : licenseCategory.trim();
    }

    /**
     * 网点负责人
     * @return principal 网点负责人
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 网点负责人
     * @param principal 网点负责人
     */
    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    /**
     * 负责人联系方式
     * @return principal_tel 负责人联系方式
     */
    public String getPrincipalTel() {
        return principalTel;
    }

    /**
     * 负责人联系方式
     * @param principalTel 负责人联系方式
     */
    public void setPrincipalTel(String principalTel) {
        this.principalTel = principalTel == null ? null : principalTel.trim();
    }

    /**
     * 行政对接人
     * @return admin_people 行政对接人
     */
    public String getAdminPeople() {
        return adminPeople;
    }

    /**
     * 行政对接人
     * @param adminPeople 行政对接人
     */
    public void setAdminPeople(String adminPeople) {
        this.adminPeople = adminPeople == null ? null : adminPeople.trim();
    }

    /**
     * 行政对接人联系方式
     * @return admin_people_tel 行政对接人联系方式
     */
    public String getAdminPeopleTel() {
        return adminPeopleTel;
    }

    /**
     * 行政对接人联系方式
     * @param adminPeopleTel 行政对接人联系方式
     */
    public void setAdminPeopleTel(String adminPeopleTel) {
        this.adminPeopleTel = adminPeopleTel == null ? null : adminPeopleTel.trim();
    }

    /**
     * 地区总行政
     * @return area_admin 地区总行政
     */
    public String getAreaAdmin() {
        return areaAdmin;
    }

    /**
     * 地区总行政
     * @param areaAdmin 地区总行政
     */
    public void setAreaAdmin(String areaAdmin) {
        this.areaAdmin = areaAdmin == null ? null : areaAdmin.trim();
    }

    /**
     * 地区总行政联系方式
     * @return area_admin_tel 地区总行政联系方式
     */
    public String getAreaAdminTel() {
        return areaAdminTel;
    }

    /**
     * 地区总行政联系方式
     * @param areaAdminTel 地区总行政联系方式
     */
    public void setAreaAdminTel(String areaAdminTel) {
        this.areaAdminTel = areaAdminTel == null ? null : areaAdminTel.trim();
    }

    /**
     * 总部对接行政
     * @return head_admin 总部对接行政
     */
    public String getHeadAdmin() {
        return headAdmin;
    }

    /**
     * 总部对接行政
     * @param headAdmin 总部对接行政
     */
    public void setHeadAdmin(String headAdmin) {
        this.headAdmin = headAdmin == null ? null : headAdmin.trim();
    }

    /**
     * 总部对接行政联系方式
     * @return head_admin_tel 总部对接行政联系方式
     */
    public String getHeadAdminTel() {
        return headAdminTel;
    }

    /**
     * 总部对接行政联系方式
     * @param headAdminTel 总部对接行政联系方式
     */
    public void setHeadAdminTel(String headAdminTel) {
        this.headAdminTel = headAdminTel == null ? null : headAdminTel.trim();
    }

    /**
     * 办公状态
     * @return office_state 办公状态
     */
    public String getOfficeState() {
        return officeState;
    }

    /**
     * 办公状态
     * @param officeState 办公状态
     */
    public void setOfficeState(String officeState) {
        this.officeState = officeState == null ? null : officeState.trim();
    }

    /**
     * 是否三证合一
     * @return threelicense_one 是否三证合一
     */
    public String getThreelicenseOne() {
        return threelicenseOne;
    }

    /**
     * 是否三证合一
     * @param threelicenseOne 是否三证合一
     */
    public void setThreelicenseOne(String threelicenseOne) {
        this.threelicenseOne = threelicenseOne == null ? null : threelicenseOne.trim();
    }

    /**
     * 营业执照
     * @return license 营业执照
     */
    public String getLicense() {
        return license;
    }

    /**
     * 营业执照
     * @param license 营业执照
     */
    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    /**
     * 税务登记证
     * @return tax_registration 税务登记证
     */
    public String getTaxRegistration() {
        return taxRegistration;
    }

    /**
     * 税务登记证
     * @param taxRegistration 税务登记证
     */
    public void setTaxRegistration(String taxRegistration) {
        this.taxRegistration = taxRegistration == null ? null : taxRegistration.trim();
    }

    /**
     * 组织机构代码证
     * @return organization_code 组织机构代码证
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * 组织机构代码证
     * @param organizationCode 组织机构代码证
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * 统计证
     * @return sta_certificate 统计证
     */
    public String getStaCertificate() {
        return staCertificate;
    }

    /**
     * 统计证
     * @param staCertificate 统计证
     */
    public void setStaCertificate(String staCertificate) {
        this.staCertificate = staCertificate == null ? null : staCertificate.trim();
    }

    /**
     * 开户许可证
     * @return account_open_license 开户许可证
     */
    public String getAccountOpenLicense() {
        return accountOpenLicense;
    }

    /**
     * 开户许可证
     * @param accountOpenLicense 开户许可证
     */
    public void setAccountOpenLicense(String accountOpenLicense) {
        this.accountOpenLicense = accountOpenLicense == null ? null : accountOpenLicense.trim();
    }

    /**
     * 机构信用代码证
     * @return institution_credit_code 机构信用代码证
     */
    public String getInstitutionCreditCode() {
        return institutionCreditCode;
    }

    /**
     * 机构信用代码证
     * @param institutionCreditCode 机构信用代码证
     */
    public void setInstitutionCreditCode(String institutionCreditCode) {
        this.institutionCreditCode = institutionCreditCode == null ? null : institutionCreditCode.trim();
    }

    /**
     * 公章是否寄回
     * @return seal_status 公章是否寄回
     */
    public String getSealStatus() {
        return sealStatus;
    }

    /**
     * 公章是否寄回
     * @param sealStatus 公章是否寄回
     */
    public void setSealStatus(String sealStatus) {
        this.sealStatus = sealStatus == null ? null : sealStatus.trim();
    }

    /**
     * 是否有负责人章
     * @return personal_has 是否有负责人章
     */
    public String getPersonalHas() {
        return personalHas;
    }

    /**
     * 是否有负责人章
     * @param personalHas 是否有负责人章
     */
    public void setPersonalHas(String personalHas) {
        this.personalHas = personalHas == null ? null : personalHas.trim();
    }

    /**
     * 负责人章姓名
     * @return personal_seal 负责人章姓名
     */
    public String getPersonalSeal() {
        return personalSeal;
    }

    /**
     * 负责人章姓名
     * @param personalSeal 负责人章姓名
     */
    public void setPersonalSeal(String personalSeal) {
        this.personalSeal = personalSeal == null ? null : personalSeal.trim();
    }

    /**
     * 私章是否寄回
     * @return personal_seal_status 私章是否寄回
     */
    public String getPersonalSealStatus() {
        return personalSealStatus;
    }

    /**
     * 私章是否寄回
     * @param personalSealStatus 私章是否寄回
     */
    public void setPersonalSealStatus(String personalSealStatus) {
        this.personalSealStatus = personalSealStatus == null ? null : personalSealStatus.trim();
    }

    /**
     * 备注
     * @return comment 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * 操作时间
     * @return operation_time 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 操作时间
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 数据状态（0：已删除、1：正常、2：历史记录）
     * @return is_delete 数据状态（0：已删除、1：正常、2：历史记录）
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 数据状态（0：已删除、1：正常、2：历史记录）
     * @param isDelete 数据状态（0：已删除、1：正常、2：历史记录）
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}