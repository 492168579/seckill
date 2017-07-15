package org.seckill.service;

import javax.servlet.http.HttpSession;

/**
 * Created by yezhaoyi on 16/8/20.
 */
public interface LoginService {
    public void Login (String adminAccount , String adminPsw , HttpSession session);

}
