package org.seckill.entity;

public class FunctionConfig {
    private Long functionId;

    private String name;

    private String url;

    private Integer status;

    public FunctionConfig(Long functionId, String name, String url, Integer status) {
        this.functionId = functionId;
        this.name = name;
        this.url = url;
        this.status = status;
    }

    public FunctionConfig() {
        super();
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}