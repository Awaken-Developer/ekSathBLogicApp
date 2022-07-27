package com.transion.eksath.blogic.dispatch.domain;

public class NotAvailableException extends RuntimeException{
    public NotAvailableException(String workerId){
        super("Person is not available" + workerId);
    }
}