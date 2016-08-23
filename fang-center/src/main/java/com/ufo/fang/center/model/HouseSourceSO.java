package com.ufo.fang.center.model;

import com.ufo.fang.center.crawler.processor.TongChengProcessor;
import com.ufo.fang.common.util.DateUtils;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * Describe
 *
 * @author hekang
 * @created 2016/8/12
 */
@TargetUrl(TongChengProcessor.URL_POST)
@HelpUrl(TongChengProcessor.URL_LIST)
public class HouseSourceSO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 来源
     */
    private String source;

    /**
     * 来源url
     */
    private String url;

    /**
     * 外部id
     */
    private String sourceId;

    /**
     * 标题
     */
    @ExtractBy(value = "//div[@class='main']//div[@class='mainTitle']/div[@class='bigtitle']/h1/text()", notNull = true)
    private String title;

    /**
     * 楼盘名称
     */
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[3]/text()")
    private String gradingName;

    /**
     * 用途
     */
    private String useType;

    /**
     * 销售类型
     */
    private String salesType;

    /**
     * 状态
     */
    private String status;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 区
     */
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[1]/text()")
    private String district;

    /**
     * 商圈
     */
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[5]/a[2]/text()")
    private String cbd;

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
     * 阳台
     */
    private Integer balcony;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 价格
     */
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[1]/div[@class='su_con']/span[1]/text()")
    private Double publishPrice;

    /**
     * 产权性质
     */
    private String propertyRightType;

    /**
     * 建筑年代
     */
    private String buildingYear;

    /**
     * 建筑面积
     */
    private Double buildingArea;

    /**
     * 使用面积
     */
    private Double usableArea;

    /**
     * 住宅类型
     */
    private String housingType;

    /**
     * 装修类型
     */
    private String decorationType;

    /**
     * 建筑结构
     */
    private String buildingStructure;

    /**
     * 朝向
     */
    private String orientation;

    /**
     * 房源描述
     */
    private String describes;

    /**
     * 联系人
     */
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[8]/div[@class='su_con']//a[1]/text()")
    private String contact;

    /**
     * 联系电话
     */
    private String contactMobile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    // 户型
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[4]/div[2]/text()")
    private String houseTypeStr;

    // 地址
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[6]/div[@class='su_con']/text()")
    private String address;

    // 身份
    @ExtractBy("//div[@class='main']//div[@class='maintop']/div[@class='sumary']/ul[1]/li[7]/div[@class='su_con']//em[1]/text()")
    private String contactType;

    // 大图
    @ExtractBy("//div[@class='main']//div[@class='description']//div[@class='descriptionImg']//img/@src")
    private List<String> downloadUrls;

    private String imgUrls;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getGradingName() {
        return gradingName;
    }

    public void setGradingName(String gradingName) {
        this.gradingName = gradingName == null ? null : gradingName.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType == null ? null : salesType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Integer getBalcony() {
        return balcony;
    }

    public void setBalcony(Integer balcony) {
        this.balcony = balcony;
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

    public Double getPublishPrice() {
        return publishPrice;
    }

    public void setPublishPrice(Double publishPrice) {
        this.publishPrice = publishPrice;
    }

    public String getPropertyRightType() {
        return propertyRightType;
    }

    public void setPropertyRightType(String propertyRightType) {
        this.propertyRightType = propertyRightType == null ? null : propertyRightType.trim();
    }

    public String getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(String buildingYear) {
        this.buildingYear = buildingYear == null ? null : buildingYear.trim();
    }

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public String getHousingType() {
        return housingType;
    }

    public void setHousingType(String housingType) {
        this.housingType = housingType == null ? null : housingType.trim();
    }

    public String getDecorationType() {
        return decorationType;
    }

    public void setDecorationType(String decorationType) {
        this.decorationType = decorationType == null ? null : decorationType.trim();
    }

    public String getBuildingStructure() {
        return buildingStructure;
    }

    public void setBuildingStructure(String buildingStructure) {
        this.buildingStructure = buildingStructure == null ? null : buildingStructure.trim();
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
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

    public String getTime(){
        return DateUtils.getDateBeforeCurrent(createTime);
    }

    public String getHouseTypeStr() {
        return houseTypeStr;
    }

    public void setHouseTypeStr(String houseTypeStr) {
        this.houseTypeStr = houseTypeStr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public List<String> getDownloadUrls() {
        return downloadUrls;
    }

    public void setDownloadUrls(List<String> downloadUrls) {
        this.downloadUrls = downloadUrls;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", source=").append(source);
        sb.append(", url=").append(url);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", title=").append(title);
        sb.append(", gradingName=").append(gradingName);
        sb.append(", useType=").append(useType);
        sb.append(", salesType=").append(salesType);
        sb.append(", status=").append(status);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", cbd=").append(cbd);
        sb.append(", room=").append(room);
        sb.append(", hall=").append(hall);
        sb.append(", kitchen=").append(kitchen);
        sb.append(", toilet=").append(toilet);
        sb.append(", balcony=").append(balcony);
        sb.append(", floor=").append(floor);
        sb.append(", totalFloor=").append(totalFloor);
        sb.append(", publishPrice=").append(publishPrice);
        sb.append(", propertyRightType=").append(propertyRightType);
        sb.append(", buildingYear=").append(buildingYear);
        sb.append(", buildingArea=").append(buildingArea);
        sb.append(", usableArea=").append(usableArea);
        sb.append(", housingType=").append(housingType);
        sb.append(", decorationType=").append(decorationType);
        sb.append(", buildingStructure=").append(buildingStructure);
        sb.append(", orientation=").append(orientation);
        sb.append(", describes=").append(describes);
        sb.append(", contact=").append(contact);
        sb.append(", contactMobile=").append(contactMobile);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public HouseSource toHouseSource(){
        HouseSource hs = new HouseSource();
        hs.setUuid(uuid);
        hs.setTitle(title);
        hs.setUrl(url);
        hs.setGradingName(gradingName);
        hs.setDistrict(district);
        hs.setCbd(cbd);
        hs.setPublishPrice(BigDecimal.valueOf(publishPrice));
        hs.setContact(contact);
        hs.setAddress(address);
        hs.setRoom(room);
        hs.setHall(hall);
        hs.setKitchen(kitchen);
        hs.setToilet(toilet);
        hs.setUsableArea(usableArea);
        hs.setBuildingArea(usableArea);
        // TODO images
//        hs.setDownloadUrls();
        return hs;
    }
}
