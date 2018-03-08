package org.zentao.mapper.gen;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.zentao.entity.gen.ZtTeam;
import org.zentao.entity.gen.ZtTeamExample;

public interface ZtTeamMapper {
    long countByExample(ZtTeamExample example);

    List<ZtTeam> selectByExample(ZtTeamExample example);

    ZtTeam selectByPrimaryKey(@Param("project") Integer project, @Param("account") String account);
}