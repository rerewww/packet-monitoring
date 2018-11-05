<%--
  Created by IntelliJ IDEA.
  User: son
  Date: 2018-10-28
  Time: 오후 6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
  <head>
    <title>네트워크 탐지기</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      var result = new Array();
      <c:forEach items="${totalPackets}" var="packet">
      var packet = new Object();
      packet.protocol = "${packet.protocol}";
      packet.status = "${packet.status}";
      result.push(packet);
      </c:forEach>

      var timeWait = 0;
      var esta = 0;
      var close = 0;
      result.forEach(function (item) {
        if (item.status === 'TIME_WAIT') {
          timeWait++;
        } else if (item.status === 'ESTABLISHED') {
          esta++;
        } else if (item.status === 'CLOSE_WAIT') {
          close++;
        }
      });

      //TODO Ajax 호출 콜백 이용
      //TODO 30초마다 차트 갱신, 함수로 빼야함
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      var analyzeData = [['Contents', 'Listening', 'Established', 'Close_wait']];
      setInterval(function() {
        var date = new Date();
        var curTime = date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
        var item = [];
        item.push(curTime, timeWait, esta, close);
        analyzeData.push(item);

        drawChart(analyzeData);
        if (analyzeData.length > 3) {
          analyzeData.splice(1, 1)
        }
      }, 1000);

      function drawChart(analyzeData) {
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
    </script>
  </head>
  <body>
  <p>총 연결 대기중: ${totalListen}</p>
  <p>총 연결 중: ${totalConnect}</p>
  <div id="chart_div" style="width: 100%; height: 500px;"></div>
  </body>
</html>
