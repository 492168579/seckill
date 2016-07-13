package org.seckill.entity;

import java.util.Date;

/**
 * Created by yezhaoyi on 16/6/7.
 */
public class SuccessKilled {
    private long seckillId ;
    private long userPhone ;
    private short state ;
    private Date  cteateTime ;

    private  Seckill seckill ;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }



    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCteateTime() {
        return cteateTime;
    }

    public void setCteateTime(Date cteateTime) {
        this.cteateTime = cteateTime;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", cteateTime=" + cteateTime +
                ", seckill=" + seckill +
                '}';
    }
}
