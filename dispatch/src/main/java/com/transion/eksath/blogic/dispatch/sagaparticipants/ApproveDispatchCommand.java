package com.transion.eksath.blogic.dispatch.sagaparticipants;

public class ApproveDispatchCommand extends DispatchCommand {

    private ApproveDispatchCommand(){

    }

    public ApproveDispatchCommand(long dispatchId){
        super(dispatchId);
    }
    
}

