package com.transion.eksath.blogic.dispatch.sagas.cancelDispatch;

//common
public class CancelDispatchSagaData {

    public CancelDispatchSagaData() {
    }

    public CancelDispatchSagaData(Long dispatchId, String reverseRequestId, long dispatcherId) {
        this.dispatchId = dispatchId;
        this.reverseRequestId = reverseRequestId;
        this.dispatcherId = dispatcherId;
    }

    public Long getDispatchId() {
        return this.dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getReverseRequestId() {
        return this.reverseRequestId;
    }

    public void setReverseRequestId(String reverseRequestId) {
        this.reverseRequestId = reverseRequestId;
    }

    public long getDispatcherId() {
        return this.dispatcherId;
    }

    public void setDispatcherId(long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }

    

    private Long dispatchId;
    private String reverseRequestId;
    private long dispatcherId;

}
