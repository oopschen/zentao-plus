package org.zentao.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zentao.config.props.ApplicationConfiguration;
import org.zentao.entity.StatProjectTimeRange;
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
import org.zentao.entity.stat.TimeRangeProjectStat;
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

    //项目人员总耗时
    List<StatTaskConsumedByMemberResult> consumedTimeByMemberResults = ztTaskMapper
            .consumedTimeByMember(queryCondition);
    //项目人员任务数
    List<StatTaskConsumedByMemberResult> taskNumByMemberResults = ztTaskMapper
            .taskNumByMember(queryCondition);
    //项目人员非团队任务预计
    List<StatTaskConsumedByMemberResult> unGroupEstimatedTimeByMemberResults = ztTaskMapper
            .unGroupEstimatedTimeByMember(queryCondition);
    //项目人员团队任务预计
    List<StatTaskConsumedByMemberResult> groupEstimatedTimeByMemberResults = ztTaskMapper
            .groupEstimatedTimeByMember(queryCondition);

    // query story related stat
    List<MemberStoryStat> memberStoryStats = personStatMapper
        .statMemberStoryCount(projectID, applicationConfiguration.getStoryStatus());
    for (final MemberProjectConsumeStat tmp : memberProjectConsumeStats) {
      // 项目人员总耗时合并
      StatTaskConsumedByMemberResult consumedTimeValue = IterableUtils
          .find(consumedTimeByMemberResults,
              object -> object.getMember().equals(tmp.getName())
          );
      if (null == consumedTimeValue) {
        tmp.setTolConsumedTime(0d);
      } else {
        tmp.setTolConsumedTime(consumedTimeValue.getConsumedTime());
      }
      //项目人员任务合并
      StatTaskConsumedByMemberResult taskNumValue = IterableUtils
              .find(taskNumByMemberResults,
                      object -> object.getMember().equals(tmp.getName())
              );
      if (null == taskNumValue) {
        tmp.setTaskTolNum(0);
      } else {
        tmp.setTaskTolNum(taskNumValue.getTaskNum());
      }
      //项目人员预计时间合并
      StatTaskConsumedByMemberResult unGroupEstimatedTimeValue = IterableUtils
              .find(unGroupEstimatedTimeByMemberResults,
                      object -> object.getMember().equals(tmp.getName())
              );
      StatTaskConsumedByMemberResult groupEstimatedTimeValue = IterableUtils
              .find(groupEstimatedTimeByMemberResults,
                      object -> object.getMember().equals(tmp.getName())
              );

      Double TolEstimatedTime=0d;
      if ( null != groupEstimatedTimeValue)
      {
        TolEstimatedTime+=groupEstimatedTimeValue.getEstimatedTime();
      }
      if(null != unGroupEstimatedTimeValue)
      {
        TolEstimatedTime+=unGroupEstimatedTimeValue.getEstimatedTime();
      }
      tmp.setTolEstimatedTime(TolEstimatedTime);

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

    //任务类型数量统计
    List<StatTaskByTypResult> tolNumByTyps = ztTaskMapper.tolNumByTyp(queryCondition);
    //任务类型耗时统计
    List<StatTaskByTypResult> consumedTimeByTyps= ztTaskMapper.consumedTimeByTyp(queryCondition);

    if (CollectionUtils.isEmpty(tolNumByTyps)) {
      return null;
    }

    List<ProjectTaskConsumedStat> result = new ArrayList<>(tolNumByTyps.size());
    for (StatTaskByTypResult tolNum : tolNumByTyps) {
      ProjectTaskConsumedStat stat = new ProjectTaskConsumedStat();

      stat.setTaskTyp(tolNum.getTyp());
      stat.setTotalNum(tolNum.getTolNum());

      for (StatTaskByTypResult consumedTime : consumedTimeByTyps) {
        if(consumedTime.getTyp().equals(stat.getTaskTyp())) {
          stat.setConsumedTime(consumedTime.getConsumedTime());
        }
      }

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
        .androotEqualTo(projectID);

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
        } catch (InterruptedException e) {
          LOGGER.error("future interrupt", e);
        } catch (ExecutionException e) {
          isBreak = true;
          LOGGER.error("future exec", e);
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
    for (final ProjectProfileStat tmp : results) {
      projectIDs.add(tmp.getId());
    }

    List<ZtProject> ztProjects = queryProjectsInfoByIDs(projectIDs);
    for (final ProjectProfileStat tmp : results) {
      ZtProject ztProject = IterableUtils
          .find(ztProjects, object -> object.getId().equals(tmp.getId()));
      if (null == ztProject) {
        continue;
      }

      tmp.setName(ztProject.getName());
    }
    return results;
  }

  @Override
  public List<TimeRangeProjectStat> statProjectByTimeRange(LocalDate start, LocalDate end,
      StatProjectTimeRange timerange) {
    if (null == start || null == end) {
      return null;
    }
    // format start, end to floor(start), ceil(end)
    LocalDate actualStart = start.with(TemporalAdjusters.firstDayOfMonth()),
        actualEnd = end.with(TemporalAdjusters.firstDayOfNextMonth());

    // query all project info by time
    ZtProjectExample queryProjectByTime = new ZtProjectExample();
    queryProjectByTime.or()
        .andDeletedEqualTo("0")
        .andBeginGreaterThanOrEqualTo(actualStart)
        .andBeginLessThan(actualEnd);
    queryProjectByTime.setOrderByClause("begin asc");
    List<ZtProject> ztProjects = ztProjectMapper.selectByExample(queryProjectByTime);

    List<TimeRangeProjectStat> result = new LinkedList<>();
    LocalDate tmp = actualStart;
    int year = 0,
        month = StatProjectTimeRange.MONTHLY == timerange ? 1 : 0,
        days = StatProjectTimeRange.WEEKLY == timerange ? 7 : 0;
    Period step = Period.of(year, month, days);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
        StatProjectTimeRange.MONTHLY == timerange ? "yyyy-MM" : "yyyy-MM W"
    );
    int ztProjectInx = 0;
    boolean isZtProjectsEmpty = CollectionUtils.isEmpty(ztProjects);
    Consumer<LocalDate> dateConsumer = (inputDate) -> {
      final String fmtDate = inputDate.format(dateTimeFormatter);
      TimeRangeProjectStat foundTimeRange = IterableUtils
          .find(result, object -> object.getTimerange().equals(fmtDate));
      if (null == foundTimeRange) {
        foundTimeRange = new TimeRangeProjectStat(fmtDate, 1);
        result.add(foundTimeRange);
      } else {
        foundTimeRange.setTotalProjects(foundTimeRange.getTotalProjects() + 1);
      }

    };

    // begin
    while (tmp.isBefore(actualEnd)) {
      final String dateStr = tmp.format(dateTimeFormatter);
      TimeRangeProjectStat foundStat = IterableUtils
          .find(result, object -> object.getTimerange().equals(dateStr));
      if (null == foundStat) {
        result.add(new TimeRangeProjectStat(dateStr, 0));
      }

      final LocalDate tmpEnd = tmp.plus(step);
      if (!isZtProjectsEmpty) {
        for (int i = ztProjectInx; i < ztProjects.size(); ) {
          final ZtProject project = ztProjects.get(i);
          // project date after current loop
          if (tmpEnd.compareTo(project.getBegin()) < 0 || tmp.compareTo(project.getEnd()) > 0) {
            break;
          }
          // project time range in one step
          if (tmp.compareTo(project.getBegin()) <= 0 && tmpEnd.compareTo(project.getEnd()) > 0) {
            dateConsumer.accept(project.getBegin());
            ztProjectInx = ++i;
            continue;
          }

          // loop from begin to end
          LocalDate beginEndTmp = project.getBegin();
          while (beginEndTmp.compareTo(project.getEnd()) <= 0) {
            dateConsumer.accept(beginEndTmp);
            beginEndTmp = beginEndTmp.plus(step);
          }

          String fmtBeginEndTmpLast = beginEndTmp.minus(step).format(dateTimeFormatter),
              fmtProjectEnd = project.getEnd().format(dateTimeFormatter);
          if (!fmtBeginEndTmpLast.equals(fmtProjectEnd)) {
            dateConsumer.accept(project.getEnd());
          }

          ztProjectInx = ++i;
        }

      }

      tmp = tmpEnd;

    }

    if (CollectionUtils.isNotEmpty(result)) {
      // sort reulst
      result.sort((arg1, arg2) -> arg1.getTimerange().compareTo(arg2.getTimerange()));
    }

    return result;
  }

  private List<ZtProject> queryProjectsInfoByIDs(List<Integer> projectID) {
    Set<Integer> projectIDs = new HashSet<>();
    projectIDs.addAll(projectID);
    ZtProjectExample queryByIDs = new ZtProjectExample();
    queryByIDs.or()
        .andIdIn(new ArrayList<>(projectID));

    return ztProjectMapper.selectByExample(queryByIDs);
  }
};
