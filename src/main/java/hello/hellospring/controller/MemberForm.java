package hello.hellospring.controller;

public class MemberForm { // 웹 등록 화면에서 데이터를 전달받을 폼 객체
    private String name;

    public String getName() {
        return name;
    }

    // private이므로 setName을 이용하여 spring이 넣어준다.
    public void setName(String name) {
        this.name = name;
    }
}
