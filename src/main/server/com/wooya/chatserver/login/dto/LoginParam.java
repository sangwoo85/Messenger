package com.wooya.chatserver.login.dto;

import com.wooya.chatserver.common.error.LoginErrorMessage;
import com.wooya.chatserver.common.exception.LoginErrorException;

import javax.security.auth.login.LoginException;

public record LoginParam(String userId, String password) {

    public LoginParam{
        if(userId == null || password == null) {
            throw new LoginErrorException(LoginErrorMessage.LOGIN_INPUT_ERROR);
        }
    }
}
