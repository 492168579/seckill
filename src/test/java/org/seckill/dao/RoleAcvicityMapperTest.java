package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.RoleAcvicity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/10/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class RoleAcvicityMapperTest {
    @Resource
    private RoleAcvicityMapper roleAcvicityMapper ;
    @Test
    public void selectByRoleId() throws Exception {
        List<RoleAcvicity> roleAcvicities = roleAcvicityMapper.selectbyRoleId(1);
        for (RoleAcvicity roleAcvicity :roleAcvicities){
            System.out.print(roleAcvicity.toString());
        }
    }

    @Test
    public void name() throws Exception {
        List<RoleAcvicity> roleAcvicities = roleAcvicityMapper.selectAll();
        for (RoleAcvicity roleAcvicity :roleAcvicities){
            System.out.print(roleAcvicity);
        }

    }
}