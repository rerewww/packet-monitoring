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
    <script type="text/javascript" src="/resources/js/chart.js"></script>
    <script type="text/javascript">
      var result = new Array();
      <c:forEach items="${totalPackets}" var="packet">
      var packet = new Object();
      packet.protocol = "${packet.protocol}";
      packet.localAddress = "${packet.localAddress}";
      packet.remoteAddress = "${packet.remoteAddress}";
      packet.flag = "${packet.flag}";
      result.push(packet);
      </c:forEach>
    </script>
  </head>
  <body>
  <p>aaa</p>
  <div id="main">
    <div class="infos">
      <div id="system info">
        <table border="1" style="border-collapse: collapse; width: 100%;">
          <tbody>
          <tr>
            <td style="width: 26.938%;"></td>
            <td style="width: 73.062%;"></td>
          </tr>
          <tr>
            <td style="width: 26.938%;"></td>
            <td style="width: 73.062%;"></td>
          </tr>
          <tr>
            <td style="width: 26.938%;"></td>
            <td style="width: 73.062%;"></td>
          </tr>
          <tr>
            <td style="width: 26.938%;"></td>
            <td style="width: 73.062%;"></td>
          </tr>
          </tbody>
        </table>
      </div>
      <div id="total">2</div>
    </div>
    <div id="chart_div" style="width: 100%; height: 500px;">3</div>
  </div>
  <div id="packets">4</div>
  </body>
</html>
