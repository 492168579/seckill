package org.seckill.service.impl;

import org.seckill.dao.AdminMapper;
import org.seckill.entity.Admin;
import org.seckill.exception.MessageException;
import org.seckill.service.LoginService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by yezhaoyi on 16/9/7.
 */
@Service
public class LoginServiceImpl implements LoginService{
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminMapper adminMapper ;


    public void Login(String adminAccount, String adminPsw,HttpSession session) {
        Integer iadminCode = Integer.valueOf(adminAccount);
        Admin admin = adminMapper.selectByPrimaryKey(iadminCode);
        if(admin==null){
            throw  new MessageException("对不起,该用户不存在!");
        }
        if(!admin.getAdminPsw().equals(adminPsw)){
            throw  new MessageException("对不起,密码错误!");
        }
        session.setAttribute("admin",admin);

    }
}
