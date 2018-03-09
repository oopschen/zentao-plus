package org.zentao.config.props;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("app")
@Component
public class ApplicationConfiguration {

  private List<String> taskStatus;

  public ApplicationConfiguration() {
  }

  public List<String> getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(List<String> taskStatus) {
    this.taskStatus = taskStatus;
  }
}
