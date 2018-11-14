/**
 * Created by son on 2018-11-12.
 */
var packets = {
    removePackets: function () {
        var elemPackets = document.getElementById('packets');
        var LIMIT_CHILD_LENGTH = 100;
        for (var i = 0; i < LIMIT_CHILD_LENGTH; i++) {
            elemPackets.removeChild(elemPackets.firstChild);
        }
    },

    showPackets : function (result) {
        var elemPackets = document.getElementById('packets');
        if (elemPackets.childElementCount > 100) {
            this.removePackets();
        }

        var length = result.length;
        for (var i = 0; i < length; i++) {
            var child = document.createElement('div');
            var info = result[i].localPort + " -> " + result[i].remotePort + " [" + result[i].flag + "]" + " Length: " + result[i].size;
            var packet = "[" + i + "]　　　" + result[i].localAddress + "　　　" + result[i].remoteAddress + "　　　" + result[i].protocol + "　　　" + info;
            child.className = 'packet';
            child.innerText = packet;
            elemPackets.appendChild(child);
        }
    },

    startDetectPackets: function () {
        setInterval(function () {
            $.ajax({
                url: 'http://localhost:8080/detecting',
                type:'GET',
                async: true,
                dataType: 'text',
                success: function(data) {
                    if (data === null || data === undefined) {
                        console.warn('detecte packets is empty');
                        return;
                    }
                    packets.showPackets(JSON.parse(data));
                    viewStyle.resizePacketsScroll();
                },
                error: function(data) {
                    console.warn('error occurred: ', data.responseText);
                }
            });
        }.bind(this), 10000);
    }
};