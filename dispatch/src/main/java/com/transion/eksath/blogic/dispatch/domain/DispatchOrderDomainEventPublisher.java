package com.transion.eksath.blogic.dispatch.domain;

import com.transion.eksath.blogic.dispatchorderapi.events.DispatchOrderDomainEvent;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

public class DispatchOrderDomainEventPublisher extends AbstractAggregateDomainEventPublisher<DispatchOrder, DispatchOrderDomainEvent>{

    public DispatchOrderDomainEventPublisher(DomainEventPublisher eventPublisher){
        super(eventPublisher, DispatchOrder.class, DispatchOrder::getId);
    }
    
}
