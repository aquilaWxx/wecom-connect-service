package tech.zenblob.wecomconnectservice.controller.service.weixin.approval;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.zenblob.wecomconnectservice.controller.service.weixin.approval.apply.ApplyDataItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalSumitDTO {
    /**
     * 申请人userid，此审批申请将以此员工身份提交，申请人需在应用可见范围内
     */
    private String creator_userid;
    /**
     * 模板id。可在“获取审批申请详情”、“审批状态变化回调通知”中获得，也可在审批模板的模板编辑页面链接中获得。暂不支持通过接口提交[打卡补卡][调班]模板审批单。
     */
    private String template_id;
    /**
     * 审批人模式：0-通过接口指定审批人、抄送人（此时process参数必填）; 1-使用此模板在管理后台设置的审批流程(需要保证审批流程中没有“申请人自选”节点)，支持条件审批。默认为0
     */
    private Integer use_template_approver;
    /**
     * 提单者提单部门id，不填默认为主部门
     */
    private Integer choose_department;
    /**
     * 新版流程列表
     */
    private Process process;
    /**
     * 审批申请数据，可定义审批申请中各个控件的值，其中必填项必须有值，选填项可为空，数据结构同“获取审批申请详情”接口返回值中同名参数“apply_data”
     */
    private ApplyData apply_data;
    /**
     * 摘要信息，用于显示在审批通知卡片、审批列表的摘要信息，最多3行
     */
    private List<SummaryItem> summary_list;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Process {
        /**
         * 流程节点
         */
        private List<ProcessNode> node_list;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProcessNode {
        /**
         * 节点类型 1:审批人 2:抄送人 3:办理人
         */
        private Integer type;
        /**
         * 多人审批方式 1-会签；2-或签 3-依次审批
         */
        private Integer apv_rel;
        /**
         * 用户id
         */
        private List<String> userid;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ApplyData {
        /**
         * 审批申请详情，由多个表单控件及其内容组成，其中包含需要对控件赋值的信息
         */
        private List<ApplyDataItem> contents;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class SummaryItem {
        /**
         * 摘要行信息，用于定义某一行摘要显示的内容
         */
        private List<SummaryInfoItem> summary_info;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class SummaryInfoItem {
        /**
         * 摘要行显示文字，用于记录列表和消息通知的显示，不要超过20个字符
         */
        private String text;
        /**
         * 摘要行显示语言，中文：zh_CN（注意不是zh-CN），英文：en。
         */
        private String lang;
    }
}
