package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by yezhaoyi on 16/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Autowired
    private  UserDao userDao ;


    @Test
    public void queryByuserName() throws Exception {
        User user = userDao.queryByuserName("492168579@qq.com");
        System.out.println(user.toString());

    }

}