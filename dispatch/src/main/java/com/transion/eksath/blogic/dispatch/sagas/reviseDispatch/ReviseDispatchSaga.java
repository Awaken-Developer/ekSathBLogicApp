package com.transion.eksath.blogic.dispatch.sagas.reviseDispatch;

import io.eventuate.tram.commands.consumer.CommandWithDestination;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;
import com.transion.eksath.blogic.accountsapi.AccountsChannel;
import com.transion.eksath.blogic.dispatchorderapi.DispatchChannel;
import com.transion.eksath.blogic.sagaparticipants.BeginReviseDispatchCommand;
import com.transion.eksath.blogic.sagaparticipants.BeginReviseDispatchChannel;
import com.transion.eksath.blogic.sagaparticipants.UndoBeginReviseDispatchCommand;
//kit
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

import static io.eventuate.tram.commands.consumer.CommandWithDestinationBuilder.send;


public class ReviseDispatchSaga implements SimpleSaga<ReviseDispatchSagaData> {
    

    private Logger logger = LoggerFactory.getLogger(getClass());

    private SagaDefinition<ReviseDispatchSagaData> sagaDefinition;

    @PostConstruct
    public void initializaSagaDefinition(){
        sagaDefinition = step()
        .invokeParticipants(this::beginReviseDispatch)
        .onReply(BeginReviseDispatchReply.class, this::handleBeginReviseDispatchReply)
        .withCompensation(this::undoBeginReviseDispatch)
        .step()
        .invokeParticipants(this::beginReviseTicket)
        .withCompensation(this::undoBeginReviseTicket)
        .step()
        .invokeParticipants(this::reviseAuthorization)
        .step()
        .invokeParticipants(this::confirmTicketRevision)
        .step()
        .invokeParticipants(this::confirmTicketRevision)
        .step()
        .invokeParticipants(this::confirmDispatchRevision)
        .build()
    }

    private void handleBeginReviseDispatchReply(ReplyDispatchSagaData data, BeginReviseDispatchReply reply){
        logger.info("f{}", r)//edit 
        //edit rigorously
    }

     @Override 

    public SagaDefinition<ReviseDispatchSagaData> getSagaDefinition(){
        return sagaDefinition;
    }

    private CommandWithDestination confirmDispatchRevision(ReviseDispatchSagaData data){
        return send(new ConfirmReviseDispatchCommand(data.getDispatchId(), data.getDispatchRevision()))
        .to(DispatchChannels.COMMAND_CHANNEL)
        .build();
    }

    private CommandWithDestination confirmTicketRevision(ReviseDispatchSagaData data){
      //edit kit
        return send(new ConfirmReviseTicketCommand(data.getRestaurantId(), data.getDispatchId(), data.getDispatchRevision().getRevisedDispatchLine()))
        
    }

    private CommandWithDestination reviseAuthorization(ReviseDispatchSagaData data){
        return send(new ReviseAuthorization(data.getDispatcherId(), data.getDispatchId()))
        .to(AccountsChannels.accountsChannel)
        .build()
    }

    private CommandWithDestination undoBeginReviseTicket(ReviseDispatchSagaData data){
        return send(new UndoBeginReviseTocletCommand(data.get))//edit
    }

    //ticket participants should be added and edited

    private CommandWithDestination undoBeginReviseDispatch(ReviseDispatchSagaData data){
        return send(new UndoBeginReviseDispatchCommand(data.getDispatchId()))
        .to(DispatchChannels.COMMAND_CHANNEL)
        .build();
    }

    private CommandWithDestination beginReviseDispatch(ReviseDispatchSagaData data){
        return send(new BeginReviseDispatchCommand(data.getDispatchId(), data.getDispatchRevision()))
        .to(DispatchChannels.COMMAND_CHANNEL)
        .build();;
    }


}
