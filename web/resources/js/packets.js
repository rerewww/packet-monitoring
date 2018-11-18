/**
 * Created by son on 2018-11-12.
 */
var packets = {
    removePackets: function () {
        var elemPackets = document.getElementById('packets').children[0];
        var LIMIT_CHILD_LENGTH = 100;
        for (var i = 0; i < LIMIT_CHILD_LENGTH; i++) {
            elemPackets.removeChild(elemPackets.firstChild);
        }
    },

    showPackets : function (result) {
        var elemPackets = document.getElementById('packets').children[0];
        if (elemPackets.childElementCount > 100) {
            this.removePackets();
        }

        var length = result.length;
        for (var i = 0; i < length; i++) {
            var packet = document.createElement('tr');
            var number = document.createElement('td');
            number.innerText = i;
            viewStyle.setStyle(number, 'width', '10%');

            var localAddress = document.createElement('td');
            localAddress.innerText = result[i].localAddress;
            viewStyle.setStyle(localAddress, 'width', '20%');

            var remoteAddress = document.createElement('td');
            remoteAddress.innerText = result[i].remoteAddress;
            viewStyle.setStyle(remoteAddress, 'width', '20%');

            var protocol = document.createElement('td');
            protocol.innerText = result[i].protocol;
            viewStyle.setStyle(protocol, 'width', '10%');

            var infoText = result[i].localPort + " -> " + result[i].remotePort + " [" + result[i].flag + "]" + " Length: " + result[i].size;
            var info = document.createElement('td');
            info.innerText = infoText;

            packet.appendChild(number);
            packet.appendChild(localAddress);
            packet.appendChild(remoteAddress);
            packet.appendChild(protocol);
            packet.appendChild(info);

            elemPackets.appendChild(packet);
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
        }.bind(this), 3000);
    }
};