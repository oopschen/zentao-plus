(function($) {
  $(document.body).ready(function() {
  $("#menu").foundation();

  var pieTooltip = percentageToolTip('hrs');
  var seriesTooltip = {
  pointFormat: '{series.name}: <b>{point.y}</b>'
};
  var pieNumPercentageTooltip = percentageToolTip('个');

  renderPie('task-type-pie', '任务类型耗时报表', taskTypStat, pieTooltip);
  renderPie('task-type-pie-num', '任务类型任务数报表', taskTypStatNum, pieNumPercentageTooltip);
  renderPie('project-story-charts', '需求完成度',
    projectStoryStat, pieNumPercentageTooltip);

  var yAxis = [{
    title: {
      text: '耗时'
    }
  }, {
    opposite: true,
      title: {
        text: '个数'
      }
  }];

  renderColumnBar('people-charts', '项目成员工作情况报表', yAxis, taskByMember, seriesTooltip);

  var timeUsageYAxis = [{
      title: {
        text: '时间利用率'
      }
  }];
  renderColumnBar('people-time-usage-charts', '项目成员工作时间利用率报表', timeUsageYAxis,
    timeUsageByMember, seriesTooltip);

  renderPie('project-time-usage-charts', '工程耗时', projectTimeUsage, pieTooltip);
});

})(jQuery);
