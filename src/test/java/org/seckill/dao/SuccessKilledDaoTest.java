package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private  SuccessKilledDao successKilledDao ;





    @Test
    public void insertSuccessKilled() throws Exception {

        long suckillId  = 1005L ;
        long userPhone  = 18854808750L ;

        int  num = successKilledDao.insertSuccessKilled(suckillId,userPhone);
        System.out.print("num"+num);

    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long suckillId  = 1005L ;
        long userPhone  = 18854808750L ;
       SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(suckillId,userPhone);
        System.out.print(successKilled.toString()+successKilled.getSeckill().toString());

    }

}