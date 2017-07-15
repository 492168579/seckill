package org.seckill.entity;

import java.util.Date;

/**
 * Created by yezhaoyi on 16/8/20.
 */
public class User {
    private  String id ;
    private  String userName ;
    private  String psw ;
    private  String status ;
    private Date cteateTime ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCteateTime() {
        return cteateTime;
    }

    public void setCteateTime(Date cteateTime) {
        this.cteateTime = cteateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", psw='" + psw + '\'' +
                ", status='" + status + '\'' +
                ", cteateTime=" + cteateTime +
                '}';
    }
}
