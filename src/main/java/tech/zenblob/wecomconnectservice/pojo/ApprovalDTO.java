package tech.zenblob.wecomconnectservice.pojo;

import cn.hutool.json.JSONArray;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 审批信息DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDTO {
    @ApiModelProperty("发起审批的用户ID(企业微信中的成员id)")
    private String creatorUserId;
    @ApiModelProperty("部门ID")
    private String deptId;
    @ApiModelProperty("节点类型:1->审批人 2->抄送人 3->办理人")
    private String type;
    @ApiModelProperty("多人审批方式:1->会签 2->或签 3->依次审批 ")
    private String apvRel;
    @ApiModelProperty("审批人 userid")
    private JSONArray userIds;
    @ApiModelProperty("抄送人信息")
    private List<CcDTO> ccInfo;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CcDTO {
        @ApiModelProperty("抄送人Id")
        private String ccUserId;

        @ApiModelProperty("抄送人姓名")
        private String ccUserName;
    }

}
