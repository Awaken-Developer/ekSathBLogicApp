package com.transion.eksath.blogic.dispatchorderapi.events;

//common
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



public class DispatchOrderDetails {

    private List<DispatchOrderLine> line;
    //instead of money

    private long workerId;
    private long dispatcherId;
    
    private DispatchOrderDetails(){}

    public DispatchOrderDetails(long workerId, long dsipatcherId, List<DispatchOrderLine> line){
        this.workerId = workerId;
        this.dispatcherId = dispatcherId;
        this.line = line;
    }

    public long getWorkerId(){
        return workerId;
    }

    public void setWorkerId(){
        this.workerId = workerId;
    }

    public long getDispatcherId(){
        return dispatcherId;
    }

    public void setDispatcherId(){
        this.dispatcherId = dispatcherId;
    }

    public List<DispatchOrderLine> getLine(){
        return line;
    }

    public void setLine(List<DispatchOrderLine> line){
        this.line = line;
    }


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
