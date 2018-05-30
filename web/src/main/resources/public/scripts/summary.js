(function($) {
  var bindCalendar = function(id, toValueID) {
    $("#startdate").calendar({
      type: 'date',
      endCalendar: $('#enddate')
    });
  };

  $(document.body).ready(function() {
    var seriesTooltip = {
      pointFormat: '{series.name}: <b>{point.y}</b>'
    };
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

    renderColumnBar('project-summary', '项目总体情况', yAxis, projectSummary, seriesTooltip);

    var pieHrsTooltip = percentageToolTip('hrs');
    renderPie(
      'member-consumed-summary', '人员用时情况',
      memberConsumedSummary, pieHrsTooltip
    );

    var yAxis4Timerange = [{
      title: {
        text: '项目数'
      }
    }];

    renderColumnBar('project-timerange-summary', '项目周期统计', yAxis4Timerange, projectTimerangeSummary, seriesTooltip);


    bindCalendar();
  })
})(jQuery);
