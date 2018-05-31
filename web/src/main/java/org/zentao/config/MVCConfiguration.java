package org.zentao.config;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfiguration implements WebMvcConfigurer {

  @Autowired
  private Set<Converter> converters;

  public void addFormatters(FormatterRegistry registry) {
    DefaultConversionService.addDefaultConverters(registry);
    ConversionServiceFactory.registerConverters(converters, registry);
  }
}
