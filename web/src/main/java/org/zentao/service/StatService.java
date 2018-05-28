package org.zentao.service;

import java.time.LocalDate;
import java.util.List;
import org.zentao.entity.StatProjectTimeRange;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectProfileStat;
import org.zentao.entity.stat.ProjectStoryStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.entity.stat.ProjectTimeUsageStat;
import org.zentao.entity.stat.TimeRangeProjectStat;

public interface StatService {

  List<MemberProjectConsumeStat> statTaskByMember(Integer projectID);

  List<ProjectTaskConsumedStat> statTaskByTyp(Integer projectID);

  List<MemberProjectConsumeStat> queryAvailTimeByMember(Integer projectID);

  ProjectTimeUsageStat statProjectTimeUsage(
      List<MemberProjectConsumeStat> memberProjectConsumeStats);

  ProjectStoryStat statStoryByProject(Integer projectID);

  List<ProjectProfileStat> statProjectsByTime(LocalDate start, LocalDate end);

  List<TimeRangeProjectStat> statProjectByTimeRange(LocalDate start, LocalDate end,
      StatProjectTimeRange timerange);
}
