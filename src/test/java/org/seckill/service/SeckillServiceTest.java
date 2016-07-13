package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcuption;
import org.seckill.entity.Seckill;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService ;
    @Test
    public void getSeckillList() throws Exception {
       List<Seckill> seckills = seckillService.getSeckillList();
       logger.info("list={}",seckills);


    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1005L);
        logger.info("seckill :"+ seckill);


    }

    @Test
    public void exportSeckillLogic() throws Exception {
           Exposer exposer  = seckillService.exportSeckillUrl(1005L);
            if(exposer.isExposed()){
                logger.info("export{}:"+exposer);
                SeckillExcuption seckillExcuption = seckillService.excuteSeckill(exposer.getSeckillId(),18854808751L,exposer.getMd5());
                logger.info("Secill:"+seckillExcuption);

            }
    }

    @Test
    public void excuteSeckill() throws Exception {

    }

}