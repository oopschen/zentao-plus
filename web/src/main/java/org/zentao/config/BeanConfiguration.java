package org.zentao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;

@Configuration
public class BeanConfiguration {

  @Bean(name = "conversionService")
  public ConversionServiceFactoryBean conversionServiceFactoryBean() {
    ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
    return factoryBean;
  }

}
