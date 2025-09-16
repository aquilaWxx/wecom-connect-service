package tech.zenblob.wecomconnectservice.utils.deserializer;


import tech.zenblob.wecomconnectservice.pojo.ApprovalCallbackDTO;

public class CommentsListDeserializer extends ListOrObjectDeserializer<ApprovalCallbackDTO.Comment> {
    @Override
    protected Class<ApprovalCallbackDTO.Comment> getTypeClass() {
        return ApprovalCallbackDTO.Comment.class;
    }
}
