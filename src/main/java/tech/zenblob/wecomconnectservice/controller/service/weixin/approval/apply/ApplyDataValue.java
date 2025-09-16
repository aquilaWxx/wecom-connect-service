package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values.*;

/**
 * 所有控件 value 的基接口，使用 Jackson 多态反序列化
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "controlType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextValue.class, name = "Text"),
        @JsonSubTypes.Type(value = TextValue.class, name = "Textarea"),
        @JsonSubTypes.Type(value = NumberValue.class, name = "Number"),
        @JsonSubTypes.Type(value = MoneyValue.class, name = "Money"),
        @JsonSubTypes.Type(value = DateValue.class, name = "Date"),
        @JsonSubTypes.Type(value = SelectorValue.class, name = "Selector"),
        @JsonSubTypes.Type(value = ContactValue.class, name = "Contact"),
        @JsonSubTypes.Type(value = TableValue.class, name = "Table")
})
public interface ApplyDataValue {
}


