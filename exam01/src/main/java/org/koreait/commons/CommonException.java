package org.koreait.commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    private HttpStatus status;

    // 기본 (500에러)
    public CommonException(String message) {
        super(message);
        status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    // 응답 코드 직접 설정 가능
    public CommonException(String message, HttpStatus status) {

        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
