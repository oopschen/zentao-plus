package org.zentao.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zentao.entity.gen.ZtProject;
import org.zentao.entity.gen.ZtProjectExample;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectProfileStat;
import org.zentao.entity.stat.ProjectStoryStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.entity.stat.ProjectTimeUsageStat;
import org.zentao.mapper.gen.ZtProjectMapper;
import org.zentao.service.StatService;

@Controller
@RequestMapping("/report")
public class ReportController {

  @Autowired
  private ZtProjectMapper ztProjectMapper;
  @Autowired
  private StatService statService;

  @GetMapping("/project/{projectID}")
  public String projectReport(@PathVariable Integer projectID, ModelMap modelMap) {
    List<MemberProjectConsumeStat> memberProjectConsumeStats = statService
        .statTaskByMember(projectID);
    List<ProjectTaskConsumedStat> projectTaskConsumedStats = statService.statTaskByTyp(projectID);

    ProjectTimeUsageStat projectTimeUsageStat = statService
        .statProjectTimeUsage(memberProjectConsumeStats);

    ProjectStoryStat projectStoryStat = statService.statStoryByProject(projectID);

    ZtProject ztProject = ztProjectMapper.selectByPrimaryKey(projectID);
    modelMap.put("memberStats", memberProjectConsumeStats);
    modelMap.put("taskStats", projectTaskConsumedStats);
    modelMap.put("projectTimeUsage", projectTimeUsageStat);
    modelMap.put("projectInfo", ztProject);
    modelMap.put("projectStoryStat", projectStoryStat);
    return "report/project_detail";
  }

  @GetMapping("/project")
  public String projectReportDefault(ModelMap modelMap) {
    ZtProjectExample query = new ZtProjectExample();
    query.or().andDeletedEqualTo("0");
    query.setOrderByClause("begin desc");

    List<ZtProject> ztProjects = ztProjectMapper.selectByExample(query);
    modelMap.put("projects", ztProjects);
    return "report/project";
  }

  @GetMapping("/project/summary")
  public String projectSummary(
      @RequestParam(required = false) LocalDate start,
      @RequestParam(required = false) LocalDate end,
      ModelMap modelMap
  ) {
    LocalDate actualStart = start, actualEnd = end;
    if (null == actualStart) {
      actualStart = LocalDate.now().minusMonths(6);
    }
    if (null == actualEnd) {
      actualEnd = LocalDate.now();
    }

    List<ProjectProfileStat> projectProfileStats = statService
        .statProjectsByTime(actualStart, actualEnd);
    modelMap.put("projectStats", projectProfileStats);
    return "report/project_summary";
  }

}
