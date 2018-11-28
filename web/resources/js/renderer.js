/**
 * Created by son on 2018-11-28.
 */
var renderer = {
    packet: {
        render: function (packetElem, model) {
            var length = model.length;
            var elemPackets = document.getElementById('packets').children[0];
            for (var i = 0; i < length; i++) {
                var number = document.createElement('td');
                number.innerText = i;
                viewStyle.setStyle(number, 'width', '10%');

                var localAddress = document.createElement('td');
                localAddress.innerText = model[i].localAddress;
                viewStyle.setStyle(localAddress, 'width', '20%');

                var remoteAddress = document.createElement('td');
                remoteAddress.innerText = model[i].remoteAddress;
                viewStyle.setStyle(remoteAddress, 'width', '20%');

                var protocol = document.createElement('td');
                protocol.innerText = model[i].protocol;
                viewStyle.setStyle(protocol, 'width', '10%');

                var infoText = model[i].localPort + " -> " + model[i].remotePort + " [" + model[i].flag + "]" + " Length: " + model[i].size
                    + " ProcName: " + (!!model[i].processName ? model[i].processName : "off...");
                var info = document.createElement('td');
                info.innerText = infoText;

                detailInfos = {
                    dump: model[i].hexDump,
                    tcpModel: model[i].tcpModel
                };
                packetElem.setAttribute('value', JSON.stringify(detailInfos));
                if (model[i].protocol === 'Http') {
                    viewStyle.setStyle(packetElem, 'background-color', 'red');
                }

                packetElem.appendChild(number);
                packetElem.appendChild(localAddress);
                packetElem.appendChild(remoteAddress);
                packetElem.appendChild(protocol);
                packetElem.appendChild(info);

                elemPackets.appendChild(packetElem);
            }
        }
    },

    tcp: {
        render: function (model) {
            if (model === null) {
                return;
            }
            var details = document.getElementById('tcpContents');
            var summary = document.createElement('summary');
            summary.textContent = 'Transfer Control Procotol';
            details.appendChild(summary);

            var keys = Object.keys(model);
            keys.forEach(function (key) {
                var p = document.createElement('p');
                p.textContent = key + ': ' + model[key];
                details.appendChild(p);
            });
        }
    },

    dump: {
        render: function (text) {
            if (text === null) {
                return;
            }
            var details = document.getElementById('dumpContents');
            var summary = document.createElement('summary');
            var p = document.createElement('p');
            p.textContent = text;
            summary.textContent = 'Dump Contents';
            details.appendChild(summary);
            details.appendChild(p);
        }
    }
};
