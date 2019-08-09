package org.zentao.mapper.gen;

import java.util.List;
import org.zentao.entity.gen.ZtTask;
import org.zentao.entity.gen.ZtTaskExample;
import org.zentao.entity.mybatis.StatTaskByTypResult;
import org.zentao.entity.mybatis.StatTaskConsumedByMemberResult;

public interface ZtTaskMapper {

  long countByExample(ZtTaskExample example);

  List<ZtTask> selectByExampleWithBLOBs(ZtTaskExample example);

  List<ZtTask> selectByExample(ZtTaskExample example);

  ZtTask selectByPrimaryKey(Integer id);

//    以下是新增的接口,请勿覆盖

  /**
   * 根据人统计耗时
   *
   * @param example 条件
   * @return 结果
   */
  List<StatTaskConsumedByMemberResult> statTaskConsumedByMember(ZtTaskExample example);


  /**
   * 统计任务类型消耗
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskByTypResult> statTaskConsumedByTyp(ZtTaskExample example);

  /**
   * 统计任务类型数量
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskByTypResult> tolNumByTyp(ZtTaskExample example);

  /**
   * 统计任务类型消耗时间
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskByTypResult> consumedTimeByTyp(ZtTaskExample example);

  /**
   * 根据人统计工时耗时
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskConsumedByMemberResult> consumedTimeByMember(ZtTaskExample example);

  /**
   * 根据人统计任务数量
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskConsumedByMemberResult> taskNumByMember(ZtTaskExample example);
  /**
   * 根据人统计非团队任务预计耗时
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskConsumedByMemberResult> unGroupEstimatedTimeByMember(ZtTaskExample example);
  /**
   * 根据人统计团队任务预计耗时
   *
   * @param example 查询条件
   * @return 结果
   */
  List<StatTaskConsumedByMemberResult> groupEstimatedTimeByMember(ZtTaskExample example);
}