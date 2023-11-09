package org.koreait.commons;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CommonException {
    public BadRequestException(String message) {

        super(message, HttpStatus.BAD_REQUEST); // 400에러 - 잘못된 요청
    }
}
