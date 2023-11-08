package org.koreait.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.entities.Member;
import org.koreait.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
public class JdbcEx1 {

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("회원 전체 조회")
    void test1() {
        List<Member> members = (List<Member>) repository.findAll();
        members.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("회원 조회")
    void test2() {
        Member member = repository.findById(7L).orElse(null);
        System.out.println(member);

        member.setUserNm("(수정)사용자004");
        member.setModDt(LocalDateTime.now());
        repository.save(member); // 추가 + 수정 => save로 가능
    }

    @Test
    @DisplayName("회원 추가")
    void test3() {
        //System.out.println(repository.getSequence());
        Member member = Member.builder()
                //.userNo(repository.getSequence())
                .userId("user10")
                .userPw("123456")
                .userNm("사용자10")
                .email("user10@test.org")
                .mobile("01011110000")
                .regDt(LocalDateTime.now())
                .build();
        
        repository.save(member);
    }

    @Test
    @DisplayName("쿼리메서드 회원 삭제")
    void test4() {
        repository.deleteById(7L);

    }

    @Test
    @DisplayName("쿼리메서드 회원id로 조회")
    void test5() {
        Member member = repository.findByUserId("user07");
        System.out.println(member);
    }

    @Test
    @DisplayName("쿼리메서드 Between, Pageable 인터페이스")
    void test6() {

        LocalDateTime edate = LocalDateTime.now();
        LocalDateTime sdate = edate.minusDays(7);

        //Pageable pageable = PageRequest.of(0,3);
        Pageable pageable = PageRequest.of(0,3, Sort.by(desc("regDt"), asc("userId")));

        List<Member> members = repository.findByRegDtBetween(sdate, edate, pageable);
        members.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("쿼리메서드 Containing, OrderBy")
    void test7() {

        List<Member> members = repository.findByUserNmContainingOrderByRegDtDesc("u");
        members.stream().forEach(System.out::println);
    }

    @Test
    @DisplayName("쿼리 직접 작성")
    void test8() {

        List<Member> members = repository.getMembers("%u%");
        members.stream().forEach(System.out::println);

    }

}
