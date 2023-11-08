package org.koreait.restcontrollers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 형식으로 응답
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
public class ApiMemberController {

    private final MemberRepository repository;

    @GetMapping("/{userId}")
    public Member info(@PathVariable String userId) {
        Member member = repository.findByUserId(userId);

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = (List<Member>) repository.findAll();
        return members;
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요"; // 문자열은 그대로 출력 
    }
    
    @GetMapping("/test")
    public void test() {
        log.info("테스트");
    }


    public void login(RequestLogin form) {

        log.info(form.toString());
    }
}
