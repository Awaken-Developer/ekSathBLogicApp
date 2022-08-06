package com.transion.eksath.blogic.dispatch.domain;

import com.transion.eksath.blogic.dispatchorderapi.events.*;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import java.util.List;
import javax.persistence.*;

//common




import static com.transion.eksath.blogic.dispatchorderapi.events.DispatchOrderState.APPROVED;
import static com.transion.eksath.blogic.dispatchorderapi.events.DispatchOrderState.APPROVAL_PENDING;
import static com.transion.eksath.blogic.dispatchorderapi.events.DispatchOrderState.REJECTED;
import static com.transion.eksath.blogic.dispatchorderapi.events.DispatchOrderState.REVISION_PENDING;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Entity
@Table(name = "dispatchOrders")
@Access(AccessType.FIELD)
public class DispatchOrder {//edit
// org in argument missing
    /*public static ResultWithDomainEvents<DispatchOrder, DispatchOrderDomainEvent>
    createOrder(long dispatcherId, DispatchDeliveryInformation dispatchDeliveryInformation, List<DispatchOrderLine> dispatchOrderLines){
        DispatchOrder dispatchOrder = new DispatchOrder(dispatcherId, dispatchDeliveryInformation, dispatchOrderLines);
        List<DispatchOrderDomainEvent> events = singletonList(new DispatchOrderCreatedEvent(new DispatchOrderDetails(dispatcherId, dispatchOrderLines  dispatchOrder.getOrderTotal()), dispatchDeliveryInformation.g));*/
    
    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    private DispatchOrderState state;

    private Long dispatcherId;
    // org Id 

    @Embedded 
    private DispatchOrderLine dispatchOrderLines;
    
    @Embedded 
    private DispatchDeliveryInformation dispatchDeliveryInformation;

    // other attributes to be added

    private DispatchOrder(){
    
    }

    public DispatchOrder(long dispatcherId, DispatchDeliveryInformation dispatchDeliveryInformation, List<DispatchOrderLine> dispatchOrderLines){
        this.dispatcherId = dispatcherId;
         this.dispatchDeliveryInformation = dispatchDeliveryInformation;
         this.dispatchOrderLine = new DispatchOrderLine(dispatchOrderLines);
         this.state = APPROVAL_PENDING;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
this.id = id;
    }

    public List<DispatchOrderDomainEvent> cancel(){
        switch(state){
            case APPROVED:
                this.state = DispatchOrderState.CANCEL_PENDING;
                return emptyList();
            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public List<DispatchOrderDomainEvent> undoPendingCancel(){
        switch(state){
            case CANCEL_PENDING:
                this.state = DispatchOrderState.APPROVED;
                return emptyList();
            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public List<DispatchOrderDomainEvent> noteCancelled(){
        switch(state){
            case CANCEL_PENDING:
                this.state = DispatchOrderState.CANCELLED;
                return singletonList(new DispatchOrderCancelled());
            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public List<DispatchOrderDomainEvent> noteApproved(){
        switch(state){
            case APPROVAL_PENDING:
                this.state = APPROVED;
                return singletonList(new DispatchOrderAuthorized());
            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public List<DispatchOrderDomainEvent> noteRejected(){
        switch(state){
            case APPROVAL_PENDING:
                this.state = REJECTED;
                return singletonList(new DispatchOrderRejected());
            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public List<DispatchOrderDomainEvent> noteReversingAuthorization(){
        return null;
    }

    //edit whole

    public ResultWithDomainEvents<DispatchLineQuantityChange, DispatchOrderDomainEvent> revise(DispatchOrderRevision dispatchOrderRevision){
        switch(state){

            case APPROVED:
                DispatchineQuantityChange change = dispatchOrderLines.lineItemQuantityChange(dispatchOrderRevision);
                if(change.newDispatchOrderTotal.isGreaterThanOrEqual(dispatchOrderMinimum)){
                    throw new DispatchOrderMinimumNotMetException();
                }

                this.state = REVISION_PENDING;
                return new ResultWithDomainEvents<>(change, singletonList(new DispatchOrderRevisionProposed(DispatchOrderRevision, change.currentDispatchOrderTotal, change.newDispatchOrderTotal)));
            
            default:
                throw new UnsupportedStateTransitionException(state);
        
        }
    }

    public List<DispatchOrderDomainEvent> rejectRevision(){
        switch(state){
            case REVISION_PENDING:
            this.state = APPROVED;
            return emptyList();
        default:
        throw new UnsupportedStateTransitionException(state);

        }
    }

    public List<DispatchOrderDomainEvent> confirmRevision(DispatchOrderRevision dispatchOrderRevision){
        switch(state){
            case REVISION_PENDING:
            DispatchLineQuantityChange dlqc = dispatchOrderLine.dispatchLineQuantityChange(dispatchOrderRevision);

            dispatchOrderRevision.getDispatchDeliverInformation().ifPresent(newDi -> this.dispatchDeliveryInformation = newDi);

            if(dispatchOrderRevision.getRevisedDispatchOrderLine() != null && dispatchOrderRevision.getRevisedDispatchOrderLine().size()>0){
                dispatchOrderLines.updateDispatchLine(dispatchOrderLines);
            }

            this.state = APPROVED;
            return singletonList(new DispatchOrderRevised(dispatchOrderRevision, dlqc.currentDispatchOrderTotal, dlqc.newDispatchOrderTotal));

            default:
                throw new UnsupportedStateTransitionException(state);
        }
    }

    public Long getVersion(){
        return version;
    }

    public List<DispatchOrderLine> getDispatchLine(){
        return dispatchOrderLine.getDispatchLine();
    }

    public DispatchOrderState getState(){
        return state;
    }

    public long getDispatcherId(){
        return dispatcherId;
    }


}