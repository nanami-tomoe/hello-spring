package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 위에 커서 올리고 option + Enter 누르고 import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 노테이션
public class HelloController {

    // 웹 어플리케이션에서 slush hello 라고 들어오면 아래의 메소드를 호출
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // model은 MVC(Model View Controller)
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // hello-template 로 간다
    }

    @GetMapping("hello-string")
    @ResponseBody // 중요
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name) {
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
