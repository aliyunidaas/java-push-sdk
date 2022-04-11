package com.aliyunidaas.sync.event.bizdata;

import java.util.List;

/**
 * 用户对象
 *
 * @author hatterjiang
 */
public class UserInfo {
    /**
     * 来源类型，取值 build_in 表示UD内建用户
     */
    private String sourceType;
    /**
     * 来源类型ID
     */
    private String sourceId;

    /**
     * 用户唯一ID，是以 user_ 开始的，对于同一个用户，用户唯一ID是不会变化的，示例：user_ezb3oauipzax3gbxhg4c5blc64
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;
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
     */
    private Long lastUpdatedTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 所属组织机构列表
     */
    private List<UserInfoOrganizationalUnit> userOrganizationalUnits;

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
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", sourceId='" + sourceId + '\'' +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
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
                ", description='" + description + '\'' +
                ", userOrganizationalUnits=" + userOrganizationalUnits +
                '}';
    }
}
