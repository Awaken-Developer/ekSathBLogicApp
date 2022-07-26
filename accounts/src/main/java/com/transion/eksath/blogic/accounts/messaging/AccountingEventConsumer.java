//edit
package com.transion.eksath.blogic.accounts.messaging;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandler;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import com.transion.eksath.blogic.accouts.domain.AccountingService;
// profiles and consumers do it later
import org.springframework.beans.factory.annotation.Autowired;


public class AccountingEventConsumer {

    @Autowired
    private AccountingService accountingService;

    public DomainEventHandler domainEventHandlers(){
        return DomainEventHandlersBuilder.forAggregateType("com.transion.eksath.blogic.consumer.domain.Consumer")
        .onEvent(ConsumerCreated.class, this::createAccount) // TODO this is hack to get the correct package
        .build();
    }

    private void createAccount(DomainEventEnvelope<ConsumerCreated> dee){
        accountingService.create(dee.getAggregateId());
    }
    
}
