package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemberRepository;
import hello.hellospring.respository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService { // 단축키 : ctrl + shift + t (테스트 코드 바로 만들어짐)

    private final MemberRepository memberRepository;

    // Constructor 단축키 : alt + insert
    // repository를 외부에서 넣어준다.

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long signup(Member member) {
        // 중복 이름 안됨 // 단축키 ctrl + alt + v
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> { // 존재할 때
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
        */
        // Optional 없애고 바로 .ifPresent붙여줄 수 있다. // 단축키 : ctrl + alt + m (바로 메소드 뽑아내기)
        // 중복 회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> { // 존재할 때
                throw new IllegalStateException("이미 존재하는 이름입니다.");
            });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
