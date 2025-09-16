package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ApplyDataItem {
    /**
     * 控件类型：Text-文本；Textarea-多行文本；Number-数字；Money-金额；Date-日期/日期+时间；Selector-单选/多选；；Contact-成员/部门；Tips-说明文字；File-附件；Table-明细；Location-位置；RelatedApproval-关联审批单；Formula-公式；DateRange-时长；
     **/
    private ControlType control;
    /**
     * 控件id：控件的唯一id，可通过“获取审批模板详情”接口获取
     **/
    private String id;
    /**
     * 控件值 ，需在此为申请人在各个控件中填写内容不同控件有不同的赋值参数，具体说明详见附录。模板配置的控件属性为必填时，对应value值需要有值。 *&#47;
     **/
    private ApplyDataValue value;

    private ApplyDataItem(ControlType control, String id, ApplyDataValue value) {
        this.control = control;
        this.id = id;
        this.value = value;
    }

    // —— 静态工厂方法，调用时更加方便 —— //

    public static ApplyDataItem text(String id, String text) {
        return new ApplyDataItem(ControlType.Text, id, new TextValue(text));
    }

    public static ApplyDataItem textarea(String id, String text) {
        return new ApplyDataItem(ControlType.Textarea, id, new TextValue(text));
    }

    public static ApplyDataItem number(String id, long number) {
        return new ApplyDataItem(ControlType.Number, id, new NumberValue(String.valueOf(number)));
    }

    public static ApplyDataItem money(String id, BigDecimal amount) {
        ApplyDataValue applyDataValue;
        if (amount == null) {
            applyDataValue = new MoneyValue("无");
        } else {
            applyDataValue = new MoneyValue(amount.toString());
        }

        return new ApplyDataItem(ControlType.Money, id, applyDataValue);
    }

    public static ApplyDataItem date(String id, String type, long timestamp) {
        return new ApplyDataItem(ControlType.Date, id,
                new DateValue(new DateValue.DateFormValue(type, String.valueOf(timestamp))));
    }

    public static ApplyDataItem selector(String id, String type, List<String> keys) {
        List<SelectorValue.Option> opts = keys.stream()
                .map(SelectorValue.Option::new)
                .collect(Collectors.toList());
        return new ApplyDataItem(ControlType.Selector, id, new SelectorValue(type, opts));
    }

    public static ApplyDataItem contact(String id, List<ContactValue.Member> members) {
        return new ApplyDataItem(ControlType.Contact, id, new ContactValue(members));
    }

    public static ApplyDataItem table(String id, List<TableValue.Row> rows) {
        return new ApplyDataItem(ControlType.Table, id, new TableValue(rows));
    }

}
