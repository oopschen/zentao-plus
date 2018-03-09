package org.zentao.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zentao.config.props.ApplicationConfiguration;
import org.zentao.entity.gen.ZtTaskExample;
import org.zentao.entity.mybatis.StatTaskByTypResult;
import org.zentao.entity.mybatis.StatTaskConsumedByMemberResult;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.mapper.gen.ZtTaskMapper;
import org.zentao.service.StatService;

@Service
public class StatServiceImpl implements StatService {

  @Autowired
  private ZtTaskMapper ztTaskMapper;
  @Autowired
  private ApplicationConfiguration applicationConfiguration;

  @Override
  public List<MemberProjectConsumeStat> statTaskByMember(Integer projectID) {
    ZtTaskExample queryCondition = new ZtTaskExample();
    queryCondition.or()
        .andDeletedEqualTo("0")
        .andProjectEqualTo(projectID)
        .andStatusIn(applicationConfiguration.getTaskStatus())
    ;

    List<StatTaskConsumedByMemberResult> statTaskConsumedByMemberResults = ztTaskMapper
        .statTaskConsumedByMember(queryCondition);
    if (CollectionUtils.isEmpty(statTaskConsumedByMemberResults)) {
      return null;
    }

    List<MemberProjectConsumeStat> result = new ArrayList<>(statTaskConsumedByMemberResults.size());

    for (StatTaskConsumedByMemberResult tmpTaskConsumedByMember : statTaskConsumedByMemberResults) {
      MemberProjectConsumeStat memberProjectConsumeStat = new MemberProjectConsumeStat();

      memberProjectConsumeStat.setName(tmpTaskConsumedByMember.getMember());
      memberProjectConsumeStat.setTolConsumedTime(tmpTaskConsumedByMember.getConsumedTime());
      memberProjectConsumeStat.setTolEstimatedTime(tmpTaskConsumedByMember.getEstimatedTime());
      memberProjectConsumeStat.setTaskTolNum(tmpTaskConsumedByMember.getTaskNum());

      result.add(memberProjectConsumeStat);
    }

    return result;
  }

  @Override
  public List<ProjectTaskConsumedStat> statTaskByTyp(Integer projectID) {
    ZtTaskExample queryCondition = new ZtTaskExample();
    queryCondition.or()
        .andDeletedEqualTo("0")
        .andProjectEqualTo(projectID)
        .andStatusIn(applicationConfiguration.getTaskStatus())
    ;

    List<StatTaskByTypResult> taskByTyps = ztTaskMapper.statTaskConsumedByTyp(queryCondition);
    if (CollectionUtils.isEmpty(taskByTyps)) {
      return null;
    }

    List<ProjectTaskConsumedStat> result = new ArrayList<>(taskByTyps.size());
    for (StatTaskByTypResult tmpTaskByTyp : taskByTyps) {
      ProjectTaskConsumedStat stat = new ProjectTaskConsumedStat();

      stat.setTaskTyp(tmpTaskByTyp.getTyp());
      stat.setConsumedTime(tmpTaskByTyp.getConsumedTime());
      stat.setTotalNum(tmpTaskByTyp.getTolNum());

      result.add(stat);
    }
    return result;
  }
}
