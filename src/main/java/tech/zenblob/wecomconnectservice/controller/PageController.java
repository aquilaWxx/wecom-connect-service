package tech.zenblob.wecomconnectservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/hello")
    public String helloPage(Model model) {
        model.addAttribute("message", "欢迎来到Spring Boot页面！");
        return "hello"; // 对应 resources/templates/hello.html
    }
}
