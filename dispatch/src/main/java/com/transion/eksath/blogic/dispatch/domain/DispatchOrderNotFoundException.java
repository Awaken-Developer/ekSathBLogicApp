package com.transion.eksath.blogic.dispatch.domain;

public class DispatchOrderNotFoundException extends RuntimeException{
    public DispatchOrderNotFoundException(Long dispatchId){
        super("Dispatch not found" + dispatchId);
    }
    
}
