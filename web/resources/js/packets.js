/**
 * Created by son on 2018-11-12.
 */
var packets = {
    browserHeight : document.documentElement.clientHeight,
    showPackets : function (result) {
        var chartHeight = document.getElementById('chart').offsetHeight;
        var systemHeight = document.getElementsByClassName('box system')[0].offsetHeight;
        var maxHeight = this.browserHeight - (chartHeight + systemHeight);
        var length = result.length;
        for (var i = 0; i < length; i++) {
            var packetsHeight = document.getElementById('packets').offsetHeight + 120;
            if (packetsHeight > maxHeight) {
                console.log('div가 화면에 벗어나므로 패킷을 멈춥니다.');
                break;
            }
            var child = document.createElement('div');
            var packet = "[" + i + "] " + result[i].protocol + " " + result[i].localAddress + " " + result[i].remoteAddress + " " + result[i].flag;
            child.className = 'packet';
            child.innerText = packet;
            document.getElementById('packets').appendChild(child);
        }
    }
};