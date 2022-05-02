package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.respository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();

    // 새 객체를 생성하는 것은 엄밀히 따지면 다른 repository를 테스트 하고 있는 것을 의미한다.
    // 그래서 외부에서 주입하면 같은 repository를 사용하도록 할 수 있다. => DI
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach // 메소드 동작하기 전에 repository 넣어준다.
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository(); // repository를 만들고
        memberService = new MemberService(memberRepository); // memberService에 넣어준다.
    }


    @AfterEach // 메소드가 실행이 끝날 때 마다 이 동작을 수행함(콜백)
    public void afterEach() {
        memberRepository.clearStore(); // 각 메소드 테스트 끝날 때 마다 저장소 clear
    }

    @Test
    void signup회원가입() { // 테스트 코드는 한글로 적어도 된다.
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.signup(member); // 검증하려는 것은 signup // 리턴값이 저장하려는 아이디

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 중복 회원이 걸러지는 것 테스트
    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.signup(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.signup(member2));// , 이후 일이 발생했을 때 예외가 발생해야 한다.

        // 메세지 검증
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
/*
        // 1. 예외 try-catch문으로 잡는 방법
        try {
            memberService.signup(member2);
            fail("예외가 발생해야 한다.");
        }catch (IllegalStateException e) {
            // 성공
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
        }
         */

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}