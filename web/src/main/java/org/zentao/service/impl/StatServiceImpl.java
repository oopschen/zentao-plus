package org.zentao.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zentao.config.props.ApplicationConfiguration;
import org.zentao.entity.gen.ZtProject;
import org.zentao.entity.gen.ZtProjectExample;
import org.zentao.entity.gen.ZtTaskExample;
import org.zentao.entity.gen.ZtTeam;
import org.zentao.entity.gen.ZtTeamExample;
import org.zentao.entity.mybatis.MemberStoryStat;
import org.zentao.entity.mybatis.StatTaskByTypResult;
import org.zentao.entity.mybatis.StatTaskConsumedByMemberResult;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectProfileStat;
import org.zentao.entity.stat.ProjectStoryStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.entity.stat.ProjectTimeUsageStat;
import org.zentao.mapper.gen.ZtProjectMapper;
import org.zentao.mapper.gen.ZtTaskMapper;
import org.zentao.mapper.gen.ZtTeamMapper;
import org.zentao.mapper.stat.PersonStatMapper;
import org.zentao.mapper.stat.ProjectStoryMapper;
import org.zentao.service.StatService;
import org.zentao.util.BeanUtil;

@Service
public class StatServiceImpl implements StatService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StatServiceImpl.class);

  @Autowired
  private ZtTaskMapper ztTaskMapper;
  @Autowired
  private ApplicationConfiguration applicationConfiguration;
  @Autowired
  private ZtTeamMapper ztTeamMapper;
  @Autowired
  private PersonStatMapper personStatMapper;
  @Autowired
  private ProjectStoryMapper projectStoryMapper;
  @Autowired
  private ZtProjectMapper ztProjectMapper;
  @Qualifier("query")
  @Autowired
  private ExecutorService executorService;

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

    // query time consumed stat
    List<StatTaskConsumedByMemberResult> statTaskConsumedByMemberResults = ztTaskMapper
        .statTaskConsumedByMember(queryCondition);
    if (CollectionUtils.isEmpty(statTaskConsumedByMemberResults)) {
      return null;
    }

    // query story related stat
    List<MemberStoryStat> memberStoryStats = personStatMapper
        .statMemberStoryCount(projectID, applicationConfiguration.getStoryStatus());

    for (final MemberProjectConsumeStat tmp : memberProjectConsumeStats) {
      StatTaskConsumedByMemberResult foundValue = IterableUtils
          .find(statTaskConsumedByMemberResults,
              object -> object.getMember().equals(tmp.getName())
          );

      // set time consumed stat
      if (null == foundValue) {
        tmp.setTolConsumedTime(0d);
        tmp.setTolEstimatedTime(0d);
        tmp.setTaskTolNum(0);
      } else {
        tmp.setTolConsumedTime(foundValue.getConsumedTime());
        tmp.setTolEstimatedTime(foundValue.getEstimatedTime());
        tmp.setTaskTolNum(foundValue.getTaskNum());

      }

      // set story stat
      MemberStoryStat foundMemberStoryStat = IterableUtils.find(memberStoryStats,
          object -> object.getMember().equals(tmp.getName())
      );
      if (null != foundMemberStoryStat) {
        tmp.setTolStoryCount(foundMemberStoryStat.getStoryCount());
      } else {
        tmp.setTolStoryCount(Integer.valueOf(0));
      }

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

  @Override
  public ProjectTimeUsageStat statProjectTimeUsage(
      List<MemberProjectConsumeStat> memberProjectConsumeStats) {
    ProjectTimeUsageStat result = new ProjectTimeUsageStat();
    if (CollectionUtils.isEmpty(memberProjectConsumeStats)) {
      result.setTolTime(1d);
      result.setUsageTime(0d);
      return result;
    }

    double tolTime = 0, tolUsage = 0;
    for (MemberProjectConsumeStat tmp : memberProjectConsumeStats) {
      tolTime += tmp.getAvailTime();
      tolUsage += tmp.getTolConsumedTime();
    }
    result.setTolTime(tolTime);
    result.setUsageTime(tolUsage);
    return result;
  }

  @Override
  public ProjectStoryStat statStoryByProject(Integer projectID) {
    if (null == projectID) {
      return null;
    }

    ProjectStoryStat projectStoryStat = new ProjectStoryStat();
    projectStoryStat.setTolStoryCount(
        projectStoryMapper.statStoryByProject(projectID, null)
    );
    projectStoryStat.setCompleteStoryCount(
        projectStoryMapper.statStoryByProject(projectID, applicationConfiguration.getStoryStatus())
    );

    return projectStoryStat;
  }

  @Override
  public List<ProjectProfileStat> statProjectsByTime(LocalDate start, LocalDate end) {
    if (null == start || null == end) {
      return null;
    }
    List<Future<List<ProjectProfileStat>>> resultFutures = new ArrayList<>(4);

    resultFutures.add(executorService.submit(() -> ztProjectMapper
        .statProjectStories(start, end, applicationConfiguration.getStoryStatus())));

    resultFutures.add(executorService.submit(() -> ztProjectMapper.statProjectBugs(start, end)));
    resultFutures.add(executorService.submit(() -> ztProjectMapper.statProjectMembers(start, end)));
    resultFutures.add(executorService.submit(() -> ztProjectMapper
        .statProjectTimeConsumed(start, end, applicationConfiguration.getTaskStatus())));

    List<ProjectProfileStat> results = new LinkedList<>();
    for (Future<List<ProjectProfileStat>> future : resultFutures) {
      boolean isBreak = false;
      List<ProjectProfileStat> stats = null;

      while (!isBreak) {
        try {
          stats = future.get();
          isBreak = true;
        } catch (InterruptedException | ExecutionException e) {
          LOGGER.error("future", e);
        }
      }

      if (null == stats) {
        continue;
      }

      for (final ProjectProfileStat tmp : stats) {
        ProjectProfileStat foundResult = IterableUtils
            .find(results, object -> object.getId().equals(tmp.getId()));
        if (null == foundResult) {
          results.add(tmp);
          continue;
        }

        // copy data
        try {
          BeanUtil
              .copyPropsExcludeNull(foundResult, tmp, "totalStories", "totalBugs", "totalMembers",
                  "totalTimeUsage");
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
          LOGGER.error("copy props", e);
        }
      }
    }

    if (CollectionUtils.isEmpty(results)) {
      return null;
    }

    List<Integer> projectIDs = new ArrayList<>(results.size());
    for(final ProjectProfileStat tmp : results) {
      projectIDs.add(tmp.getId());
    }

    List<ZtProject> ztProjects = queryProjectsInfoByIDs(projectIDs);
    for(final ProjectProfileStat tmp : results) {
      ZtProject ztProject = IterableUtils
          .find(ztProjects, object -> object.getId().equals(tmp.getId()));
      if (null == ztProject) {
        continue;
      }

      tmp.setName(ztProject.getName());
    }
    return results;
  }

  private List<ZtProject> queryProjectsInfoByIDs(List<Integer> projectID) {
    Set<Integer> projectIDs = new HashSet<>();
    projectIDs.addAll(projectID);
    ZtProjectExample queryByIDs = new ZtProjectExample();
    queryByIDs.or()
        .andIdIn(new ArrayList<>(projectID));

    return ztProjectMapper.selectByExample(queryByIDs);
  }
}
