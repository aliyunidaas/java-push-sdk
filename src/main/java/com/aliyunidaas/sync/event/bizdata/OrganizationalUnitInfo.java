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
     *
     * @deprecated 使用organizationalUnitName替代
     */
    private String name;
    /**
     * 组织机构名称，用于替代 name
     */
    private String organizationalUnitName;
    /**
     * 父级组织机构ID
     */
    private String parentId;
    /**
     * 外部ID
     *
     * @deprecated 使用organizationalUnitExternalId替代
     */
    private String externalId;
    /**
     * 外部ID，用于替代 externalId
     */
    private String organizationalUnitExternalId;
    /**
     * 来源类型
     *
     * @deprecated 使用organizationalUnitSourceType替代
     */
    private String sourceType;
    /**
     * 来源类型，用于替代 sourceType
     */
    private String organizationalUnitSourceType;
    /**
     * 来源类型ID
     *
     * @deprecated 使用organizationalUnitSourceId替代
     */
    private String sourceId;
    /**
     * 来源类型ID，用于替代 sourceId
     */
    private String organizationalUnitSourceId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后修改时间
     *
     * @deprecated 使用updateTime替代
     */
    private String lastUpdatedTime;
    /**
     * 最后修改时间，用于替代 lastUpdatedTime
     */
    private String updateTime;
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

    public String getOrganizationalUnitName() {
        return organizationalUnitName;
    }

    public void setOrganizationalUnitName(String organizationalUnitName) {
        this.organizationalUnitName = organizationalUnitName;
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

    public String getOrganizationalUnitExternalId() {
        return organizationalUnitExternalId;
    }

    public void setOrganizationalUnitExternalId(String organizationalUnitExternalId) {
        this.organizationalUnitExternalId = organizationalUnitExternalId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getOrganizationalUnitSourceType() {
        return organizationalUnitSourceType;
    }

    public void setOrganizationalUnitSourceType(String organizationalUnitSourceType) {
        this.organizationalUnitSourceType = organizationalUnitSourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOrganizationalUnitSourceId() {
        return organizationalUnitSourceId;
    }

    public void setOrganizationalUnitSourceId(String organizationalUnitSourceId) {
        this.organizationalUnitSourceId = organizationalUnitSourceId;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
                ", organizationalUnitName='" + organizationalUnitName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", externalId='" + externalId + '\'' +
                ", organizationalUnitExternalId='" + organizationalUnitExternalId + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", organizationalUnitSourceType='" + organizationalUnitSourceType + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", organizationalUnitSourceId='" + organizationalUnitSourceId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastUpdatedTime='" + lastUpdatedTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
