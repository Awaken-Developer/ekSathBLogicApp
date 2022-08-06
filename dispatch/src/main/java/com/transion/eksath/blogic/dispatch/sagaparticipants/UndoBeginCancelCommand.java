package com.transion.eksath.blogic.dispatch.sagaparticipants;

public class UndoBeginCancelCommand extends DispatchCommand{

    public UndoBeginCancelCommand(long dispatchId){
        super(dispatchId);
    }
}
