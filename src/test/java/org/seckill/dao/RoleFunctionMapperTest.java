package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/10/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class RoleFunctionMapperTest {
    @Resource
    private  RoleAcvicityMapper roleAcvicityMapper ;
    @Test
    public void selectByRoleId() throws Exception {
        Integer i = 1;
        roleAcvicityMapper.selectByPrimaryKey(i);

    }

}