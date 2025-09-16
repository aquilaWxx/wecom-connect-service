package tech.zenblob.wecomconnectservice.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 企业微信登录配置。
 */
@Component
@ConfigurationProperties(prefix = "wecom.login")
public class WecomLoginProperties {

    private Map<String, AppLoginProperties> apps = new HashMap<>();

    public Map<String, AppLoginProperties> getApps() {
        return apps;
    }

    public void setApps(Map<String, AppLoginProperties> apps) {
        this.apps = apps;
    }

    public Optional<AppLoginProperties> findApp(String appId) {
        if (appId == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(apps.get(appId));
    }

    public static class AppLoginProperties {

        private String corpId;

        private String agentId;

        public String getCorpId() {
            return corpId;
        }

        public void setCorpId(String corpId) {
            this.corpId = corpId;
        }

        public String getAgentId() {
            return agentId;
        }

        public void setAgentId(String agentId) {
            this.agentId = agentId;
        }
    }
}
