package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyValue implements ApplyDataValue {
    private String new_money;
}
