package org.zentao.mapper.stat;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectStoryMapper {

  Integer statStoryByProject(@Param("projectID") Integer projectID,
      @Param("storyStatus") List<String> storyStatus);
}
