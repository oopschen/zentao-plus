package org.zentao.entity.stat;

public class ProjectProfileStat {

  private Integer id;
  private String name;
  private Integer totalStories;
  private Integer totalBugs;
  private Integer totalMembers;
  private Double totalTimeUsage;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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

  public Double getTotalTimeUsage() {
    return totalTimeUsage;
  }

  public void setTotalTimeUsage(Double totalTimeUsage) {
    this.totalTimeUsage = totalTimeUsage;
  }
}
