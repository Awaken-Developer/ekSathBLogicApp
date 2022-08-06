package com.transion.eksath.blogic.dispatch.sagas.cancelDispatch;

import com.transion.eksath.blogic.dispatch.sagaparticipants.BeginCancelCommand;
import com.transion.eksath.blogic.dispatch.sagaparticipants.UndoBeginCancelCommand;
import com.transion.eksath.blogic.dispatchorderapi.DispatchOrderChannels;
import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import javax.annotation.PostConstruct;
import org.springframework.util.Assert;



import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;

public class CancelDispatchSaga implements SimpleSaga<CancelDispatchSagaData> {

    
    private SagaDefinition<CancelDispatchSagaData> sagaDefinition;

   

    @PostConstruct
    public void initializeSagaDefinition(){
        sagaDefinition = step()
        .invokeParticipant(this::beginCancel)
        .withCompensation(this::undoBeginCancel)
        .step()
        .invokeParticipant(this::beginCancelTicket)
        .withCompensation(this::undoBeginCancelTicket)  
        .step()
        .invokeParticipant(this::reverseAuthorization)
        .step()
        .invokeParticipant(this::confirmTicketCancel)
        .step()
        .invokeParticipant(this::confirmDispatchCancel)
        .build();
  }

  @Override
  public SagaDefinition<CancelDispatchSagaData> getSagaDefinition() {
      Assert.notNull(sagaDefinition);
      return sagaDefinition;
  }

private CommandWithDestination beginCancel(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new BeginCancelCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination undoBeginCancel(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new UndoBeginCancelCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination beginCancelTicket(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new BeginCancelTicketCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination undoBeginCancelTicket(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new UndoBeginCancelTicketCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination reverseAuthorization(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new BeginCancelCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination confirmTicketCancel(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new ConfirmTicketCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

private CommandWithDestination confirmDispatchCancel(CancelDispatchSagaData canceldispatchsagadata1) {
    return send(new ConfirmDispatchCancelCommand(data.getDispatchId()))
            .to(DispatchOrderChannels.COMMAND_CHANNNEL)
            .build();
}

  
}
