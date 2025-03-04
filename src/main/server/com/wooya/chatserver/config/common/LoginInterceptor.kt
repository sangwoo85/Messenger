package com.wooya.chatserver.config.common

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class LoginInterceptor : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val session = request.getSession(true);
        if (session === null || session.getAttribute(("userId")) === null) {
            response.sendRedirect("/")
            return false;
        }
        return true;
    }
}