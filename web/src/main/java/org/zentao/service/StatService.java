package org.zentao.service;

import java.util.List;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;

public interface StatService {

  List<MemberProjectConsumeStat> statTaskByMember(Integer projectID);

  List<ProjectTaskConsumedStat> statTaskByTyp(Integer projectID);

  List<MemberProjectConsumeStat> queryAvailTimeByMember(Integer projectID);
}
