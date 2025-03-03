package com.wooya.chatserver.common.exception;

import com.wooya.chatserver.common.error.ChatServerError;

public class LoginErrorException extends ChatServerException {

    public LoginErrorException(ChatServerError chatServerError) {
        super(chatServerError);
    }
    public LoginErrorException(ChatServerError chatServerError, Throwable cause) {
        super(chatServerError, cause);
    }

}
