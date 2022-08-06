package com.transion.eksath.blogic.accounts.messaging;

import com.transion.eksath.blogic.accounts.domain.AccountServiceConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.tram.spring.consumer.jdbc.TransactionalNoopDuplicateMessageDetectorConfiguration;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//common



@Configuration
@EnableEventHandlers
@Import({AccountServiceConfiguration.class, /*common class*/ TramEventSubscriberConfiguration.class, TramCommandConsumerConfiguaration.class, TransactionalNoopDuplicateMessageDetectorConfiguration.class})
public class AccountMessagingConfiguration{

    @Bean
}