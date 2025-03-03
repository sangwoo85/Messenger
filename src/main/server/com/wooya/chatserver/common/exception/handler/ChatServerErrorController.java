package com.wooya.chatserver.common.exception.handler;

import com.wooya.chatserver.common.error.ChatServerError;
import com.wooya.chatserver.common.exception.ChatServerException;
import com.wooya.chatserver.common.exception.dto.ChatServerErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ChatServerErrorController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ChatServerException.class)
    public ResponseEntity<ChatServerErrorResponse> handleChatServerException(ChatServerException e){
        LOGGER.error("error", e);
        LOGGER.info("error Message [ {} ]" ,e.getErrorMessage());
        ChatServerErrorResponse responseMessage =  new ChatServerErrorResponse(e.getErrorCode(),e.getErrorMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMessage);
    }

}
