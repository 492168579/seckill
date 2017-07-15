package org.seckill.entity;

public class RoleAcvicity {
    private Integer roleAcvicityId;

    private Integer roleId;

    private Integer acvicityId;

    private Integer roleAcvicityStatus;

    private AcvicityConfig acvicityConfig ;


    public RoleAcvicity() {
        super();
    }

    public RoleAcvicity(Integer roleAcvicityId, Integer roleId, Integer acvicityId, Integer roleAcvicityStatus) {
        this.roleAcvicityId = roleAcvicityId;
        this.roleId = roleId;
        this.acvicityId = acvicityId;
        this.roleAcvicityStatus = roleAcvicityStatus;
    }



    public Integer getRoleAcvicityId() {
        return roleAcvicityId;
    }

    public void setRoleAcvicityId(Integer roleAcvicityId) {
        this.roleAcvicityId = roleAcvicityId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAcvicityId() {
        return acvicityId;
    }

    public void setAcvicityId(Integer acvicityId) {
        this.acvicityId = acvicityId;
    }

    public Integer getRoleAcvicityStatus() {
        return roleAcvicityStatus;
    }

    public void setRoleAcvicityStatus(Integer roleAcvicityStatus) {
        this.roleAcvicityStatus = roleAcvicityStatus;
    }

    public AcvicityConfig getAcvicityConfig() {
        return acvicityConfig;
    }

    public void setAcvicityConfig(AcvicityConfig acvicityConfig) {
        this.acvicityConfig = acvicityConfig;
    }
}