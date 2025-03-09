package com.wooya.chatserver.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpUtil {

    /**
     * @title 현재 로그인한 사용자 ID HttpSession에서 로그인 사용자 ID를 가져와 반환해 준다..
     * */
    public static String getLoginId(){
        return (String)getSession().getAttribute("userId");
    }
    public static HttpSession getSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

}
