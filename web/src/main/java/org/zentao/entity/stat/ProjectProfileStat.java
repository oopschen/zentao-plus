package org.zentao.entity.stat;

public class ProjectProfileStat {

  private String name;
  private Integer totalStories;
  private Integer totalBugs;
  private Integer totalMembers;
  private Integer totalTimeUsage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTotalStories() {
    return totalStories;
  }

  public void setTotalStories(Integer totalStories) {
    this.totalStories = totalStories;
  }

  public Integer getTotalBugs() {
    return totalBugs;
  }

  public void setTotalBugs(Integer totalBugs) {
    this.totalBugs = totalBugs;
  }

  public Integer getTotalMembers() {
    return totalMembers;
  }

  public void setTotalMembers(Integer totalMembers) {
    this.totalMembers = totalMembers;
  }

  public Integer getTotalTimeUsage() {
    return totalTimeUsage;
  }

  public void setTotalTimeUsage(Integer totalTimeUsage) {
    this.totalTimeUsage = totalTimeUsage;
  }
}
