package com.ufo.fang.center.model;

import java.io.Serializable;
import java.util.Date;

public class Grading implements Serializable {
    private Long id;

    private String code;

    private String name;

    private String anotherName;

    private Integer status;

    private Integer province;

    private Integer city;

    private Integer district;

    private Integer cbd;

    private Integer estateType;

    private String estateAddr;

    private String positionDescribe1;

    private String positionDescribe2;

    private Long roomDrawing;

    private Long mapDrawing;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName == null ? null : anotherName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getCbd() {
        return cbd;
    }

    public void setCbd(Integer cbd) {
        this.cbd = cbd;
    }

    public Integer getEstateType() {
        return estateType;
    }

    public void setEstateType(Integer estateType) {
        this.estateType = estateType;
    }

    public String getEstateAddr() {
        return estateAddr;
    }

    public void setEstateAddr(String estateAddr) {
        this.estateAddr = estateAddr == null ? null : estateAddr.trim();
    }

    public String getPositionDescribe1() {
        return positionDescribe1;
    }

    public void setPositionDescribe1(String positionDescribe1) {
        this.positionDescribe1 = positionDescribe1 == null ? null : positionDescribe1.trim();
    }

    public String getPositionDescribe2() {
        return positionDescribe2;
    }

    public void setPositionDescribe2(String positionDescribe2) {
        this.positionDescribe2 = positionDescribe2 == null ? null : positionDescribe2.trim();
    }

    public Long getRoomDrawing() {
        return roomDrawing;
    }

    public void setRoomDrawing(Long roomDrawing) {
        this.roomDrawing = roomDrawing;
    }

    public Long getMapDrawing() {
        return mapDrawing;
    }

    public void setMapDrawing(Long mapDrawing) {
        this.mapDrawing = mapDrawing;
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", anotherName=").append(anotherName);
        sb.append(", status=").append(status);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", cbd=").append(cbd);
        sb.append(", estateType=").append(estateType);
        sb.append(", estateAddr=").append(estateAddr);
        sb.append(", positionDescribe1=").append(positionDescribe1);
        sb.append(", positionDescribe2=").append(positionDescribe2);
        sb.append(", roomDrawing=").append(roomDrawing);
        sb.append(", mapDrawing=").append(mapDrawing);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}