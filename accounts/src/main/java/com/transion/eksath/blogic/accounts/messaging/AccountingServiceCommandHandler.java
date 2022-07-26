package com.transion.eksath.blogic.account.messaging;

import io.eventuate.sync.AggregateRepository;
import io.eventuate.tram.commands.consumer.CommandHandler;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import com.transion.eksath.blogic.accounts.domain.*;

//api imports

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.sagas.eventsourcingsupport.UpdatingOptionsBuilder.replyingTo;



public class AccountingServiceCommandHandler {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AggregateRepository<Account, AccountCommand> accountRepository;

    public CommandHandlers commandHandlers(){
        return SagaCommandHandlersBuiler.fromChannel("accounts")
        .onMessage(AuthorizeCommand.class, this::authorize)
        .onMessage(ReverseAuthorizationCommand.class, this::reverseAuthorization)
        .onMessage(ReviseAuthorizationCommand.class, this::reviseAuthorization)
        .build();
    }

    public void authorize(CommandMessage<AuthorizeCommand> commandMessage){
        AuthorizeCommand command = commandMessage.getCommand();

        accountRepository.update(Long.toString(command.getDispatcherId()),
            makeAuthorizeCommandInternal(command),
            replyingTo(commandMessage)
                    .catching(AccountDisabledException.class, () -> withFailure(new AccountDisabledReply()))
                    .build());
    }

    public void reverseAuthorization(CommandMessage<ReverseAuthorizationCommand> commandMessage){

        ReverseAuthorizationCommand command = commandMessage.getCommand();

        accountRepository.update(Long.toString(command.getDispatcherId()),
                makeReverseAuthorizeCommandInternal(command),
                replyingTo(commandMessage)
                .catching(AccountDisabledException.class, () -> withFailure(new AccountDisabledReply()))
                .build());
    }

    public void reviseAuthorization(CommandMessage<ReviseAuthorizationCommand> commandMessage){

        ReviseAuthorizationCommand command = commandMessage.getCommand();

        accountRepository.update(Long.toString(command.getDispatcherId()), 
                makeReviseAuthorizeCommandInternal(command),
                replyingTo(commandMessage)
                    .catching(AccountDisabledException.class, () -> withFailure(new AccountDisabledReply())),
                    .build());
    }

    private AuthorizeCommandInternal makeAuthorizeCommandInternal(AuthorizeCommand command){
        return new AuthorizeCommandInternal(Long.toString(command.getDispatcherId()), Long.toString(command.getDispatchId()));
    }

    private ReverseAuthorizationCommandInternal makeReverseAuthorizeCommandInternal(ReverseAuthorizationCommand command){
        return new ReverseAuthorizationCommandInternal(Long.toString(command.getDispatcherId()), Long.toString(command.getDispatchId()));
    }
    
    private ReviseAuthorizationCommandInternal makeReviseAuthorizeCommandInternal(ReviseAuthorization command){
        return new ReviseAuthorizationCommandInternal(Long.toString(command.getDispatcherId()), Long.toString(command.getDispatchId()));
    }

}
