package org.zentao.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.zentao.config.props.nest.QueryPoolConfiguration;

@Component
@ConfigurationProperties(prefix = "thread")
public class ThreadConfiguration {

  private QueryPoolConfiguration queryPool;

  public QueryPoolConfiguration getQueryPool() {
    return queryPool;
  }

  public void setQueryPool(QueryPoolConfiguration queryPool) {
    this.queryPool = queryPool;
  }
}
