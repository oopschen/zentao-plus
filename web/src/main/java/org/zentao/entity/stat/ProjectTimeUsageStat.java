package org.zentao.entity.stat;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;
import java.io.IOException;
import java.io.Writer;

public class ProjectTimeUsageStat {
  private Double tolTime;
  private Double usageTime;
  private Mustache.Lambda timeLeft;

  public ProjectTimeUsageStat() {
    timeLeft = new Lambda() {
      @Override
      public void execute(Fragment frag, Writer out) throws IOException {
        out.write(String.format("%.2f", tolTime - usageTime));

      }
    };
  }

  public Double getTolTime() {
    return tolTime;
  }

  public void setTolTime(Double tolTime) {
    this.tolTime = tolTime;
  }

  public Double getUsageTime() {
    return usageTime;
  }

  public void setUsageTime(Double usageTime) {
    this.usageTime = usageTime;
  }

}
