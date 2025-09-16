package tech.zenblob.wecomconnectservice.utils.deserializer;


import tech.zenblob.wecomconnectservice.pojo.ApprovalCallbackDTO;

public class DetailListDeserializer extends ListOrObjectDeserializer<ApprovalCallbackDTO.Detail> {
    @Override
    protected Class<ApprovalCallbackDTO.Detail> getTypeClass() {
        return ApprovalCallbackDTO.Detail.class;
    }
}
