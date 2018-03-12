package org.zentao.service;

import java.util.List;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.entity.stat.ProjectTimeUsageStat;

public interface StatService {

  List<MemberProjectConsumeStat> statTaskByMember(Integer projectID);

  List<ProjectTaskConsumedStat> statTaskByTyp(Integer projectID);

  List<MemberProjectConsumeStat> queryAvailTimeByMember(Integer projectID);

  ProjectTimeUsageStat statProjectTimeUsage(List<MemberProjectConsumeStat> memberProjectConsumeStats);
}
