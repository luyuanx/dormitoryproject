package com.it.dormitory.framework.jwt;

import com.it.dormitory.entity.User;
import com.it.dormitory.framework.exception.MyException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(JWTUtil.token);
        //根据token获取user对象
        User user = JWTUtil.getUser(token);
        if(user==null){
            throw new  MyException("token超时或不合法");
        }
        String newToken = JWTUtil.sign(user);
        response.setHeader(JWTUtil.token,newToken);
        response.setHeader("Access-Control-Expose-Headers", JWTUtil.token);
        request.setAttribute("user",user);

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
