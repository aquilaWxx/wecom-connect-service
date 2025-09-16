package tech.zenblob.wecomconnectservice.controller.service.weixin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.zenblob.wecomconnectservice.config.WecomsProperties;
import tech.zenblob.wecomconnectservice.pojo.WecomParam;


/**
 * 企业微信服务类，负责企业微信用户身份验证、注册以及登录相关功能。
 *
 * @author ZacharyFung
 * {@code @date} 26/03/2025 17:49
 */

@Service
public class WecomService {

    @Autowired
    private WecomsProperties wecomsProperties;

    public WecomParam getLoginParams() {
        WecomsProperties.Wecom wecom = wecomsProperties.getList().stream().findFirst().orElse(null);
        if (wecom == null) {
            return null;
        }

        WecomParam wecomParam = new WecomParam();
        wecomParam.setAgentId(wecom.getAgent_id());
        wecomParam.setCorpId(wecom.getCorp_id());
        wecomParam.setRedirectUrl(wecom.getRedirect_url());
        return wecomParam;
    }
}
