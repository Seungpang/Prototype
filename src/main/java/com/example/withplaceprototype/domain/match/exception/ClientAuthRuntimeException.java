package com.example.withplaceprototype.domain.match.exception;

import com.example.withplaceprototype.global.common.error.ErrorCode;

public class ClientAuthRuntimeException extends RuntimeException{

    private ErrorCode errorCode;

    public ClientAuthRuntimeException(String message,ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ClientAuthRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
