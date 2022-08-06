package com.transion.eksath.blogic.dispatch.sagaparticipants;

import io.eventuate.tram.commands.common.Command;

public class DispatchCommand implements Command{

    private long dispatchId;

    protected DispatchCommand(){}

    protected DispatchCommand(long dispatchid){
        this.dispatchId = dispatchId;
    }

    public long getDispatchId(){
        return dispatchId;
    }

    public void setDispatchId(long dispatchId){
        this.dispatchId = dispatchId;
    }
    
}
