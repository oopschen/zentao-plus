package org.zentao.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("org.zentao.mapper")
public class DatabaseConfiguration {

}
