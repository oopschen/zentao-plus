package org.zentao.mapper.gen;

import java.util.List;
import org.zentao.entity.gen.ZtTask;
import org.zentao.entity.gen.ZtTaskExample;

public interface ZtTaskMapper {
    long countByExample(ZtTaskExample example);

    List<ZtTask> selectByExampleWithBLOBs(ZtTaskExample example);

    List<ZtTask> selectByExample(ZtTaskExample example);

    ZtTask selectByPrimaryKey(Integer id);
}