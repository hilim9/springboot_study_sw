package org.koreait.restcontrollers;

import org.koreait.commons.CommonException;
import org.koreait.commons.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.koreait.restcontrollers") // 설정한 경로의 모든 하위 파일 적용
public class CommonRestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONData<Object>> errorHandler(Exception e) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 (일반적인 에러코드)

        if (e instanceof CommonException) { //CommonException에서 정의한 코드만 가져옴
            CommonException commonException = (CommonException) e;
            status =  commonException.getStatus();
        }

        JSONData<Object> data = new JSONData<>();
        data.setSuccess(false);
        data.setStatus(status);
        data.setMessage(e.getMessage());

        return ResponseEntity.status(data.getStatus()).body(data);
    }
    
    
}
