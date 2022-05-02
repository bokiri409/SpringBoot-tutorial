package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemberRepository;
import hello.hellospring.respository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
