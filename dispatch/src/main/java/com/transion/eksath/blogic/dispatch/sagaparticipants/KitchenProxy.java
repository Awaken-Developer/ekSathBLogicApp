package com.transion.eksath.blogic.dispatch.sagaparticipants;

import com.transion.eksath.blogic.dispatchorderapi.DispatchOrderChannels;
import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;


public class KitchenProxy {
    
    public final CommandEndpoint<RejectDispatchCommand> reject = CommandEndpointBuilder
    .forCommand(RejectDispatchCommand.class)
    .withChannel(DispatchOrderChannels.COMMAND_CHANNNEL)
    .withReply(Success.class)
    .build();

    public final CommandEndpoint<ApproveDispatchCommand> approve = CommandEndpointBuilder
    .forCommand(ApproveDispatchCommand.class)
    .withChannel(DispatchOrderChannels.COMMAND_CHANNEL)
    .build();
}