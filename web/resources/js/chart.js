/**
 * Created by son on 2018-11-11.
 */

var chart = {
    drawChart: function (analyzeData) {
        if (!analyzeData) {
            return;
        }
        var data = google.visualization.arrayToDataTable(analyzeData);

        var options = {
            title: 'Network Monitoring',
            hAxis: {title: 'Time zone',  titleTextStyle: {color: '#333'}, viewWindow: { min: 0, max: 3}},
            vAxis: { viewWindow: { min: 0, max: 100}}
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
};

//TODO Ajax 호출 콜백 이용
//TODO 30초마다 차트 갱신, 함수로 빼야함
// google.charts.load('current', {'packages':['corechart']});
// google.charts.setOnLoadCallback(drawChart);
// var analyzeData = [['Contents', 'Listening', 'Established', 'Close_wait']];
// setInterval(function() {
//     var date = new Date();
//     var curTime = date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
//     var item = [];
//     item.push(curTime, timeWait, esta, close);
//     analyzeData.push(item);
//
//     drawChart(analyzeData);
//     if (analyzeData.length > 3) {
//         analyzeData.splice(1, 1)
//     }
// }, 1000);