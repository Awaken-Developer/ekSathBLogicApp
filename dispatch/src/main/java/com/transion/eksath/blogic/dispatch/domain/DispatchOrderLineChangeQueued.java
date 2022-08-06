package com.transion.eksath.blogic.dispatch.domain;

import io.eventuate.tram.events.common.DomainEvent;

public class DispatchOrderLineChangeQueued implements DomainEvent{
    public DispatchOrderLineChangeQueued(String lineItemId /*yet to be explored*/, int newProfile){
        //edit and semantics.
    }
}
