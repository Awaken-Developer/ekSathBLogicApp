package com.transion.eksath.blogic.dispatch.sagaparticipants;

public class UndoBeginReviseDispatchCommand extends DispatchCommand {
    protected UndoBeginReviseDispatchCommand(){}

    public UndoBeginReviseDispatchCommand(long dispatchId){
        super(dispatchId);
    }
}
