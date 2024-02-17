package com.example.demo.interceptor;

import com.example.demo.exception.CustomizeException;
import com.example.demo.util.ResultCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientLoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截请求判断是否已经登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user")==null) {
            //用户未登录,抛出异常
            throw new CustomizeException(ResultCode.USER_NOT_LOGGED_IN);
        }
        //已登录，放行请求
        return true;
    }
}
