package com.ufo.fang.center.model;

import java.io.Serializable;
import java.util.Date;

public class GradingInfo implements Serializable {
    /**
     * 楼盘_id
     */
    private Long id;

    /**
     * 楼盘_id
     */
    private Long gradingId;

    /**
     * 交通状况
     */
    private String trafficDescribe;

    /**
     * 大学
     */
    private String university;

    /**
     * 中小学
     */
    private String school;

    /**
     * 幼儿园
     */
    private String kindergarten;

    /**
     * 商场
     */
    private String mall;

    /**
     * 邮局
     */
    private String postOffice;

    /**
     * 银行
     */
    private String bank;

    /**
     * 医院
     */
    private String hospital;

    /**
     * 其它
     */
    private String other;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradingId() {
        return gradingId;
    }

    public void setGradingId(Long gradingId) {
        this.gradingId = gradingId;
    }

    public String getTrafficDescribe() {
        return trafficDescribe;
    }

    public void setTrafficDescribe(String trafficDescribe) {
        this.trafficDescribe = trafficDescribe == null ? null : trafficDescribe.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(String kindergarten) {
        this.kindergarten = kindergarten == null ? null : kindergarten.trim();
    }

    public String getMall() {
        return mall;
    }

    public void setMall(String mall) {
        this.mall = mall == null ? null : mall.trim();
    }

    public String getPostOffice() {
        return postOffice;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice == null ? null : postOffice.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gradingId=").append(gradingId);
        sb.append(", trafficDescribe=").append(trafficDescribe);
        sb.append(", university=").append(university);
        sb.append(", school=").append(school);
        sb.append(", kindergarten=").append(kindergarten);
        sb.append(", mall=").append(mall);
        sb.append(", postOffice=").append(postOffice);
        sb.append(", bank=").append(bank);
        sb.append(", hospital=").append(hospital);
        sb.append(", other=").append(other);
        sb.append(", tel=").append(tel);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}