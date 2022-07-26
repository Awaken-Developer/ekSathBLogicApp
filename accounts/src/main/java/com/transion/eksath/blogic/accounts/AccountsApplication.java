package com.transion.eksath.blogic.accounts;

import io.eventuate.local.java.spring.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.tram.spring.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
//eventstore edit
import com.transion.eksath.blogic.accounts.messaging.AcccountingMessagingConfiguration;
import com.transion.eksath.blogic.accounts.web.AccountingWebConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//purpose of swagger and edits regarding its

@Configuration
@EnableAutoConfiguration
@Import({AccountingMessagingConfiguration.class, AccountingWebConfiguration.class, TramCommandProducerConfiguration.class, EventuateDriverConfiguration.class
TramJdbcKafkaConfiguration.class})
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
