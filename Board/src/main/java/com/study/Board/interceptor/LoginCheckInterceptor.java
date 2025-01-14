package com.study.Board.interceptor;

import com.study.Board.domain.member.MemberResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MemberResponse member=(MemberResponse)session.getAttribute("loginMember");

        if (member == null|| member.getDeleteYn()) {
            response.sendRedirect("/login.do");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
