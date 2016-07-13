package org.seckill.service.impl;

import org.apache.commons.collections.MapUtils;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcuption;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by yezhaoyi on 16/6/13.
 *
 */
@Service
public class SeckillServiceImpl implements SeckillService {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao ;
    @Autowired
    private RedisDao   redisDao ;

    @Autowired
    private SuccessKilledDao successKilledDao ;
    private final String slat ="sdsdlkskirenrenv23232!@#$#$#ffdf";



    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,5);
    }

    public Seckill getById(Long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(Long seckillId) {
        //优化点,缓存优化
        Seckill seckill = redisDao.getSeckill(seckillId);
        if(seckill==null){
             seckill = seckillDao.queryById(seckillId);
            if(seckill==null){
                return  new Exposer(false,seckillId);
            }else{
                redisDao.putSeckill(seckill);
            }
        }
        Date startTime = seckill.getStartTime() ;
        Date endTime   = seckill.getEndTime();
        Date nowTime   = new Date();
        if(nowTime.getTime()< startTime.getTime()||nowTime.getTime()>endTime.getTime()){
            return  new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime());
        }
        String md5 = getMD5(seckillId) ;
        return  new Exposer(true,md5,seckillId);
    }
    private  String getMD5(long seckillId){
        String base = seckillId+"/"+slat ;
        String md5  = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5 ;
    }
    @Transactional
    /**
     * 使用注解控制事务方法的有点
     * 1:开发团队达成一致约定,明确事务方法的编程行为
     * 2:保证事务的执行时间尽可能短,不要穿插其他的网络操作,RPC/HTTP请求或者剥离到方法外部
     * 3:不是所有的方法都需要事务,例如只有一条修改,或者只读操作不需要事务
     *
     *
     *
     */
    public SeckillExcuption excuteSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException, RepeatKillException, SeckillException {

        try {
            if (md5 == null || !md5.equals(getMD5(seckillId))) {
                throw new SeckillException("seckill data rewrite");
            }
            Date nowDate = new Date();
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if (insertCount <= 0) {
                throw new RepeatKillException("repeat  seckill");
            } else {
                int updateCount = seckillDao.redicueNumber(seckillId, nowDate);
                if (updateCount <= 0) {
                    //没有更新记录,秒杀结束
                    throw new SeckillCloseException("seckill is claosed");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExcuption(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }

            }

        }catch (SeckillCloseException e1){
            throw  e1 ;

        }catch (RepeatKillException e2){
            throw e2 ;
        }catch (Exception e) {
            //所有编译异常转化为运行时异常
            throw  new SeckillException("seckill inner error :" +e.getMessage());
        }

    }

    public SeckillExcuption excuteSeckillProcedure(long seckillId, long userPhone, String md5) {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        Date killTime = new Date();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("seckillId",seckillId);
        map.put("phone",userPhone);
        map.put("killTime",killTime);
        map.put("result",null);
        try {
            seckillDao.killByProcedure(map);
            Integer result = MapUtils.getInteger(map,"result",-2);
            if(result==1){
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
                return new SeckillExcuption(seckillId, SeckillStatEnum.SUCCESS,successKilled);
            }else{
                return new SeckillExcuption(seckillId, SeckillStatEnum.statOf(result));
            }
        } catch (Exception e) {
             logger.error(e.getMessage(),e);
            return new SeckillExcuption(seckillId, SeckillStatEnum.INNER_ERROR);
        }

    }
}
