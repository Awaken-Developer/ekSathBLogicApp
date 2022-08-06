package com.trasion.eksath.blogic.dispatchorderapi.web;

//common

import java.util.List;


public class ReviseDispatchOrderRequest {

    private List<RevisedDispatchOrderLine> reviseDispatchOrderLine;

    private ReviseDispatchOrderRequest(){}
   
    public ReviseDispatchOrderRequest(List<RevisedDispatchOrderLine> reviseDispatchOrderLine){
        this.reviseDispatchOrderLine = reviseDispatchOrderLine;
    }

    public List<RevisedDispatchOrderLine> getRevisedDispatchOrderLine(){
        return reviseDispatchOrderLine;
    }

    public void setRevisedDispatchOrderLine(List<ReviseDispatchOrderLine> revisedDispatchOrderLine){
        this.reviseDispatchOrderLine = revisedDispatchOrderLine;
    }

}
