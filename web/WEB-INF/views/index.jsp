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
    <script type="text/javascript" src="/resources/js/packets.js"></script>
    <script type="text/javascript" src="/resources/js/style.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
      body {
        background-color: #f4f3ef;
        width: 100%;
        height: 100%;
        overflow: hidden;
      }
      #main {
          padding: 20px;
      }
      .box {
        width: 260px;
        height: 150px;
        padding: 20px;
        background-color: white;
        margin-bottom: 30px;
        border-radius: 15px;
        box-shadow: 0px 3px 0px 0px #999;
      }
      .box.system {
        float: left;
      }
      .box.system.status {
        margin-left: 35px;
      }
      .box.footer {
        width: auto;
        clear: both;
        padding: 30px;
        margin-top: 20px;
        overflow-y:scroll;
      }

      .packet:hover {
        background-color: cornsilk;
      }
      .packet {
        padding: 3px;
      }
    </style>
  </head>
  <body>
  <div id="main">
    <div class="box system"></div>
      <div class="box system status"></div>
  <div id="chart" class="box footer"></div>
  <div id="packets" class="box footer"></div>
  </div>
  </body>

  <script type="text/javascript">
    var systemInfos = "${systemInfos}";
    var result = new Array();
    <c:forEach items="${totalPackets}" var="packet">
    var packet = new Object();
    packet.protocol = "${packet.protocol}";
    packet.localAddress = "${packet.localAddress}";
    packet.remoteAddress = "${packet.remoteAddress}";
    packet.flag = "${packet.flag}";
    result.push(packet);
    </c:forEach>

    viewStyle.setPacketsDivHeight();
    packets.startDetectPackets();
  </script>
</html>
