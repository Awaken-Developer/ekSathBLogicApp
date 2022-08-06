package com.transion.eksath.blogic.accountsapi;

import io.eventuate.tram.commands.common.Command;
//common

public class ReverseAuthorizationCommand implements Command{
    private long dispatcherId;
    private Long dispatchId;

    private ReverseAuthorizationCommand(){}

    public ReverseAuthorizationCommand(long dispatcherId, Long dispatchId ){
        this.dispatcherId = dispatcherId;
        this.dispatchId = dispatchId;
    }

    public long getDispatcherId(){
        return dispatcherId;
    }

    public void setDispatcherId(long dispatcherId){
        this.dispatcherId = dispatcherId;
    }

    public Long getDispatchId(){
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId){
        this.dispatchId = dispatchId;
    }

    
}


