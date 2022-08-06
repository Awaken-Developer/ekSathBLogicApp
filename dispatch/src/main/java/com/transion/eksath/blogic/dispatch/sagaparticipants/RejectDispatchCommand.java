package com.transion.eksath.blogic.dispatch.sagaparticipants;

public class RejectDispatchCommand  extends DispatchCommand {
    private RejectDispatchCommand(){}

    public RejectDispatchCommand(long dispatchId){
        super(dispatchId);
    }
    
}
