package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现类
    @Resource
    private SeckillDao seckillDao ;
    @Test
    public void redicueNumber() throws Exception {
        Date date = new Date();
        seckillDao.redicueNumber(1005L,date);
    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill =  seckillDao.queryById(1005);
        System.out.println(seckill.toString());
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills){
            System.out.print(seckill.toString());
        }
    }

}