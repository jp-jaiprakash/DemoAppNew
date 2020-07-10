package com.example.demowithh2.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductsConfig {

   @Bean
   public DozerBeanMapper dozerMapper() {
      return new DozerBeanMapper();
   }

}
