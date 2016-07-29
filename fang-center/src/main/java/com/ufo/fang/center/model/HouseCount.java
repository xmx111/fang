package com.ufo.fang.center.model;

import java.io.Serializable;

public class HouseCount implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 房源_id
     */
    private Long houseSourceId;

    /**
     * 点击数
     */
    private Integer clickNum;

    /**
     * 采集数
     */
    private Integer collectNum;

    /**
     * 举报数
     */
    private Integer informNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseSourceId() {
        return houseSourceId;
    }

    public void setHouseSourceId(Long houseSourceId) {
        this.houseSourceId = houseSourceId;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getInformNum() {
        return informNum;
    }

    public void setInformNum(Integer informNum) {
        this.informNum = informNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseSourceId=").append(houseSourceId);
        sb.append(", clickNum=").append(clickNum);
        sb.append(", collectNum=").append(collectNum);
        sb.append(", informNum=").append(informNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}