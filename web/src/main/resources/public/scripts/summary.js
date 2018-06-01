(function($) {
  var dateformat = 'YYYY-MM-DD';

  var bindCalendar = function() {
    var nowTemp = new Date();
    var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
    var start = $("#startdate").fdatepicker({
      format: 'yyyy-mm-dd',
      initialDate: initStartDate
    }).on('changeDate', function (ev) {
      start.hide();
      $('#start').val(moment(ev.date).format(dateformat));
      $('#enddate')[0].focus();
    }).data('datepicker');

    var end = $("#enddate").fdatepicker({
      format: 'yyyy-mm-dd',
      initialDate: initEndDate
    }).on('changeDate', function (ev) {
      end.hide();
      $('#end').val(moment(ev.date).format(dateformat));
    }).data('datepicker');
  };

  $(document.body).ready(function() {
    $("#menu").foundation();

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

    $('#submitBtn').click(function() {
      $('#form').submit();
    });

    $('input[type=radio][name=projectStatTimeRange]').change(function() {
      $('#form > #projectStatTimeRange').val(this.value);
      $('#form').submit();
    });

  })
})(jQuery);
