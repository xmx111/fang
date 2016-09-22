package com.ufo.fang.center.model;

import java.io.Serializable;

public class HouseSourceImages implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 房源id
     */
    private Long houseSourceId;

    /**
     * 文件路径
     */
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", houseSourceId=").append(houseSourceId);
        sb.append(", path=").append(path);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}