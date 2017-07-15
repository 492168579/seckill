package org.seckill.entity;

public class RoleConfig {
    private Integer roleId;

    private Short validStatus;

    private String roleName;

    public RoleConfig(Integer roleId, Short validStatus, String roleName) {
        this.roleId = roleId;
        this.validStatus = validStatus;
        this.roleName = roleName;
    }

    public RoleConfig() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}