package com.example.withplaceprototype.domain.user.exception;

import com.example.withplaceprototype.global.common.error.ErrorCode;

public class UserDuplicatedEmailException extends RuntimeException {

    private ErrorCode errorCode;

    public UserDuplicatedEmailException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public UserDuplicatedEmailException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
