package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcuption;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口,站在"使用者"的角度设计接口
 * 三个方面:方法定义粒度,参数,返回类型(return 类型/异常)
 * Created by yezhaoyi on 16/6/12.
 */
public interface SeckillService {
    public List<Seckill>getSeckillList();

    public Seckill getById(Long seckillId);

    /**
     * 秒杀开始输出秒杀地址,否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(Long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExcuption excuteSeckill(long seckillId , long userPhone , String md5)throws RepeatKillException ,RepeatKillException , SeckillException;

    /**
     * 执行秒杀操作by存储过程
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExcuption excuteSeckillProcedure(long seckillId , long userPhone , String md5)throws RepeatKillException ,RepeatKillException , SeckillException;

}
