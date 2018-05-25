package org.zentao.config;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.TemplateLoader;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MustacheConfiguration {

  public Mustache.Compiler mustacheCompiler(TemplateLoader mustacheTemplateLoader,
      Environment environment) {
    MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
    collector.setEnvironment(environment);

    return Mustache.compiler().withLoader(mustacheTemplateLoader)
        .defaultValue(StringUtils.EMPTY)
        .withCollector(collector);
  }

}
