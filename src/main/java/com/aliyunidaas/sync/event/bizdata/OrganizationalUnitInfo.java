package com.aliyunidaas.sync.event.bizdata;

/**
 * 组织机构对象
 *
 * @author hatterjiang
 */
public class OrganizationalUnitInfo {
    /**
     * 组织机构唯一ID
     */
    private String organizationalUnitId;
    /**
     * 组织机构名称
     */
    private String name;
    /**
     * 父级组织机构ID
     */
    private String parentId;
    /**
     * 外部ID
     */
    private String externalId;
    /**
     * 来源类型
     */
    private String sourceType;
    /**
     * 来源类型ID
     */
    private String sourceId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后修改时间
     */
    private String lastUpdatedTime;
    /**
     * 描述
     */
    private String description;

    public String getOrganizationalUnitId() {
        return organizationalUnitId;
    }

    public void setOrganizationalUnitId(String organizationalUnitId) {
        this.organizationalUnitId = organizationalUnitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OrganizationalUnitInfo{" +
                "organizationalUnitId='" + organizationalUnitId + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", externalId='" + externalId + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastUpdatedTime='" + lastUpdatedTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
