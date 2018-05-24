package org.zentao.mapper.gen;

import java.util.List;
import org.zentao.entity.gen.ZtProjectstory;
import org.zentao.entity.gen.ZtProjectstoryExample;

public interface ZtProjectstoryMapper {
    long countByExample(ZtProjectstoryExample example);

    List<ZtProjectstory> selectByExample(ZtProjectstoryExample example);
}