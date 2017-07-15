package org.seckill.interceptor;

import org.seckill.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yezhaoyi on 16/10/9.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if(url.indexOf("login")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");

        if(admin != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("index.jsp").forward(request, response);

        return false;
    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     *  Handler执行完成之后调用这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
