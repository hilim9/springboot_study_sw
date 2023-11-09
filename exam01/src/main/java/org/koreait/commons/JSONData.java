package org.koreait.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JSONData<T> { // 공통으로 사용

    private HttpStatus status = HttpStatus.OK; // 응답 코드 (기본값 200)
    private boolean success = true ; // 요청 성공, 실패 여부

    @NonNull
    private T data;
    private String message; // 오류 메세지
}
