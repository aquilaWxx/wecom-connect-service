package tech.zenblob.wecomconnectservice.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Api(tags = "测试")
@RequestMapping(value = "test", produces = "application/json")
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }
}
