package com.transion.eksath.blogic.dispatchorderapi.web;

//common

import java.time.LocalDateTime;
import java.util.List;


public class CreateDispatchOrderRequest {

    private long dispatcherId;
    private long workerId;
    private LocalDateTime deliveryTime;
    private List<DispatchOrderLine> dispatchOrderLine;
    // private Address address;

    public CreateDispatchOrderRequest(long dispatcherId,ong workerId)
}
