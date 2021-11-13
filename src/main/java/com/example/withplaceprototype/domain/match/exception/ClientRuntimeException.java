package com.example.withplaceprototype.domain.match.exception;


import com.example.withplaceprototype.global.common.error.ErrorCode;

public class ClientRuntimeException extends RuntimeException {

    private ErrorCode errorCode;

    public ClientRuntimeException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ClientRuntimeException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}