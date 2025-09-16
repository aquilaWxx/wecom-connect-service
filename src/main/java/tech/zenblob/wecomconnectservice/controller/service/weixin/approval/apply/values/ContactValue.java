package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataValue;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactValue implements ApplyDataValue {
    private List<Member> members;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Member {
        private String userid;
        private String name;
    }
}
