package org.zentao.entity.stat;

/**
 * 任务耗时统计
 *
 * @author Ray(chenlei linxray @ gmail.com)
 * @date 2018/03/08
 * @since 1.0
 */
public class ProjectTaskConsumedStat {
  private String taskTyp;
  private Double consumedTime;
  private Integer toltalNum;

  public ProjectTaskConsumedStat() {
  }

  public String getTaskTyp() {
    return taskTyp;
  }

  public void setTaskTyp(String taskTyp) {
    this.taskTyp = taskTyp;
  }

  public Double getConsumedTime() {
    return consumedTime;
  }

  public void setConsumedTime(Double consumedTime) {
    this.consumedTime = consumedTime;
  }

  public Integer getToltalNum() {
    return toltalNum;
  }

  public void setToltalNum(Integer toltalNum) {
    this.toltalNum = toltalNum;
  }
}
