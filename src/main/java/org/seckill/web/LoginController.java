package org.seckill.web;

import org.seckill.entity.Seckill;
import org.seckill.entity.User;
import org.seckill.exception.MessageException;
import org.seckill.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yezhaoyi on 16/9/5.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService ;
    @RequestMapping(value = "/in" ,method = RequestMethod.POST)
    public  String loginIn(String  adminAccount , String  adminPsw , HttpSession session ,Model model){

        try {
            loginService.Login(adminAccount,adminPsw,session);
            return  "redirect:/power/checkPower" ;
        } catch (MessageException e) {
            e.printStackTrace();
            model.addAttribute("message",e.getMessage()) ;
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("message","服务器异常请联系管理员!") ;
        }
        return  "index" ;
    }
    @RequestMapping(value = "/out" ,method = RequestMethod.GET)
    public  String loginOut(HttpSession session){
        //清除Session
        session.invalidate();
        return "redirect:/power/checkPower";
    }

}
