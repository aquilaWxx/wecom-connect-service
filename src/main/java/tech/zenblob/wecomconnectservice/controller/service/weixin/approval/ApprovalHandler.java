package tech.zenblob.wecomconnectservice.controller.service.weixin.approval;


import tech.zenblob.wecomconnectservice.pojo.ApprovalCallbackDTO;

/**
 * 企业微信审批回调处理接口。
 * <p>
 * 所有审批模板对应的处理逻辑类应实现该接口，
 * 用于接收和处理企业微信推送的审批回调数据。
 * </p>
 */
public interface ApprovalHandler {
    void handle(ApprovalCallbackDTO dto);
}
