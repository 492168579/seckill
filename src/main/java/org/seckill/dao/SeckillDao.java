package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yezhaoyi on 16/6/11.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    public int redicueNumber(@Param("seckillId") Long seckillId ,@Param("killTime") Date killTime);
    /**
     * 根据Id查询秒杀对象
     * @param seckillId
     * @return
     */
    public Seckill queryById(long seckillId) ;
    /**
     * 根据偏移量查询秒杀接口
     * @param offset
     * @param limit
     * @return
     */
    public List<Seckill> queryAll(@Param("offset") int offset , @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String , Object> paramMap);
}
