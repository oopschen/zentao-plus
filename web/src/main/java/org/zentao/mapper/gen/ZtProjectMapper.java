package org.zentao.mapper.gen;

import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zentao.entity.gen.ZtProject;
import org.zentao.entity.gen.ZtProjectExample;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectProfileStat;

public interface ZtProjectMapper {

  long countByExample(ZtProjectExample example);

  List<ZtProject> selectByExampleWithBLOBs(ZtProjectExample example);

  List<ZtProject> selectByExample(ZtProjectExample example);

  ZtProject selectByPrimaryKey(Integer id);

  //    do not delete
  List<ProjectProfileStat> statProjectTimeConsumed(
      @Param("createDate") LocalDate createDate,
      @Param("endDate") LocalDate endDate,
      @Param("taskStatus") List<String> taskStatus
  );

  List<ProjectProfileStat> statProjectStories(
      @Param("createDate") LocalDate createDate,
      @Param("endDate") LocalDate endDate,
      @Param("storyStatus") List<String> storyStatus
  );

  List<ProjectProfileStat> statProjectMembers(
      @Param("createDate") LocalDate createDate,
      @Param("endDate") LocalDate endDate
  );

  List<MemberProjectConsumeStat> statProjectMemberTimeUsage(
      @Param("createDate") LocalDate createDate,
      @Param("endDate") LocalDate endDate,
      @Param("taskStatus") List<String> taskStatus
  );

  List<ProjectProfileStat> statProjectBugs(
      @Param("createDate") LocalDate createDate,
      @Param("endDate") LocalDate endDate
  );

}