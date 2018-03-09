package org.zentao.entity.mybatis;

public class StatTaskConsumedByMemberResult {

  private Double consumedTime;
  private Double estimatedTime;
  private String member;
  private Integer taskNum;

  public StatTaskConsumedByMemberResult() {
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

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  public Integer getTaskNum() {
    return taskNum;
  }

  public void setTaskNum(Integer taskNum) {
    this.taskNum = taskNum;
  }
}
