import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zentao.Main;
import org.zentao.config.props.ApplicationConfiguration;
import org.zentao.controller.ReportController;
import org.zentao.controller.entity.SummaryTimeParam;
import org.zentao.entity.stat.MemberProjectConsumeStat;
import org.zentao.entity.stat.ProjectProfileStat;
import org.zentao.entity.stat.ProjectTaskConsumedStat;
import org.zentao.mapper.gen.ZtProjectMapper;
import org.zentao.service.StatService;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(classes = Main.class)
@ExtendWith(SpringExtension.class)
public class TestUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private StatService statService;
    @Autowired
    private ZtProjectMapper ztProjectMapper;
    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    //项目总耗时统计功能
    @Test
    public void statProjectTimeConsumedTest() {
        SummaryTimeParam timeParam =new SummaryTimeParam();
        LocalDate actualStart = timeParam.getStart(), actualEnd = timeParam.getEnd();
        List<ProjectProfileStat> projectProfileStats = statService.
                statProjectsByTime(actualStart, actualEnd);
        LOGGER.info("---------------------------------------------------");
        for(ProjectProfileStat projectProfileStat : projectProfileStats){
                LOGGER.info("id:"+projectProfileStat.getId());
                LOGGER.info("name:"+projectProfileStat.getName());
                LOGGER.info("totalStories:"+projectProfileStat.getTotalStories());
                LOGGER.info("totalBugs:"+projectProfileStat.getTotalBugs());
                LOGGER.info("totalMembers:"+projectProfileStat.getTotalMembers());
                LOGGER.info("totalTimeUsage:"+projectProfileStat.getTotalTimeUsage());
                LOGGER.info("---------------------------------------------------");
        }
    }

    //人员总耗时统计功能
    @Test
    public void statProjectMemberTimeUsageTest(){
        SummaryTimeParam timeParam =new SummaryTimeParam();
        LocalDate actualStart = timeParam.getStart(), actualEnd = timeParam.getEnd();
        List<MemberProjectConsumeStat> memberProjectConsumeStats = ztProjectMapper
                .statProjectMemberTimeUsage(actualStart, actualEnd,
                        applicationConfiguration.getTaskStatus());
        LOGGER.info("---------------------------------------------------");
        for(MemberProjectConsumeStat memberProjectConsumeStat : memberProjectConsumeStats){
            LOGGER.info("name:"+memberProjectConsumeStat.getName());
            LOGGER.info("taskTolNum:"+memberProjectConsumeStat.getTaskTolNum());
            LOGGER.info("tolConsumedTime:"+memberProjectConsumeStat.getTolConsumedTime());
            LOGGER.info("tolEstimatedTime:"+memberProjectConsumeStat.getTolEstimatedTime());
            LOGGER.info("availTime:"+memberProjectConsumeStat.getAvailTime());
            LOGGER.info("tolStoryCount:"+memberProjectConsumeStat.getTolStoryCount());
            LOGGER.info("---------------------------------------------------");
        }
    }

    //项目成员工作情况统计功能
    @Test
    public void statTaskConsumedByMemberTest(){
        SummaryTimeParam timeParam =new SummaryTimeParam();
        LocalDate actualStart = timeParam.getStart(), actualEnd = timeParam.getEnd();
        List<ProjectProfileStat> projectProfileStats = statService.
                statProjectsByTime(actualStart, actualEnd);
        for (ProjectProfileStat projectProfileStat:projectProfileStats)
        {
            int projectID=projectProfileStat.getId();
            List<MemberProjectConsumeStat> memberProjectConsumeStats = statService
                    .statTaskByMember(projectID);
            LOGGER.info("---------------------------------------------------");
            for(MemberProjectConsumeStat memberProjectConsumeStat:memberProjectConsumeStats){
                LOGGER.info("project:"+projectID);
                LOGGER.info("name:"+memberProjectConsumeStat.getName());
                LOGGER.info("taskTolNum:"+memberProjectConsumeStat.getTaskTolNum());
                LOGGER.info("tolConsumedTime:"+memberProjectConsumeStat.getTolConsumedTime());
                LOGGER.info("tolEstimatedTime:"+memberProjectConsumeStat.getTolEstimatedTime());
                LOGGER.info("availTime:"+memberProjectConsumeStat.getAvailTime());
                LOGGER.info("tolStoryCount:"+memberProjectConsumeStat.getTolStoryCount());
                LOGGER.info("---------------------------------------------------");
            }
        }
    }

    //任务类型统计功能
    @Test
    public void consumedTimeByTypTest () {
        SummaryTimeParam timeParam =new SummaryTimeParam();
        LocalDate actualStart = timeParam.getStart(), actualEnd = timeParam.getEnd();
        List<ProjectProfileStat> projectProfileStats = statService.
                statProjectsByTime(actualStart, actualEnd);
        for (ProjectProfileStat projectProfileStat:projectProfileStats) {
            int projectID = projectProfileStat.getId();
            List<ProjectTaskConsumedStat> projectTaskConsumedStats = statService.statTaskByTyp(projectID);
            LOGGER.info("---------------------------------------------------");
            for(ProjectTaskConsumedStat projectTaskConsumedStat:projectTaskConsumedStats) {
                LOGGER.info("project:"+projectID);
                LOGGER.info("taskTyp:"+projectTaskConsumedStat.getTaskTyp());
                LOGGER.info("consumedTime:"+projectTaskConsumedStat.getConsumedTime());
                LOGGER.info("totalNum:"+projectTaskConsumedStat.getTotalNum());
                LOGGER.info("---------------------------------------------------");
            }
        }
    }

}
