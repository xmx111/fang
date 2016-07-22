package com.ufo.fang.center.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HouseRelease implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 内部编码
     */
    private String code;

    /**
     * 经纪人_id
     */
    private Long agentId;

    /**
     * 采集房源_uuid
     */
    private String collectFangUuid;

    /**
     * 用途
     */
    private Boolean useType;

    /**
     * 销售类型
     */
    private Boolean salesType;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 楼盘名称
     */
    private String gradingName;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 区县
     */
    private String district;

    /**
     * 商圈
     */
    private String cbd;

    /**
     * 地址
     */
    private String address;

    /**
     * 楼号
     */
    private String buildingNo;

    /**
     * 单元
     */
    private String unitNo;

    /**
     * 房号
     */
    private String houseNo;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 出售底价
     */
    private BigDecimal salesBasePrice;

    /**
     * 室
     */
    private Integer room;

    /**
     * 厅
     */
    private Integer hall;

    /**
     * 厨
     */
    private Integer kitchen;

    /**
     * 卫
     */
    private Integer toilet;

    /**
     * 出售价
     */
    private BigDecimal salesPrice;

    /**
     * 出售每平米价
     */
    private BigDecimal salesUnitPrice;

    /**
     * 阳台
     */
    private Integer balcony;

    /**
     * 位置
     */
    private String position;

    /**
     * 进深
     */
    private Double depth;

    /**
     * 层高
     */
    private Double floorHeight;

    /**
     * 门宽
     */
    private Double gateWidth;

    /**
     * 层数
     */
    private Boolean floorNum;

    /**
     * 级别
     */
    private Boolean level;

    /**
     * 实率
     */
    private Double officeRate;

    /**
     * 长度
     */
    private Double parkingLength;

    /**
     * 宽度
     */
    private Double parkingWidth;

    /**
     * 包月
     */
    private BigDecimal payMonth;

    /**
     * 排量
     */
    private String capacity;

    /**
     * 特色
     */
    private String feature;

    /**
     * 价格
     */
    private Integer publishPrice;

    /**
     * 最低首付
     */
    private Integer lowestPrice;

    /**
     * 产权性质
     */
    private Boolean propertyRightType2;

    /**
     * 建筑年代
     */
    private Integer buildingYear;

    /**
     * 建筑面积
     */
    private Integer buildingArea;

    /**
     * 使用面积
     */
    private Double usableArea;

    /**
     * 住宅类型
     */
    private Boolean housingType;

    /**
     * 装修类型
     */
    private Boolean decorationType2;

    /**
     * 朝向
     */
    private Boolean orientation;

    /**
     * 建筑结构
     */
    private Boolean buildingStructure;

    /**
     * 产证满五
     */
    private Boolean certificateFive;

    /**
     * 唯一住房
     */
    private Boolean onlyHousing;

    /**
     * 看房时间
     */
    private String lookTimeType;

    /**
     * 内部编号
     */
    private String innerCode;

    /**
     * 税费类型
     */
    private Boolean taxType;

    /**
     * 出租价
     */
    private BigDecimal leasePrice;

    /**
     * 出租每平米价
     */
    private BigDecimal leaseUnitPrice;

    /**
     * 支付方式
     */
    private Boolean payType;

    /**
     * 押
     */
    private Integer detain;

    /**
     * 付
     */
    private Integer pay;

    /**
     * 委托方式
     */
    private Boolean delegationType;

    /**
     * 委托时间
     */
    private Date delegationTime;

    /**
     * 管理费
     */
    private BigDecimal managerPrice;

    /**
     * 交房时间
     */
    private Date readyTime;

    /**
     * 委托编号
     */
    private String delegationNo;

    /**
     * 来源
     */
    private Boolean sourceType;

    /**
     * 现状
     */
    private Boolean actualityType;

    /**
     * 产权
     */
    private Boolean propertyRightType;

    /**
     * 装修
     */
    private Boolean decorationType;

    /**
     * 证书
     */
    private Boolean credentialsType;

    /**
     * 配套
     */
    private String baseService;

    /**
     * 家具
     */
    private String furniture;

    /**
     * 家电
     */
    private String electronics;

    /**
     * 付款方式
     */
    private Boolean paymentType;

    /**
     * 付拥
     */
    private Boolean commissionType;

    /**
     * 钥匙
     */
    private Boolean hasKey;

    /**
     * 钥匙编号
     */
    private String keyNo;

    /**
     * 业主
     */
    private String owner;

    /**
     * 业主电话
     */
    private String ownerMobile;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 房产证
     */
    private String propertyCredentials;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 联系说明
     */
    private String contactExplain;

    /**
     * 备注
     */
    private String remark;

    /**
     * 标签1
     */
    private String tag1;

    /**
     * 标签2
     */
    private String tag2;

    /**
     * 标签3
     */
    private String tag3;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 房源描述
     */
    private String describes;

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

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public String getCollectFangUuid() {
        return collectFangUuid;
    }

    public void setCollectFangUuid(String collectFangUuid) {
        this.collectFangUuid = collectFangUuid == null ? null : collectFangUuid.trim();
    }

    public Boolean getUseType() {
        return useType;
    }

    public void setUseType(Boolean useType) {
        this.useType = useType;
    }

    public Boolean getSalesType() {
        return salesType;
    }

    public void setSalesType(Boolean salesType) {
        this.salesType = salesType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getGradingName() {
        return gradingName;
    }

    public void setGradingName(String gradingName) {
        this.gradingName = gradingName == null ? null : gradingName.trim();
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getCbd() {
        return cbd;
    }

    public void setCbd(String cbd) {
        this.cbd = cbd == null ? null : cbd.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo == null ? null : buildingNo.trim();
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo == null ? null : unitNo.trim();
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo == null ? null : houseNo.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public BigDecimal getSalesBasePrice() {
        return salesBasePrice;
    }

    public void setSalesBasePrice(BigDecimal salesBasePrice) {
        this.salesBasePrice = salesBasePrice;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getSalesUnitPrice() {
        return salesUnitPrice;
    }

    public void setSalesUnitPrice(BigDecimal salesUnitPrice) {
        this.salesUnitPrice = salesUnitPrice;
    }

    public Integer getBalcony() {
        return balcony;
    }

    public void setBalcony(Integer balcony) {
        this.balcony = balcony;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Double floorHeight) {
        this.floorHeight = floorHeight;
    }

    public Double getGateWidth() {
        return gateWidth;
    }

    public void setGateWidth(Double gateWidth) {
        this.gateWidth = gateWidth;
    }

    public Boolean getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Boolean floorNum) {
        this.floorNum = floorNum;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public Double getOfficeRate() {
        return officeRate;
    }

    public void setOfficeRate(Double officeRate) {
        this.officeRate = officeRate;
    }

    public Double getParkingLength() {
        return parkingLength;
    }

    public void setParkingLength(Double parkingLength) {
        this.parkingLength = parkingLength;
    }

    public Double getParkingWidth() {
        return parkingWidth;
    }

    public void setParkingWidth(Double parkingWidth) {
        this.parkingWidth = parkingWidth;
    }

    public BigDecimal getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(BigDecimal payMonth) {
        this.payMonth = payMonth;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public Integer getPublishPrice() {
        return publishPrice;
    }

    public void setPublishPrice(Integer publishPrice) {
        this.publishPrice = publishPrice;
    }

    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Boolean getPropertyRightType2() {
        return propertyRightType2;
    }

    public void setPropertyRightType2(Boolean propertyRightType2) {
        this.propertyRightType2 = propertyRightType2;
    }

    public Integer getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(Integer buildingYear) {
        this.buildingYear = buildingYear;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Integer buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Boolean getHousingType() {
        return housingType;
    }

    public void setHousingType(Boolean housingType) {
        this.housingType = housingType;
    }

    public Boolean getDecorationType2() {
        return decorationType2;
    }

    public void setDecorationType2(Boolean decorationType2) {
        this.decorationType2 = decorationType2;
    }

    public Boolean getOrientation() {
        return orientation;
    }

    public void setOrientation(Boolean orientation) {
        this.orientation = orientation;
    }

    public Boolean getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(Boolean buildingStructure) {
        this.buildingStructure = buildingStructure;
    }

    public Boolean getCertificateFive() {
        return certificateFive;
    }

    public void setCertificateFive(Boolean certificateFive) {
        this.certificateFive = certificateFive;
    }

    public Boolean getOnlyHousing() {
        return onlyHousing;
    }

    public void setOnlyHousing(Boolean onlyHousing) {
        this.onlyHousing = onlyHousing;
    }

    public String getLookTimeType() {
        return lookTimeType;
    }

    public void setLookTimeType(String lookTimeType) {
        this.lookTimeType = lookTimeType == null ? null : lookTimeType.trim();
    }

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode == null ? null : innerCode.trim();
    }

    public Boolean getTaxType() {
        return taxType;
    }

    public void setTaxType(Boolean taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public BigDecimal getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(BigDecimal leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
    }

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
    }

    public Integer getDetain() {
        return detain;
    }

    public void setDetain(Integer detain) {
        this.detain = detain;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Boolean getDelegationType() {
        return delegationType;
    }

    public void setDelegationType(Boolean delegationType) {
        this.delegationType = delegationType;
    }

    public Date getDelegationTime() {
        return delegationTime;
    }

    public void setDelegationTime(Date delegationTime) {
        this.delegationTime = delegationTime;
    }

    public BigDecimal getManagerPrice() {
        return managerPrice;
    }

    public void setManagerPrice(BigDecimal managerPrice) {
        this.managerPrice = managerPrice;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Date readyTime) {
        this.readyTime = readyTime;
    }

    public String getDelegationNo() {
        return delegationNo;
    }

    public void setDelegationNo(String delegationNo) {
        this.delegationNo = delegationNo == null ? null : delegationNo.trim();
    }

    public Boolean getSourceType() {
        return sourceType;
    }

    public void setSourceType(Boolean sourceType) {
        this.sourceType = sourceType;
    }

    public Boolean getActualityType() {
        return actualityType;
    }

    public void setActualityType(Boolean actualityType) {
        this.actualityType = actualityType;
    }

    public Boolean getPropertyRightType() {
        return propertyRightType;
    }

    public void setPropertyRightType(Boolean propertyRightType) {
        this.propertyRightType = propertyRightType;
    }

    public Boolean getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(Boolean decorationType) {
        this.decorationType = decorationType;
    }

    public Boolean getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Boolean credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getBaseService() {
        return baseService;
    }

    public void setBaseService(String baseService) {
        this.baseService = baseService == null ? null : baseService.trim();
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture == null ? null : furniture.trim();
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics == null ? null : electronics.trim();
    }

    public Boolean getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Boolean paymentType) {
        this.paymentType = paymentType;
    }

    public Boolean getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Boolean commissionType) {
        this.commissionType = commissionType;
    }

    public Boolean getHasKey() {
        return hasKey;
    }

    public void setHasKey(Boolean hasKey) {
        this.hasKey = hasKey;
    }

    public String getKeyNo() {
        return keyNo;
    }

    public void setKeyNo(String keyNo) {
        this.keyNo = keyNo == null ? null : keyNo.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile == null ? null : ownerMobile.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPropertyCredentials() {
        return propertyCredentials;
    }

    public void setPropertyCredentials(String propertyCredentials) {
        this.propertyCredentials = propertyCredentials == null ? null : propertyCredentials.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getContactExplain() {
        return contactExplain;
    }

    public void setContactExplain(String contactExplain) {
        this.contactExplain = contactExplain == null ? null : contactExplain.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1 == null ? null : tag1.trim();
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2 == null ? null : tag2.trim();
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3 == null ? null : tag3.trim();
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", agentId=").append(agentId);
        sb.append(", collectFangUuid=").append(collectFangUuid);
        sb.append(", useType=").append(useType);
        sb.append(", salesType=").append(salesType);
        sb.append(", status=").append(status);
        sb.append(", gradingName=").append(gradingName);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", cbd=").append(cbd);
        sb.append(", address=").append(address);
        sb.append(", buildingNo=").append(buildingNo);
        sb.append(", unitNo=").append(unitNo);
        sb.append(", houseNo=").append(houseNo);
        sb.append(", floor=").append(floor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", salesBasePrice=").append(salesBasePrice);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", toilet=").append(toilet);
        sb.append(", salesPrice=").append(salesPrice);
        sb.append(", salesUnitPrice=").append(salesUnitPrice);
        sb.append(", balcony=").append(balcony);
        sb.append(", position=").append(position);
        sb.append(", depth=").append(depth);
        sb.append(", floorHeight=").append(floorHeight);
        sb.append(", gateWidth=").append(gateWidth);
        sb.append(", floorNum=").append(floorNum);
        sb.append(", level=").append(level);
        sb.append(", officeRate=").append(officeRate);
        sb.append(", parkingLength=").append(parkingLength);
        sb.append(", parkingWidth=").append(parkingWidth);
        sb.append(", payMonth=").append(payMonth);
        sb.append(", capacity=").append(capacity);
        sb.append(", feature=").append(feature);
        sb.append(", publishPrice=").append(publishPrice);
        sb.append(", lowestPrice=").append(lowestPrice);
        sb.append(", propertyRightType2=").append(propertyRightType2);
        sb.append(", buildingYear=").append(buildingYear);
        sb.append(", buildingArea=").append(buildingArea);
        sb.append(", usableArea=").append(usableArea);
        sb.append(", housingType=").append(housingType);
        sb.append(", decorationType2=").append(decorationType2);
        sb.append(", orientation=").append(orientation);
        sb.append(", buildingStructure=").append(buildingStructure);
        sb.append(", certificateFive=").append(certificateFive);
        sb.append(", onlyHousing=").append(onlyHousing);
        sb.append(", lookTimeType=").append(lookTimeType);
        sb.append(", innerCode=").append(innerCode);
        sb.append(", taxType=").append(taxType);
        sb.append(", leasePrice=").append(leasePrice);
        sb.append(", leaseUnitPrice=").append(leaseUnitPrice);
        sb.append(", payType=").append(payType);
        sb.append(", detain=").append(detain);
        sb.append(", pay=").append(pay);
        sb.append(", delegationType=").append(delegationType);
        sb.append(", delegationTime=").append(delegationTime);
        sb.append(", managerPrice=").append(managerPrice);
        sb.append(", readyTime=").append(readyTime);
        sb.append(", delegationNo=").append(delegationNo);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", actualityType=").append(actualityType);
        sb.append(", propertyRightType=").append(propertyRightType);
        sb.append(", decorationType=").append(decorationType);
        sb.append(", credentialsType=").append(credentialsType);
        sb.append(", baseService=").append(baseService);
        sb.append(", furniture=").append(furniture);
        sb.append(", electronics=").append(electronics);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", commissionType=").append(commissionType);
        sb.append(", hasKey=").append(hasKey);
        sb.append(", keyNo=").append(keyNo);
        sb.append(", owner=").append(owner);
        sb.append(", ownerMobile=").append(ownerMobile);
        sb.append(", contact=").append(contact);
        sb.append(", propertyCredentials=").append(propertyCredentials);
        sb.append(", nationality=").append(nationality);
        sb.append(", contactExplain=").append(contactExplain);
        sb.append(", remark=").append(remark);
        sb.append(", tag1=").append(tag1);
        sb.append(", tag2=").append(tag2);
        sb.append(", tag3=").append(tag3);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", describes=").append(describes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}