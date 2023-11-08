package org.koreait.repositories;

import org.koreait.entities.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    
    // 쿼리 메서드
    // find + (엔티티 이름) + By + 변수이름
    // 이름이 너무 길어지는 단점이 있다
    // 복잡할 땐 직접 쿼리 입력하는 것도 방법

    Member findByUserId(String userId);

    List<Member> findByRegDtBetween(LocalDateTime sdate, LocalDateTime edate, Pageable pageable);

    List<Member> findByUserNmContainingOrderByRegDtDesc(String userNm);

    @Query("SELECT SEQ_MEMBER.nextval FROM DUAL")
    long getSequence();
    
    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE :word ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("word") String keyword);
                                // keyword -> word로 대입


}
