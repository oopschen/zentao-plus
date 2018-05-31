package org.zentao.config;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class BeanConfiguration {

  @Bean(name = "conversionService")
  public ConversionService conversionServiceFactoryBean() {
    return ApplicationConversionService.getSharedInstance();
  }

}
