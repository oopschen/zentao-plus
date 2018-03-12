package org.zentao.entity.stat;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;
import java.io.IOException;
import java.io.Writer;

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
  private Double availTime;
  private Mustache.Lambda availPercentage;

  public MemberProjectConsumeStat() {
    availPercentage = new Lambda() {
      @Override
      public void execute(Fragment frag, Writer out) throws IOException {
        out.write(String.format("%.2f", tolConsumedTime / availTime));

      }
    };
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

  public Double getAvailTime() {
    return availTime;
  }

  public void setAvailTime(Double availTime) {
    this.availTime = availTime;
  }

}
