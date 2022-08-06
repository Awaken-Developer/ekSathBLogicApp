package com.transion.eksath.blogic.dispatch.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.transion.eksath.blogic.dispatch.config.ServiceConfig;
import com.transion.eksath.blogic.dispatch.model.Dispatch;
import com.transion.eksath.blogic.dispatch.repository.DispatchRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






@Service
public class DispatchService {

    private static final Logger logger = LoggerFactory.getLogger(DispatchService.class);

    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    ServiceConfig config;

    // rest object; if needed check later

    public Dispatch getDispatch(String userId, String dispatchOrderId) {
        Dispatch dispatch = dispatchRepository.findByUserIdAndDispatchOrder(userId, dispatchOrderId);
        return dispatch.withComment(config.gettheProperty()); // edit this in model as well as here
        // edits based on chal code
    }

    // for test purposeses tentatively
    private void randomlyTakeTime() {
        Random rand = new Random();

        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum == 3)
            sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }// end

    @HystrixCommand(// fallbackMethod = "buildFallbackDispatchList",
            threadPoolKey = "dispatchOrderssByUserThreadPool", 
            threadPoolProperties = 
            {@HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),
                @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),
                @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")
            })

    public List<Dispatch> getDispatchByUser(String userId) {
        logger.debug("DispatchService.getDispatchByUser Correlation id: {}", UserContextHolder.getContex().getCorrelationId());
        randomlyTakeTime();

        return dispatchRepository.findByUserId(userId);
    }

    //review and edit
    private List<Dispatch> buildFallbackDispatchList(String userId){
        List<Dispatch> fallbackList = new ArrayList<>();
        Dispatch dispatch = new Dispatch(); // 
    }


    // service methods and sagas too be added     
}