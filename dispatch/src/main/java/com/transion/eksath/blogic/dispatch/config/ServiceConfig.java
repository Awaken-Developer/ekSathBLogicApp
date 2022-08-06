package com.transion.eksath.blogic.dispatch.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//edit this 

@Component
public class ServiceConfig {
    
    @Value("$thePoperty") // check the property later 
    private String theProperty;
    
    public String gettheProperty(){
        return theProperty;
    }
}
