package tech.zenblob.wecomconnectservice.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.zenblob.wecomconnectservice.config.WecomLoginProperties;
import tech.zenblob.wecomconnectservice.controller.vo.WecomLoginConfigResponse;

@RestController
@RequestMapping(value = "/wecom/login", produces = MediaType.APPLICATION_JSON_VALUE)
public class WecomLoginConfigController {

    private final WecomLoginProperties wecomLoginProperties;

    public WecomLoginConfigController(WecomLoginProperties wecomLoginProperties) {
        this.wecomLoginProperties = wecomLoginProperties;
    }

    @GetMapping("/config")
    public ResponseEntity<WecomLoginConfigResponse> getLoginConfig(@RequestParam("appid") String appId) {
        Optional<WecomLoginProperties.AppLoginProperties> appLoginProperties = wecomLoginProperties.findApp(appId);
        if (!appLoginProperties.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        WecomLoginProperties.AppLoginProperties properties = appLoginProperties.get();
        WecomLoginConfigResponse response = new WecomLoginConfigResponse();
        response.setCorpId(properties.getCorpId());
        response.setAgentId(properties.getAgentId());
        return ResponseEntity.ok(response);
    }
}
