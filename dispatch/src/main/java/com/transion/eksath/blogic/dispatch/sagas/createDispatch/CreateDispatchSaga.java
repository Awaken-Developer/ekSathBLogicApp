package com.transion.eksath.blogic.dispatch.sagas.createDispatch;

import com.transion.eksath.blogic.dispatch.sagaparticipants.AccountsProxy;
import com.transion.eksath.blogic.dispatch.sagaparticipants.DispatchProxy;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//replacement for kit serve



public class CreateDispatchSaga implements SimpleSaga<CreateDispatchSagaData>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SagaDefinition<CreateDispatchSagaState> sagaDefinition;
    
    public CreateDispatchSaga(DispatchProxy dispatch, AccountsProxy accounts){
        this.sagaDefinition = 
                step()
                .withCompensation(dispatch.reject, CreateDispatchSagaState::makeRejectDispatchCommand)
                .step()
                .invokeParticipant(accounts.authorize, CreateDispatchSagaState::makeAuthorizeCommand)
                .step()
                .invokeParticipant(dispatch.approve, CreateDispatchSagaState::makeApproveDispatchCommand)
                .build();
    }

    @Override
    public SagaDefinition<CreateDispatchSagaData> getSagaDefinition() {
        return sagaDefinition;
    }
}
