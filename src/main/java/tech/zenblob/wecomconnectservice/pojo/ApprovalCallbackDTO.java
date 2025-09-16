package tech.zenblob.wecomconnectservice.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import tech.zenblob.wecomconnectservice.utils.deserializer.CommentsListDeserializer;
import tech.zenblob.wecomconnectservice.utils.deserializer.DetailListDeserializer;
import tech.zenblob.wecomconnectservice.utils.deserializer.SpRecordListDeserializer;

import java.util.List;

/**
 * 企业微信回调消息体
 */
@Data
public class ApprovalCallbackDTO {

    @JSONField(name = "ToUserName")
    private String toUserName;

    @JSONField(name = "FromUserName")
    private String fromUserName;

    @JSONField(name = "CreateTime")
    private String createTime;

    @JSONField(name = "MsgType")
    private String msgType;

    @JSONField(name = "Event")
    private String event;

    @JSONField(name = "AgentID")
    private String agentID;

    @JSONField(name = "ApprovalInfo")
    private ApprovalInfo approvalInfo;

    @Data
    public static class ApprovalInfo {
        @JSONField(name = "SpName")
        private String spName;

        @JSONField(name = "SpNo")
        private String spNo;

        @JSONField(name = "TemplateId")
        private String templateId;

        @JSONField(name = "SpStatus")
        private String spStatus;

        @JSONField(name = "ApplyTime")
        private Long applyTime;

        @JSONField(name = "Applyer")
        private Applyer applyer;

        @JSONField(name = "Notifyer")
        private List<String> notifyer;

        @JSONField(name = "SpRecord", deserializeUsing = SpRecordListDeserializer.class)
        private List<SpRecord> spRecord;

        @JSONField(name = "Comments", deserializeUsing = CommentsListDeserializer.class)
        private List<Comment> comments;

        @JSONField(name = "StatuChangeEvent")
        private String statuChangeEvent;
    }

    @Data
    public static class Applyer {
        @JSONField(name = "UserId")
        private String userId;

        @JSONField(name = "Party")
        private String party;
    }

    @Data
    public static class SpRecord {
        @JSONField(name = "SpStatus")
        private String spStatus;

        @JSONField(name = "ApproverAttr")
        private Integer approverAttr;

        @JSONField(name = "Details", deserializeUsing = DetailListDeserializer.class)
        private List<Detail> details;
    }

    @Data
    public static class Detail {
        @JSONField(name = "SpStatus")
        private String spStatus;

        @JSONField(name = "Speech")
        private String speech;

        @JSONField(name = "SpTime")
        private Long spTime;

        @JSONField(name = "UserId")
        private String userId;
    }

    @Data
    public static class Comment {
        @JSONField(name = "CommentUserInfo")
        private CommentUserInfo commentUserInfo;

        @JSONField(name = "CommentTime")
        private Long commentTime;

        @JSONField(name = "CommentContent")
        private String commentContent;
    }

    @Data
    public static class CommentUserInfo {
        @JSONField(name = "UserId")
        private String userId;
    }
}
