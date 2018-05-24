package org.zentao.entity.mybatis;

public class MemberStoryStat {
  private String member;
  private Integer storyCount;

  public MemberStoryStat() {
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  public Integer getStoryCount() {
    return storyCount;
  }

  public void setStoryCount(Integer storyCount) {
    this.storyCount = storyCount;
  }
}
