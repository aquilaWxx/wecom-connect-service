package tech.zenblob.wecomconnectservice.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class PageController {

    @GetMapping("/hello")
    public String helloPage(Model model) {
        model.addAttribute("message", "欢迎来到Spring Boot页面！");
        return "hello";
    }

    @GetMapping("/wecom/login")
    public String wecomLoginPage() {
        return "wecom-login";
    }
}
