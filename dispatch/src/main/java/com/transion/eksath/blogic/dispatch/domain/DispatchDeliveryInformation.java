package com.transion.eksath.blogic.dispatch.domain;

//common

import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Access(AccessType.FIELD)
public class DispatchDeliveryInformation {

    private LocalDateTime dispatchDeliveryTime;

  //  @Embedded
   // @AttributeOverrides({
   //     @AttributeOverride(name="state", column=@Column(name="dispatchdelivery_state"))
   // })

//common    private Address deliveryAddress;

    public DispatchDeliveryInformation(){}

    @Override
    public boolean equals(Object o){
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    public DispatchDeliveryInformation(LocalDateTime dispatchDeliveryTime/* , Address dispatchDeliveryAddress*/){
        this.dispatchDeliveryTime = dispatchDeliveryTime;
       // this.dispatchDeliveryAddress = dispatchDeliveryAddress;
    }

    public LocalDateTime getDispatchDeliveryTime(){
        return dispatchDeliveryTime;
    }

    public void setDispatchDeliveryTime(){
        this.dispatchDeliveryTime = dispatchDeliveryTime;
    }

    // common address setter and getters

    /*
    public Address getDispatchDeliveryAddress(){
        return dispatchDeliveryAddress;
    }

    public void setDispatchDeliveryAddress(){
        this.dispatchDeliveryAddress = deliveryAddress;
    }
    */
    
}
