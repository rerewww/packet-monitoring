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

            var infoText = result[i].localPort + " -> " + result[i].remotePort + " [" + result[i].flag + "]" + " Length: " + result[i].size
                + " ProcName: " + (!!result[i].processName ? result[i].processName : "off...");
            var info = document.createElement('td');
            info.innerText = infoText;

            packet.setAttribute('value', result[i].hexDump);
            if (result[i].protocol === 'Http') {
                viewStyle.setStyle(packet, 'background-color', 'red');
            }
            packet.onclick = function() {
                document.getElementById('hexDumpInfo').innerText = window.event.target.parentElement.getAttribute('value');
            }.bind(this);

            packet.appendChild(number);
            packet.appendChild(localAddress);
            packet.appendChild(remoteAddress);
            packet.appendChild(protocol);
            packet.appendChild(info);

            elemPackets.appendChild(packet);
        }
    },

    startDetectPackets: function (id) {
        if (!id) {
            if (!$('input[id=graphCheck]').is(":checked")) {
                $('input[id=graphCheck]').trigger('click');
            }
            if (!$('input[id=packetsCheck]').is(":checked")) {
                $('input[id=packetsCheck]').trigger('click');
            }
        }
        console.log("call detect");

        setting.clearIdMap.detectCheck = setInterval(function () {
            $.ajax({
                url: '/network/detect',
                type:'GET',
                async: true,
                data: { isProcName: $('input[id=procName]').is(":checked") },
                dataType: 'json',
                success: function(response) {
                    if (response === null || response === undefined) {
                        console.warn('detecte packets is empty');
                        return;
                    }
                    packets.removePackets();
                    if ($('input[id=packetsCheck]').is(":checked")) {
                        packets.showPackets(response.data);
                    }

                    domControl.moveScroll();

                    if ($('input[id=graphCheck]').is(":checked")) {
                        chart.drawPacketChart(response.size);
                    }
                },
                error: function(response) {
                    console.warn('error occurred: ', response.responseText);
                }
            });
        }.bind(this), 10000);
    }
};