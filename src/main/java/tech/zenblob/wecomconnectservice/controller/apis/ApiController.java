package tech.zenblob.wecomconnectservice.controller.apis;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.zenblob.wecomconnectservice.controller.service.weixin.WecomService;
import tech.zenblob.wecomconnectservice.pojo.BaseResponse;
import tech.zenblob.wecomconnectservice.pojo.WecomParam;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private WecomService wecomService;

    @GetMapping("/data")
    public String getData() {
        return "这是 Spring Boot API 返回的数据";
    }


    /**
     * 获取企业微信登录所需的相关参数
     */
    @GetMapping(value = "/loginParams")
    @ApiOperation(value = "获取企业微信登录所需的相关参数")
    public BaseResponse<WecomParam> getWecomLoginParams(String corpId) {
        try {
            WecomParam wecomParam = wecomService.getLoginParams(corpId);
            return BaseResponse.success(wecomParam);
        } catch (Exception e) {
            log.error("获取企业微信登录参数失败");
            e.printStackTrace();
            return BaseResponse.failed("获取企业微信登录参数失败");
        }
    }
}
