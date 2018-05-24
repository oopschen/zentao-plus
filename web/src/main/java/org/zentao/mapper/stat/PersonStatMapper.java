package org.zentao.mapper.stat;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zentao.entity.mybatis.MemberStoryStat;

public interface PersonStatMapper {

  List<MemberStoryStat> statMemberStoryCount(
      @Param("projectID") Integer projectID,
      @Param("storyStatus") List<String> storyStatus
  );
}
