package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 위에 커서 올리고 option + Enter 누르고 import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
