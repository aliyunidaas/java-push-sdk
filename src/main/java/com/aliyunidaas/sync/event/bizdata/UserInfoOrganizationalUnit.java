package com.aliyunidaas.sync.event.bizdata;

import com.aliyunidaas.sync.internal.util.StringUtil;

/**
 * 用户组织机构对象
 *
 * @author hatterjiang
 */
public class UserInfoOrganizationalUnit {
    /**
     * 所属组织机构唯一ID
     */
    private String organizationalUnitId;
    /**
     * 所属组织机构名称
     *
     * @deprecated 使用organizationalUnitName替代
     */
    private String name;
    /**
     * 所属组织机构名称，用于替代 name
     */
    private String organizationalUnitName;
    /**
     * 所属主组织机构。true-所属主组织机构，false-非主组织机构
     */
    private Boolean primary;

    public String getOrganizationalUnitId() {
        return organizationalUnitId;
    }

    public void setOrganizationalUnitId(String organizationalUnitId) {
        this.organizationalUnitId = organizationalUnitId;
    }

    public String getName() {
        return StringUtil.isNotEmpty(name) ? name : organizationalUnitName;
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

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "UserInfoOrganizationalUnit{" +
                "organizationalUnitId='" + organizationalUnitId + '\'' +
                ", name='" + name + '\'' +
                ", organizationalUnitName='" + organizationalUnitName + '\'' +
                ", primary=" + primary +
                '}';
    }
}
