package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataValue;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectorValue implements ApplyDataValue {
    private String type;        // "single" 或 "multi"
    private List<Option> options;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Option {
        private String key;
    }
}
