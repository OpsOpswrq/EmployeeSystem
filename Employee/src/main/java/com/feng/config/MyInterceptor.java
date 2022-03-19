package com.feng.config;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginSession = session.getAttribute("loginSession");
        if(loginSession==null){
            request.setAttribute("msg","你没有权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
