package org.koreait.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Member {

    @Id // 기본키
    private long userNo; // user_no 오라클에서 자동 인식
    private String userId;

    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;
    private String mobile;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;
    private LocalDateTime modDt;


}
