package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 이렇게 생성해서 쓸 수도 있지만,
//    private final MemberService memberService = new MemberService();
    // spring 컨테이너에 등록을 하고 가져다 쓰는게 훨씬 좋다. 다른데서도 많이 가져다가 쓰기 때문에 매번 새로운 인스턴스를 만들 필요가 없다.

    // DI에는 필드 주입, setter주입, 생성자 주입 3가지 방법이 있는데, 의존관계가 실행중에 동적으로 변하는 경우는 거의 없기 때문에 생성자 주입을 권장한다.

    // 1. 필드 주입 // 별로 좋지 않은 방법. 중간에 바꿀 수 없음
//    @Autowired private final MemberService memberService;

    /*
    // 2. setter 주입 // 단점은 set--가 public으로 열려있어야 하는데 세팅 후 중간에 바뀔일이 없는데 굳이 그러다가 바뀌면 오류남.
    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
    */

    // 3. 생성자 주입 (가장 권장되는 방법)
    private final MemberService memberService;

    @Autowired // Controller생성 시 스프링빈에 등록되어 있는 memberService객체를 주입해준다. = DI(의존관계 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
