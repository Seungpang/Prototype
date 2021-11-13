package com.example.withplaceprototype.domain.match.exception;

import com.example.withplaceprototype.global.common.error.ErrorCode;

public class ClientBadRequestRuntimeException extends RuntimeException {

    private ErrorCode errorCode;

    public ClientBadRequestRuntimeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ClientBadRequestRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
