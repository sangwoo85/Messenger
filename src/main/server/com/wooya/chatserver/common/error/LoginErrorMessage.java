package com.wooya.chatserver.common.error;

public enum LoginErrorMessage implements ChatServerError{

    LOGIN_INPUT_ERROR("001","ID 또는 비밀번호가 틀렸습니다.")

    ,USER_NOT_FINDING_ERROR("002","ID 또는 패스워드를 입력해 주세요.")

    ;

    final String code;

    final String message;

    LoginErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getErrorCode() {
        return this.code;
    }
}
