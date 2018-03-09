package org.zentao.entity.mybatis;

public class StatTaskByTypResult {

  private Double consumedTime;
  private Double estimatedTime;
  private String typ;

  public StatTaskByTypResult() {
  }

  public Double getConsumedTime() {
    return consumedTime;
  }

  public void setConsumedTime(Double consumedTime) {
    this.consumedTime = consumedTime;
  }

  public Double getEstimatedTime() {
    return estimatedTime;
  }

  public void setEstimatedTime(Double estimatedTime) {
    this.estimatedTime = estimatedTime;
  }

  public String getTyp() {
    return typ;
  }

  public void setTyp(String typ) {
    this.typ = typ;
  }
}
