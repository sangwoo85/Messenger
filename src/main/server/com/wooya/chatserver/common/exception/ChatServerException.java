package com.wooya.chatserver.common.exception;

import com.wooya.chatserver.common.error.ChatServerError;

/**
 * @title ChatServer 프로젝트에 기본이 되는 Exception
 * */
public class ChatServerException extends RuntimeException {

    private ChatServerError chatServerError;

    public ChatServerException(Throwable cause) {
        super(cause);
    }

    public ChatServerException(ChatServerError error) {
        super(error.getMessage());
        this.chatServerError = error;
    }
    public ChatServerException(ChatServerError chatServerError,Throwable cause) {
        super(cause);
        this.chatServerError = chatServerError;
    }

    /**
     * @title ChatServer Error 메시지 사용시 반환 해주는 message
     * */
    public String getErrorMessage(){
        return this.chatServerError.getMessage();
    }

    /**
     * @title ChatServer Error 사용시 반환 되는 코드
     * */
    public String getErrorCode(){
        return this.chatServerError.getErrorCode();
    }
}
