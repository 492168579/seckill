package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.AdminRole;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class AdminRoleMapperTest {
    @Resource
    private AdminRoleMapper adminRoleMapper ;
    @Test
    public void selectByAdminCode() throws Exception {
        List<AdminRole> adminRoles = adminRoleMapper.selectByAdminCode(1010001);
        for(AdminRole adminRole :adminRoles){
            System.out.print(adminRole.getAdminCode());
            System.out.print(adminRole.getRoleConfig().getRoleName());

        }
    }

}