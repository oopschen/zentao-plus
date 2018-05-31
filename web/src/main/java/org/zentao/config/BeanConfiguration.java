package org.zentao.config;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.zentao.service.converter.StringToLocalDateConverter;

@Configuration
public class BeanConfiguration {
  @Bean
  public Set<Converter> converters() {
    Set<Converter> converterSet = new HashSet<>();
    converterSet.add(new StringToLocalDateConverter());
    return converterSet;
  }

  @Bean(name = "conversionService")
  public ConversionServiceFactoryBean conversionServiceFactoryBean() {
    ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
    factoryBean.setConverters(converters());
    return factoryBean;
  }

}
