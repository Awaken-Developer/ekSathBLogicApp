package com.transion.eksath.blogic.dispatch.sagaparticipants;

public class ConfirmCancelDispatchCommand extend DispatchCommand{

    private ConfirmCancelDispatchCommand(){}

    public ConfirmCancelDispatchCommand(long dispatchId){
        super(dispatchId);
    }
}
