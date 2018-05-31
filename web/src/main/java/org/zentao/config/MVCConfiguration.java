package org.zentao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfiguration implements WebMvcConfigurer {

  public void addFormatters(FormatterRegistry registry) {
    DefaultConversionService.addDefaultConverters(registry);
  }
}
