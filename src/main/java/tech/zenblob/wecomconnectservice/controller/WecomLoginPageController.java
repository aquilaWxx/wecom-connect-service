package tech.zenblob.wecomconnectservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WecomLoginPageController {

    @GetMapping("/wecom/login")
    public String loginPage() {
        return "wecom/login";
    }
}
