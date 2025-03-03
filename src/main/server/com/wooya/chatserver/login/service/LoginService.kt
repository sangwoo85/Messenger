package com.wooya.chatserver.login.service

import com.wooya.chatserver.login.dto.LoginDto

interface LoginService {

    /**
     * @title 로그인 처리 관련 service
     * */
    fun login(loginDto: LoginDto);
}