package org.seckill.web;

import org.seckill.entity.Admin;
import org.seckill.service.LoginService;
import org.seckill.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yezhaoyi on 16/9/10.
 */
@Controller
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService ;
    @RequestMapping(value = "/checkPower", method = RequestMethod.GET)
    public String checkPower(HttpSession session,HttpServletRequest request) {
        powerService.checkPower(session ,request);
        return  "/index" ;
    }
}
