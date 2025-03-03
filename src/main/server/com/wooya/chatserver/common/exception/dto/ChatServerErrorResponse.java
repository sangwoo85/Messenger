package com.wooya.chatserver.common.exception.dto;

public record ChatServerErrorResponse(
        String code
        ,String message
) {
}
