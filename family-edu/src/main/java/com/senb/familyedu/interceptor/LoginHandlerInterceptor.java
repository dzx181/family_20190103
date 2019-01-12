package com.senb.familyedu.interceptor;

import com.senb.familyedu.entity.EduUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        EduUser user = (EduUser) request.getSession().getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}