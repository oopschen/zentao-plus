package org.zentao.mapper.gen;

import java.util.List;
import org.zentao.entity.gen.ZtProject;
import org.zentao.entity.gen.ZtProjectExample;

public interface ZtProjectMapper {
    long countByExample(ZtProjectExample example);

    List<ZtProject> selectByExampleWithBLOBs(ZtProjectExample example);

    List<ZtProject> selectByExample(ZtProjectExample example);

    ZtProject selectByPrimaryKey(Integer id);
}