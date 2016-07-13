package org.seckill.dao;
import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;
/**
 * Created by yezhaoyi on 16/6/11.
 */
public interface SuccessKilledDao {
    /**
     *插入购买明细,可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId , @Param("userPhone") long userPhone);

    /**
     * 根据Id查询succesKilled并携带秒杀对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId , @Param("userPhone") long userPhone);
}
