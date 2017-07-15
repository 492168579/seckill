package org.seckill.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yezhaoyi on 16/9/10.
 */
public interface PowerService {
    public void checkPower(HttpSession session ,HttpServletRequest request) ;
}
