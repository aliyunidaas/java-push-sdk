init java sync sdk

```xml
<dependency>
    <groupId>com.aliyunidaas</groupId>
    <artifactId>idaas-sync</artifactId>
    <version>PLEASE_USE_THE_LATEST_VERSION</version>
</dependency>
```
> Find the latest released version at: https://repo1.maven.org/maven2/com/aliyunidaas/idaas-sync/


Release notes:
v1.1.0 - May 2022
- 新增支持事件类型 urn:alibaba:idaas:app:event:common:test
- UserInfo 修改点
    - 修改字段名字 sourceType -> userSourceType
    - 修改字段名字 sourceId -> userSourceId
    - 修改字段名字 lastUpdatedTime -> updateTime
    - 增加字段 userExternalId, primaryOrganizationalUnitId
- UserInfoOrganizationalUnit 修改点
    - 修改字段名字 name -> organizationalUnitName
- OrganizationalUnitInfo 修改点
    - 修改字段名字 name -> organizationalUnitName
    - 修改字段名字 externalId -> organizationalUnitExternalId
    - 修改字段名字 sourceType -> organizationalUnitSourceType
    - 修改字段名字 sourceId -> organizationalUnitSourceId
    - 修改字段名字 lastUpdatedTime -> updateTime

