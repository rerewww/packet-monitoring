/**
 * Created by son on 2018-11-12.
 */
var packets = {
  showPackets : function (result) {
      var length = result.length;
      var resultPackets = '';
      for (var i = 0; i < length; i++) {
          var packet = "[" + i + "] " + result[i].protocol + " " + result[i].localAddress + " " + result[i].remoteAddress + " " + result[i].flag;
          resultPackets += packet;
          if (result[i + 1] !== undefined) {
              resultPackets += '</br>';
          }
      }
      document.getElementById('packets').innerHTML = resultPackets;
  }
};