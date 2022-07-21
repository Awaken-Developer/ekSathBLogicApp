package com.transion.eksath.blogic.dispatch.services;

import org.springframework.stereotype.Service;

import com.transion.eksath.blogic.dispatch.config.ServiceConfig;
import com.transion.eksath.blogic.dispatch.model.Dispatch;
import com.transion.eksath.blogic.dispatch.repository.DispatchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchService{

    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    ServiceConfig config;

    public Dispatch getDispatch(String userId, String dispatchOrderId){
        Dispatch dispatch = dispatchRepository.findByUserIdAndDispatchOrder(userId, dispatchOrderId);
        return dispatch.withComment(config.gettheProperty()); // edit this in model as well as here
    }
    
    public List<Dispatch> getDispatchByUser(String userId){
        return dispatchRepository.findByUserId(userId);
    }

}