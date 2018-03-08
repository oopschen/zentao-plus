package org.zentao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.zentao.mapper")
public class DatabaseConfiguration {

  @ConfigurationProperties(prefix = "ds")
  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
  }
}
