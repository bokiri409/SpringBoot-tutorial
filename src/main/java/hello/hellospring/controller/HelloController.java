package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // MVC중에 그 Model이다.
         model.addAttribute("data", "helloooooooo!");
         return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    // 이 방식을 쓸 일은 거의 없다.
    @GetMapping("hello-string")
    @ResponseBody // http의 body부분에 return값을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // string 이 아니고 데이터를 보낼 때
    @GetMapping("hello-api")
    @ResponseBody 
    public Hello helloApi(@RequestParam("name") String name) { // Hello 객체 만들어서 사용
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
