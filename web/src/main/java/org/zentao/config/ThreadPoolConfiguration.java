package org.zentao.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zentao.config.props.ThreadConfiguration;
import org.zentao.config.props.nest.QueryPoolConfiguration;

@Configuration
public class ThreadPoolConfiguration {

  @Autowired
  private ThreadConfiguration threadConfiguration;

  @Qualifier("query")
  @Bean
  public ExecutorService queryPool() {
    QueryPoolConfiguration queryPoolCfg = threadConfiguration.getQueryPool();
    return new ThreadPoolExecutor(
        queryPoolCfg.getCoreSize(),
        queryPoolCfg.getMaxSize(),
        queryPoolCfg.getKeepAliveSec(),
        TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(queryPoolCfg.getBackqueueSize())
    );
  }
}
