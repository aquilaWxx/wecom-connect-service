package tech.zenblob.wecomconnectservice.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "企业微信参数实体")
public class WecomParam {

    @ApiModelProperty(value = "企业微信应用ID")
    private String agentId;

    @ApiModelProperty(value = "企业微信corpId")
    private String corpId;

    @ApiModelProperty(value = "企业微信登录成功回调地址")
    private String redirectUrl;
}
