package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * 暴露秒杀地址DTO
 * Created by yezhaoyi on 16/6/12.
 */
public class Exposer {
    private boolean  exposed ;
    //一种加密措施
    private String   md5 ;

    private long      seckillId ;
    //系统当前时间
    private  long     now ;

    private long   star ;

    private long   end  ;

    public Exposer(boolean exposed, long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, String md5, long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exposer(boolean exposed, long now, long star, long end) {
        this.exposed = exposed;
        this.now = now;
        this.star = star;
        this.end = end;
    }

    public Exposer(boolean exposed, String md5, long seckillId, long now, long star, long end) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
        this.now = now;
        this.star = star;
        this.end = end;
    }

    public boolean isExposed() {
        return exposed;
    }

    public String getMd5() {
        return md5;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public long getNow() {
        return now;
    }

    public long getStar() {
        return star;
    }

    public long getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", star=" + star +
                ", end=" + end +
                '}';
    }
}
