package com.transion.eksath.blogic.dispatchorderapi.events;

//common
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class DispatchOrderCreatedEvent implements DispatchOrderDomainEvent {
    private DispatchOrderDetails dispatchOrderDetails;
   // private Address dispatchDeliveryAddress;
    private String workerName;
    
    private DispatchOrderCreatedEvent(){}

    public DispatchOrderCreatedEvent(DispatchOrderDetails dispatchOrderDetails, /*address */, String workerName){

        this.dispatchOrderDetails = dispatchOrderDetails;
        // this.dispatchDeliveryAddress = dispatchDeliveryAddress;
        this.workerName = workerName;
    }

    public DispatchOrderDetails getOrderDetails(){
        return dispatchOrderDetails;
    }

    public void setDispatchOrderDetails(DispatchOrderDetails dispatchOrderDetails){
        this.dispatchOrderDetails = dispatchOrderDetails;
    }

    public String getWorkerName(){
        return workerName;
    }

    public void setWorkerName(String workerName){
        this.workerName = workerName;
    }

    //address setters and getters

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o){
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
}
