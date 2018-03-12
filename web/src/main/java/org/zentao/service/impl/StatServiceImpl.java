package org.zentao.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zentao.config.props.ApplicationConfiguration;
import org.zentao.entity.gen.ZtTaskExample;
import org.zentao.entity.gen.ZtTeam;
import org.zentao.entity.gen.ZtTeamExample;
import org.zentao.entity.mybatis.StatTaskByTypResult;
import org.zentao.entity.mybatis.StatTaskConsumedByMemberResult;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.mapper.gen.ZtTaskMapper;
import org.zentao.mapper.gen.ZtTeamMapper;
import org.zentao.service.StatService;

@Service
public class StatServiceImpl implements StatService {

  @Autowired
  private ZtTaskMapper ztTaskMapper;
  @Autowired
  private ApplicationConfiguration applicationConfiguration;
  @Autowired
  private ZtTeamMapper ztTeamMapper;

  @Override
  public List<MemberProjectConsumeStat> statTaskByMember(Integer projectID) {
    List<MemberProjectConsumeStat> memberProjectConsumeStats = this
        .queryAvailTimeByMember(projectID);
    if (null == memberProjectConsumeStats) {
      return null;
    }

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

    for (final MemberProjectConsumeStat tmp : memberProjectConsumeStats) {
      StatTaskConsumedByMemberResult foundValue = IterableUtils
          .find(statTaskConsumedByMemberResults,
              new Predicate<StatTaskConsumedByMemberResult>() {
                @Override
                public boolean evaluate(StatTaskConsumedByMemberResult object) {
                  return object.getMember().equals(tmp.getName());
                }
              });
      if (null == foundValue) {
        tmp.setTolConsumedTime(0d);
        tmp.setTolEstimatedTime(0d);
        tmp.setTaskTolNum(0);
        continue;
      }

      tmp.setTolConsumedTime(foundValue.getConsumedTime());
      tmp.setTolEstimatedTime(foundValue.getEstimatedTime());
      tmp.setTaskTolNum(foundValue.getTaskNum());
    }
    return memberProjectConsumeStats;
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

  @Override
  public List<MemberProjectConsumeStat> queryAvailTimeByMember(Integer projectID) {
    if (null == projectID) {
      return null;
    }

    ZtTeamExample queryByProjectID = new ZtTeamExample();
    queryByProjectID.or()
        .andProjectEqualTo(projectID);

    List<ZtTeam> ztTeams = ztTeamMapper.selectByExample(queryByProjectID);
    if (CollectionUtils.isEmpty(ztTeams)) {
      return null;
    }

    List<MemberProjectConsumeStat> memberProjectConsumeStats = new ArrayList<>(ztTeams.size());
    for (ZtTeam ztTeam : ztTeams) {
      MemberProjectConsumeStat stat = new MemberProjectConsumeStat();
      stat.setName(ztTeam.getAccount());
      stat.setAvailTime((double) (ztTeam.getDays() * ztTeam.getHours()));
      memberProjectConsumeStats.add(stat);
    }

    return memberProjectConsumeStats;
  }
}
