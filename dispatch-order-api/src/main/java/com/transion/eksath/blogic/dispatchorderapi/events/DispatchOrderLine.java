package com.transion.eksath.blogic.dispatchorderapi.events;

// common money

import javax.persistence.Embeddable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



@Embeddable
public class DispatchOrderLine {
    
    public DispatchOrderLine(){}

    private int fillNumber;
    private String profileId;
    private String workerName;

   // @Embedded
    //@AttributeOverrides(@AttributeOverride(name="a"))
//person attributes

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

    public DispatchOrderLine(String profileId, String workerName, int fillNumber){
        this.fillNumber = fillNumber;
        this.profileId = profileId;
        this.workerName = workerName;
    }

    public void setProfileId(String profileId){
        this.profileId = profileId;
    }

    public void setWorkerName(String workerName){
        this.workerName = workerName;
    }

    public void setFillNumber(int fillNumber){
        this.fillNumber = fillNumber;
    }

    public int getFillNumber(){
        return fillNumber;
    }

    public String getProfileId(){
        return profileId;
    }

    public String getWorkerName(){
        return workerName;
    }
}

