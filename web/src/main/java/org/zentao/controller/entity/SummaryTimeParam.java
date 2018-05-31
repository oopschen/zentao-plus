package org.zentao.controller.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class SummaryTimeParam {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate start;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate end;

  public SummaryTimeParam() {
    end = LocalDate.now();
    start = end.minusMonths(6);
  }

  public LocalDate getStart() {
    return start;
  }

  public void setStart(LocalDate start) {
    this.start = start;
  }

  public LocalDate getEnd() {
    return end;
  }

  public void setEnd(LocalDate end) {
    this.end = end;
  }
}
