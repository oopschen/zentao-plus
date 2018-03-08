package org.zentao.entity.stat;

/**
 * 项目里任务类型统计
 *
 * @author Ray(chenlei linxray @ gmail.com)
 * @date 2018/03/08
 * @since 1.0
 */
public class ProjectTaskTypeStat {

  private String taskTyp;
  private Integer taskTolNum;

  public ProjectTaskTypeStat() {
  }

  public String getTaskTyp() {
    return taskTyp;
  }

  public void setTaskTyp(String taskTyp) {
    this.taskTyp = taskTyp;
  }

  public Integer getTaskTolNum() {
    return taskTolNum;
  }

  public void setTaskTolNum(Integer taskTolNum) {
    this.taskTolNum = taskTolNum;
  }
}
