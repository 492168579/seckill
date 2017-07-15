package org.seckill.entity;

public class AcvicityConfig {
    private Integer acvicityId;

    private String acvicityName;

    private String acvicityUrl;

    private Integer acvicityStatus;

    public AcvicityConfig(Integer acvicityId, String acvicityName, String acvicityUrl, Integer acvicityStatus) {
        this.acvicityId = acvicityId;
        this.acvicityName = acvicityName;
        this.acvicityUrl = acvicityUrl;
        this.acvicityStatus = acvicityStatus;
    }

    public AcvicityConfig() {
        super();
    }

    public Integer getAcvicityId() {
        return acvicityId;
    }

    public void setAcvicityId(Integer acvicityId) {
        this.acvicityId = acvicityId;
    }

    public String getAcvicityName() {
        return acvicityName;
    }

    public void setAcvicityName(String acvicityName) {
        this.acvicityName = acvicityName == null ? null : acvicityName.trim();
    }

    public String getAcvicityUrl() {
        return acvicityUrl;
    }

    public void setAcvicityUrl(String acvicityUrl) {
        this.acvicityUrl = acvicityUrl == null ? null : acvicityUrl.trim();
    }

    public Integer getAcvicityStatus() {
        return acvicityStatus;
    }

    public void setAcvicityStatus(Integer acvicityStatus) {
        this.acvicityStatus = acvicityStatus;
    }
}