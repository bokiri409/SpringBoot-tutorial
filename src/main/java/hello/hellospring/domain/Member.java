package hello.hellospring.domain;

public class Member {

    private Long id; // 시스템이 정하는 임의의 값(보통 시퀀스로 오르는 값으로 설정)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
