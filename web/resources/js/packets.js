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
        var packetElem = document.createElement('tr');
        renderer.packet.render(packetElem, result);

        packetElem.onclick = function() {
            var tcpContents = document.getElementById('tcpContents');
            var dumpContents = document.getElementById('dumpContents');

            var tcpLen = tcpContents.childElementCount;
            for (var i = 0; i < tcpLen; i++) {
                tcpContents.removeChild(tcpContents.firstChild);
            }

            var dumpLen = dumpContents.childElementCount;
            for (var j = 0; j < dumpLen; j++) {
                dumpContents.removeChild(dumpContents.firstChild);
            }

            var detailInfos = JSON.parse(window.event.target.parentElement.getAttribute('value'));
            renderer.tcp.render(detailInfos.tcpModel);
            renderer.dump.render(detailInfos.dump);
            viewStyle.setStyle(tcpContents, 'display', 'block');
            viewStyle.setStyle(dumpContents, 'display', 'block');
        }.bind(this);
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
    },

    download: function () {
        var downloadElem = document.getElementById('download');
        downloadElem.value = document.getElementById('hexDumpInfo').outerText;
    }
};