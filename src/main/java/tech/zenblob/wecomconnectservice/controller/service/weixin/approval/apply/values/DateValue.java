package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateValue implements ApplyDataValue {
    private DateFormValue date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DateFormValue {
        /**
         * 时间展示类型：day-日期；hour-日期+时间 ，和对应模板控件属性一致
         */
        private String type;
        /**
         * 时间戳-字符串类型，在此填写日期/日期+时间控件的选择值，以此为准
         */
        private String s_timestamp;
    }
}
