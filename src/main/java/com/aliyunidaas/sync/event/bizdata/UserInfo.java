package com.aliyunidaas.sync.event.bizdata;

import com.aliyunidaas.sync.internal.util.StringUtil;

import java.util.List;

/**
 * 用户对象
 *
 * @author hatterjiang
 */
public class UserInfo {
    /**
     * 来源类型，取值 build_in 表示UD内建用户
     *
     * @deprecated 使用userSourceType替代
     */
    private String sourceType;
    /**
     * 来源类型，取值 build_in 表示UD内建用户，用于替代 sourceType
     */
    private String userSourceType;
    /**
     * 来源类型ID
     *
     * @deprecated 使用userSourceId替代
     */
    private String sourceId;
    /**
     * 来源类型ID，用于替代 sourceId
     */
    private String userSourceId;

    /**
     * 用户唯一ID，是以 user_ 开始的，对于同一个用户，用户唯一ID是不会变化的，示例：user_ezb3oauipzax3gbxhg4c5blc64
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 外部id。若是自建账户则和useId一致；若是外部同步的账户，则为来源的用户id。如来源是钉钉，则为钉钉的userId。 同externalId。
     */
    private String userExternalId;
    /**
     * 显示名称，一般为用户姓名
     */
    private String displayName;

    /**
     * 用户密码，只有在同步时选择"同步密码"才会有该字段
     */
    private String password;
    /**
     * 当前用户是否已经设置密码
     */
    private Boolean passwordSet;

    /**
     * 电话(手机)号码
     */
    private String phoneNumber;
    /**
     * 电话(手机)号码国家或地区代码，比如中国大陆为 86，美国为 1
     */
    private String phoneRegion;
    /**
     * 电话(手机)号码是否已经验证
     */
    private Boolean phoneVerified;

    /**
     * 电子邮箱地址
     */
    private String email;
    /**
     * 电子邮箱地址是否已经验证
     */
    private Boolean emailVerified;

    /**
     * 状态：enabled-启用，disabled-禁用
     */
    private String status;
    /**
     * 用户过期时间
     */
    private Long accountExpireTime;
    /**
     * 注册时间
     */
    private Long registerTime;
    /**
     * 锁定时间
     */
    private Long lockExpireTime;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 最后修改时间
     *
     * @deprecated 使用updateTime替代
     */
    private Long lastUpdatedTime;
    /**
     * 最后修改时间，用于替代 lastUpdatedTime
     */
    private Long updateTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 所属主组织机构
     */
    private String primaryOrganizationalUnitId;
    /**
     * 所属组织机构列表
     */
    private List<UserInfoOrganizationalUnit> userOrganizationalUnits;

    public String getSourceType() {
        return StringUtil.isNotEmpty(sourceType) ? sourceType : userSourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getUserSourceType() {
        return userSourceType;
    }

    public void setUserSourceType(String userSourceType) {
        this.userSourceType = userSourceType;
    }

    public String getSourceId() {
        return StringUtil.isNotEmpty(sourceId) ? sourceId : userSourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getUserSourceId() {
        return userSourceId;
    }

    public void setUserSourceId(String userSourceId) {
        this.userSourceId = userSourceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserExternalId() {
        return userExternalId;
    }

    public void setUserExternalId(String userExternalId) {
        this.userExternalId = userExternalId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPasswordSet() {
        return passwordSet;
    }

    public void setPasswordSet(Boolean passwordSet) {
        this.passwordSet = passwordSet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneRegion() {
        return phoneRegion;
    }

    public void setPhoneRegion(String phoneRegion) {
        this.phoneRegion = phoneRegion;
    }

    public Boolean getPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(Boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAccountExpireTime() {
        return accountExpireTime;
    }

    public void setAccountExpireTime(Long accountExpireTime) {
        this.accountExpireTime = accountExpireTime;
    }

    public Long getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Long registerTime) {
        this.registerTime = registerTime;
    }

    public Long getLockExpireTime() {
        return lockExpireTime;
    }

    public void setLockExpireTime(Long lockExpireTime) {
        this.lockExpireTime = lockExpireTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastUpdatedTime() {
        // 用于兼容将来废弃lastUpdatedTime字段
        return (lastUpdatedTime != null) ? lastUpdatedTime : updateTime;
    }

    public void setLastUpdatedTime(Long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryOrganizationalUnitId() {
        return primaryOrganizationalUnitId;
    }

    public void setPrimaryOrganizationalUnitId(String primaryOrganizationalUnitId) {
        this.primaryOrganizationalUnitId = primaryOrganizationalUnitId;
    }

    public List<UserInfoOrganizationalUnit> getUserOrganizationalUnits() {
        return userOrganizationalUnits;
    }

    public void setUserOrganizationalUnits(List<UserInfoOrganizationalUnit> userOrganizationalUnits) {
        this.userOrganizationalUnits = userOrganizationalUnits;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "sourceType='" + sourceType + '\'' +
                ", userSourceType='" + userSourceType + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", userSourceId='" + userSourceId + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userExternalId='" + userExternalId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='******'" +
                ", passwordSet=" + passwordSet +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneRegion='" + phoneRegion + '\'' +
                ", phoneVerified=" + phoneVerified +
                ", email='" + email + '\'' +
                ", emailVerified=" + emailVerified +
                ", status='" + status + '\'' +
                ", accountExpireTime=" + accountExpireTime +
                ", registerTime=" + registerTime +
                ", lockExpireTime=" + lockExpireTime +
                ", createTime=" + createTime +
                ", lastUpdatedTime=" + lastUpdatedTime +
                ", updateTime=" + updateTime +
                ", description='" + description + '\'' +
                ", primaryOrganizationalUnitId='" + primaryOrganizationalUnitId + '\'' +
                ", userOrganizationalUnits=" + userOrganizationalUnits +
                '}';
    }
}
