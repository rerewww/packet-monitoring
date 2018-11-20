/**
 * Created by son on 2018-11-12.
 */
var packets = {
    removePackets: function () {
        var elemPackets = document.getElementById('packets').children[0];
        var LIMIT_CHILD_LENGTH = 100;
        if (elemPackets.childElementCount < LIMIT_CHILD_LENGTH) {
            return;
        }
        for (var i = 0; i < LIMIT_CHILD_LENGTH; i++) {
            elemPackets.removeChild(elemPackets.firstChild);
        }
    },

    showPackets : function (result) {
        var length = result.length;
        var elemPackets = document.getElementById('packets').children[0];
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
                dataType: 'json',
                success: function(response) {
                    if (response === null || response === undefined) {
                        console.warn('detecte packets is empty');
                        return;
                    }
                    packets.removePackets();
                    packets.showPackets(JSON.parse(response.data));
                    domControl.moveScroll();
                    chart.drawPacketChart(response.size);
                },
                error: function(response) {
                    console.warn('error occurred: ', response.responseText);
                }
            });
        }.bind(this), 3000);
    }
};