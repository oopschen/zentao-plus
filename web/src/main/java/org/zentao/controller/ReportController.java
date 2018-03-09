package org.zentao.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zentao.entity.gen.ZtProject;
import org.zentao.entity.gen.ZtProjectExample;
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
  public String projectReport() {
    return null;
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

}
