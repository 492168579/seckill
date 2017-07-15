package org.seckill.entity;

public class AdminRole {
    private Integer id;

    private Integer adminCode;

    private Integer roleId;

    private RoleConfig roleConfig ;

    public AdminRole(Integer id, Integer adminCode, Integer roleId) {
        this.id = id;
        this.adminCode = adminCode;
        this.roleId = roleId;
    }

    public AdminRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleConfig getRoleConfig() {
        return roleConfig;
    }

    public void setRoleConfig(RoleConfig roleConfig) {
        this.roleConfig = roleConfig;
    }
}