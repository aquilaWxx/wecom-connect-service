package tech.zenblob.wecomconnectservice.utils.deserializer;


import tech.zenblob.wecomconnectservice.pojo.ApprovalCallbackDTO;

public class SpRecordListDeserializer extends ListOrObjectDeserializer<ApprovalCallbackDTO.SpRecord> {
    @Override
    protected Class<ApprovalCallbackDTO.SpRecord> getTypeClass() {
        return ApprovalCallbackDTO.SpRecord.class;
    }
}
