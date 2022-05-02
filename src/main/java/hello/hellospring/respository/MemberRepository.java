package hello.hellospring.respository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 회원 저장
    Member save(Member member);
    // 아이디로 회원찾기
    // null 처리 시 Optional로
    Optional<Member> findById(Long id);
    // 이름으로 회원찾기
    Optional<Member> findByName(String name);
    // 회원 리스트 전부
    List<Member> findAll();
}
