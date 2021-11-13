package com.example.withplaceprototype.global.common.error;

public enum ErrorCode {

    //User
    EMAIL_DUPLICATION(400, "U001", "Email is Duplication"),
    NOT_FOUND_USER(400, "U002", "User not found"),

    //common
    INVALID_INPUT_VALUE(400, "C001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    //Client kakao api 호출
    KAKAO_API_UNAUTHORIZED(401,"K001","카카오 오픈 API통신 중 인증 에러가 발생하였습니다."),
    KAKAO_API_BAD_REQUEST(400,"K002","잘못된 요청 구문, 또는 유효하지 않는 요청입니다."),
    KAKAO_API_ERROR(500,"K003","카카오 모든 API 통신 알 수 없는 에러가 발생하였습니다.")
    ;
    //NO_CONTENT("데이터가 없습니다.");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
