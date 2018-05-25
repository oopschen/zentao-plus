package org.zentao.config.props.nest;

public class QueryPoolConfiguration {

  private Integer maxSize;
  private Integer coreSize;
  private Integer keepAliveSec;
  private Integer backqueueSize;

  public Integer getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(Integer maxSize) {
    this.maxSize = maxSize;
  }

  public Integer getCoreSize() {
    return coreSize;
  }

  public void setCoreSize(Integer coreSize) {
    this.coreSize = coreSize;
  }

  public Integer getKeepAliveSec() {
    return keepAliveSec;
  }

  public void setKeepAliveSec(Integer keepAliveSec) {
    this.keepAliveSec = keepAliveSec;
  }

  public Integer getBackqueueSize() {
    return backqueueSize;
  }

  public void setBackqueueSize(Integer backqueueSize) {
    this.backqueueSize = backqueueSize;
  }
}
