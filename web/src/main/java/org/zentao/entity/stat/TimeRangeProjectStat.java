package org.zentao.entity.stat;

public class TimeRangeProjectStat {
  private String timerange;
  private Integer totalProjects;

  public TimeRangeProjectStat(String timerange, Integer totalProjects) {
    this.timerange = timerange;
    this.totalProjects = totalProjects;
  }

  public String getTimerange() {
    return timerange;
  }

  public void setTimerange(String timerange) {
    this.timerange = timerange;
  }

  public Integer getTotalProjects() {
    return totalProjects;
  }

  public void setTotalProjects(Integer totalProjects) {
    this.totalProjects = totalProjects;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeRangeProjectStat that = (TimeRangeProjectStat) o;
    return com.google.common.base.Objects.equal(timerange, that.timerange);
  }

  @Override
  public int hashCode() {
    return com.google.common.base.Objects.hashCode(timerange);
  }
}
