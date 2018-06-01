var percentageToolTip = function(unitname) {
  return {
    pointFormat: '{series.name}: <b>{point.percentage:.2f}%({point.y:0.2f} ' + unitname + ')</b>'
  };
}

/**
 * @param domID id
 * @param title title
 * @param yAxis see the doc of hightcharts
 * @param data { name: [{seriesName, value, yAxis}], ... }
*/
function renderColumnBar(domID, title, yAxis, data, tooltip) {
  if (!data ||!yAxis) {
    return
  }

  var cates = []
  // seriesname: {name, data: [[name, value]], yAxis}
  var actualData = {}
  for (var prop in data) {
    cates.push(prop)

    for(var i=0; i< data[prop].length; i++) {
      var ele = data[prop][i]
      var seriesName = ele.seriesName
      var seriesData = actualData[seriesName]
      if (undefined === seriesData) {
        seriesData = actualData[seriesName] = {
          name: seriesName,
          data: [],
          yAxis: ele.yAxis
        }

      }

      seriesData.data.push([
        prop, ele.value
      ])

    }

  }

  var series = []
  for (var prop in actualData) {
    series.push(actualData[prop])
  }

  Highcharts.chart(domID, {

      chart: {
          type: 'column'
      },
      tooltip: tooltip,

      title: {
          text: title
      },

      xAxis: {
          categories: cates,
          crosshair: true
      },

      yAxis: yAxis,

      plotOptions: {
          column: {
              borderRadius: 5
          }
      },

      series: series

  });

}

/**
 * @param domID id
 * @param title
 * @param data [{name: '', value: ''}, ...]
*/
function renderPie(domID, title, data, tooltip) {
  if (!data && 1>data.length) {
    return
  }

  var cates = []
  var actualData = []
  for (var i=0; i<data.length; i++) {
    var ele = data[i]
    cates.push(ele.name)
    actualData.push([ele.name, ele.value, false])
  }

  Highcharts.chart(domID, {

      title: {
          text: title
      },
      tooltip: tooltip,

      xAxis: {
          categories: cates
      },

      series: [{
          type: 'pie',
          allowPointSelect: true,
          keys: ['name', 'y', 'selected', 'sliced'],
          data: actualData,
          showInLegend: true
      }]
  });

}
