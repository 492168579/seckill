package org.seckill.entity;

import java.util.Date;

public class Admin {
    private Integer adminCode;

    private String adminName;

    private String adminPsw;

    private Integer status;

    private Date createTime;

    public Admin(Integer adminCode, String adminName, String adminPsw, Integer status, Date createTime) {
        this.adminCode = adminCode;
        this.adminName = adminName;
        this.adminPsw = adminPsw;
        this.status = status;
        this.createTime = createTime;
    }

    public Admin() {
        super();
    }

    public Integer getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(Integer adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPsw() {
        return adminPsw;
    }

    public void setAdminPsw(String adminPsw) {
        this.adminPsw = adminPsw == null ? null : adminPsw.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}