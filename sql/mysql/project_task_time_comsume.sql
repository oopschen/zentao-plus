set @projectID=89;

-- 按任务类型统计实际消耗时间和预计消耗时间
select
  sum(consumed) as consumedTime,
  sum(estimate) as estimatedTime,
  type
from zt_task t
where t.project = @projectID and deleted = '0'
group by type;

-- 按人统计实际消耗时间和预计消耗时间
select
  sum(consumed) as consumedTime,
  sum(estimate) as estimatedTime,
  t.finishedBy
from zt_task t
right join zt_team te on te.project = @projectID and te.account = t.finishedBy
where t.project = @projectID and deleted = '0'
group by t.finishedBy;
