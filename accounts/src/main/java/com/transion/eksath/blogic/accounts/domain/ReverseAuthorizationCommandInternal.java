//edit

package com.transion.eksath.blogic.accounts.domain;

import io.eventuate.tram.commands.common.Command;
//common configuration files;


public class ReverseAuthorizationCommandInternal implements AccountCommand, Command{
    private String dispatcherId;
    private String dispatchId;
    
    public String getDispatchId(){
        return dispatchId;
    }

    public void setDispatchId(String dispatchId){
        this.dispatchId = dispatchId;
    }

    public ReverseAuthorizationCommandInternal(String dispatcherId, String dispatchId){
        this.dispatchId = dispatchId;
        this.dispatcherId = dispatcherId;
    }
    
    private ReverseAuthorizationCommandInternal(){}

    public String getDispatcherId(){
        return dispatcherId;
    }

    public void setDispatcherId(){
        this.dispatcherId = dispatcherId;
    }
}


///more logic based on reality.