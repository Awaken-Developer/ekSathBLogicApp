package com.transion.eksath.blogic.dispatch.domain;

//common

public class DispatchOrderRevised {
    
    private final DispatchOrderRevision dispatchOrderRevision;
    //private final Money currentOrderTotal;
    //private final Money newOrderTotal;

    public DispatchOrderRevision getDispatchOrderRevision(){
        return dispatchOrderRevision;
    }

    //getters for money

    public DispatchOrderRevised(DispatchOrderRevision dispatchOrderRevision/*Money currentOrderTotal, Money newOrderTotal*/){
        this.dispatchOrderRevision = dispatchOrderRevision;
        //this.currentOrderTotal = currentOrderTotal;
        //this.newOrderTotal = newOrderTotal;
    }
}
