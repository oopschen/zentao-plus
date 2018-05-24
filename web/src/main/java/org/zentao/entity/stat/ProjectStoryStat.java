package org.zentao.entity.stat;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;
import java.io.IOException;
import java.io.Writer;

public class ProjectStoryStat {

  private Integer completeStoryCount;
  private Integer tolStoryCount;
  private Mustache.Lambda leftStoryCount;

  public ProjectStoryStat() {
    leftStoryCount = new Lambda() {
      @Override
      public void execute(Fragment frag, Writer out) throws IOException {
        out.write(String.format("%d", tolStoryCount - completeStoryCount));

      }
    };
  }

  public Integer getCompleteStoryCount() {
    return completeStoryCount;
  }

  public void setCompleteStoryCount(Integer completeStoryCount) {
    this.completeStoryCount = completeStoryCount;
  }

  public Integer getTolStoryCount() {
    return tolStoryCount;
  }

  public void setTolStoryCount(Integer tolStoryCount) {
    this.tolStoryCount = tolStoryCount;
  }
}
