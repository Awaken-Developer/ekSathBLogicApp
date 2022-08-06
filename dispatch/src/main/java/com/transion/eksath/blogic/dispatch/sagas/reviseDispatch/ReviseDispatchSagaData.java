package com.transion.eksath.blogic.dispatch.sagas.reviseDispatch;

import com.transion.eksath.blogic.dispatch.domain.DispatchRevision;

public class ReviseDispatchSagaData {

    public DispatchRevision getDispatchRevision() {
        return this.dispatchRevision;
    }

    public void setDispatchRevision(DispatchRevision dispatchRevision) {
        this.dispatchRevision = dispatchRevision;
    }

    public Long getDispatchId() {
        return this.dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public Long getExpectedVersion() {
        return this.expectedVersion;
    }

    public ReviseDispatchSagaData(DispatchRevision dispatchRevision, Long dispatchId, Long expectedVersion, long dispatcherId) {
        this.dispatchRevision = dispatchRevision;
        this.dispatchId = dispatchId;
        this.expectedVersion = expectedVersion;
        this.dispatcherId = dispatcherId;
    }

    public void setExpectedVersion(Long expectedVersion) {
        this.expectedVersion = expectedVersion;
    }

    public long getDispatcherId() {
        return this.dispatcherId;
    }

    public void setDispatcherId(long dispatcherId) {
        this.dispatcherId = dispatcherId;
    }
    private DispatchRevision dispatchRevision;
    private Long dispatchId;
    private Long expectedVersion;
    private long dispatcherId;



}
