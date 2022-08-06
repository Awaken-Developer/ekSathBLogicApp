package com.transion.eksath.blogic.accounts.web;

import com.transion.eksath.blogic.accounts.domain.AccountServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AccountServiceConfiguration.class)
@ComponentScan

public class AccountingWebConfiguration {
    
}
