package org.zentao.entity.stat;

/**
 * 项目相关成员统计
 *
 * @author Ray(chenlei linxray @ gmail.com)
 * @date 2018/03/08
 * @since 1.0
 */
public class MemberProjectConsumeStat {

  private String name;
  private Integer taskTolNum;
  private Double tolConsumedTime;
  private Double tolEstimatedTime;

  public MemberProjectConsumeStat() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTaskTolNum() {
    return taskTolNum;
  }

  public void setTaskTolNum(Integer taskTolNum) {
    this.taskTolNum = taskTolNum;
  }

  public Double getTolConsumedTime() {
    return tolConsumedTime;
  }

  public void setTolConsumedTime(Double tolConsumedTime) {
    this.tolConsumedTime = tolConsumedTime;
  }

  public Double getTolEstimatedTime() {
    return tolEstimatedTime;
  }

  public void setTolEstimatedTime(Double tolEstimatedTime) {
    this.tolEstimatedTime = tolEstimatedTime;
  }
}
