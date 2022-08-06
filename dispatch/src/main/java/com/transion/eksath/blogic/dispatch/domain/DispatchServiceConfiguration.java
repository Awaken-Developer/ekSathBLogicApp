package com.transion.eksath.blogic.dispatch.domain;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.sagas.orchestration.*;
import io.eventuate.tram.sagas.spring.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//common



@Configuration
@Import({TramEventsPublisherConfiguration.class, SagaOrchestratorConfiguration.class/* common configuration class */})


public class DispatchServiceConfiguration {

    @Bean
    public DispatchOrderService dispatchOrderService(SagaInstanceFactory sagaInstanceFactory, 
    DispatchOrderRepository dispatchOrderRepository, DomainEventPublisher eventPublisher,
    CreateDispatchSaga createDispatchSaga, CancelDispatchSaga cancelDispatchSaga, ReviseDispatchSaga reviseDispatchSaga, DispatchOrderDomainEventPublisher dispatchOrderAggregateEventPublisher, Optional<MeterRegistry> meterRegistry){
        return new DispatchOrderService(sagaInstanceFactory, dispatchOrderRepository, domainEventPublisher, createDispatchSaga, cancelDispatchSaga, reviseDispatchSaga, dispatchOrderAggregateEventPublisher, meterRegistry);
    }

    @Bean 
    public CreateDispatchSaga createDispatchSaga(DispatchServiceProxy dispatchService, ConsumerServiceProxy consumerService, AccountingServiceProxy accountingService, ProfilesServiceProxy profilesService, FeedbackServiceProxy feedbackServiceProxy){
        return new CreateDispatchSaga(dispatchService, consumerService, accountingService, profilesService, feedback);
    }

    @Bean
    public CancelDispatchSaga cancelDispatchSaga(){
        return new CancelDispatchSaga();
    }

    @Bean
    public ReviseDispatchSaga reviseDispatchSaga(){
        return new ReviseDispatchSaga();
    }

    @Bean 
    public DispatchServiceProxy dispatchServiceProxy(){
        return new DispatchServiceProxy();
    }


    @Bean 
    public ConsumerServiceProxy ConsumerServiceProxy(){
        return new ConsumerServiceProxy();
    }

    @Bean 
    public AccountingServiceProxy accountingServiceProxy(){
        return  new AccountingServiceProxy();
    }

    @Bean 
    public ProfilesServiceProxy profilesServiceProxy(){
        return new ProfilesServiceProxy();
    }

    @Bean
    public FeedbackServiceProxy feedbackServiceProxy(){
        return new FeedbackServiceProxy();
    }

    @Bean
    public DispatchOrderDomainEventPublisher dispatchOrderDomainEventPublisher(DomainEventPublisher domainEventPublisher){
        return new DispatchOrderDomainEventPublisher(eventPublisher);
    }

    @Bean
    public MeterRegistryCustomizer meterRegistryCustomizer(@Value("${spring.application.name}") String serviceName){
        return registry -> registry.config().commonTags("service", serviceName);
    }
}

