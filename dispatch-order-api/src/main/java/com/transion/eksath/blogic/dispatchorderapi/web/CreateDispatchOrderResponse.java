package com.transion.eksath.blogic.dispatchorderapi.web;


public class CreateDispatchOrderResponse {

    private long dispatchOrderId;

    public long getDispatchOrderId(){
        return dispatchOrderId;
    }

    public void setDispatchOrderId(long dispatchOrderId){
        this.dispatchOrderId = dispatchOrderId;
    }

    private CreateDispatchOrderResponse(){}

    public CreateDispatchOrderResponse(long dispatchOrderId){
        this.dispatchOrderId = dispatchOrderId;
    }
}
