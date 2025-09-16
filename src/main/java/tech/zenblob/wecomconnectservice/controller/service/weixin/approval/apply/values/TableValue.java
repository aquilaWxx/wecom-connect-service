package tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.values;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataItem;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataValue;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableValue implements ApplyDataValue {
    /**
     * 明细内容，一个 Table 可以有多行（children）
     */
    private List<Row> children;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Row {
        /**
         * 某一行所有子控件，直接复用 ApplyDataItem，保持与普通控件一致的数据结构
         */
        private List<ApplyDataItem> list;
    }

    public static class TableRows {
        /**
         * 通过可变参数快速构造一行
         */
        public static Row of(ApplyDataItem... items) {
            return new Row(Arrays.asList(items));
        }
    }
}
