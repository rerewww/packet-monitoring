/**
 * Created by son on 2018-11-28.
 */
var renderer = {
    packet: {
        render: function (model,onclick) {
            var length = model.length;
            var elemPackets = document.getElementById('packets').children[0];
            for (var i = 0; i < length; i++) {
                var packetElem = document.createElement('tr');
                packetElem.onclick = onclick;

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

                var infoText = model[i].localPort + " -> " + model[i].remotePort + (!!model[i].flag ? " [" + model[i].flag + "]" : "") + " Length: " + model[i].size
                    + " ProcName: " + (!!model[i].processName ? model[i].processName : "off...");
                var info = document.createElement('td');
                info.innerText = infoText;

                detailInfos = {
                    ethernetModel: model[i].ethernetModel,
                    ipModel: model[i].ipModel,
                    dump: model[i].hexDump
                };

                if (!!model[i].tcpModel) {
                    detailInfos.tcpModel = model[i].tcpModel;
                } else if (!!model[i].udpModel) {
                    detailInfos.udpModel = model[i].udpModel;
                }
                packetElem.setAttribute('value', JSON.stringify(detailInfos));

                packetElem.appendChild(number);
                packetElem.appendChild(localAddress);
                packetElem.appendChild(remoteAddress);
                packetElem.appendChild(protocol);
                packetElem.appendChild(info);

                elemPackets.appendChild(packetElem);
            }
        }
    },

    ethernet: {
        render: function (model) {
            if (model === null) {
                return;
            }
            var details = document.getElementById('ethernetContents');
            var summary = document.createElement('summary');
            summary.textContent = 'Ethernet';
            details.appendChild(summary);

            var keys = Object.keys(model);
            keys.forEach(function (key) {
                var p = document.createElement('p');
                p.textContent = key + ': ' + model[key];
                details.appendChild(p);
            });
        }
    },

    ip: {
        render: function (model) {
            if (model === null) {
                return;
            }
            var details = document.getElementById('ipContents');
            var summary = document.createElement('summary');
            summary.textContent = 'Internet Protocol';
            details.appendChild(summary);

            var keys = Object.keys(model);
            keys.forEach(function (key) {
                var p = document.createElement('p');
                p.textContent = key + ': ' + model[key];
                details.appendChild(p);
            });
        }
    },

    tcp: {
        render: function (model) {
            if (model === null) {
                return;
            }
            var details = document.getElementById('transport');
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

    udp: {
        render: function (model) {
            if (model === null) {
                return;
            }
            var details = document.getElementById('transport');
            var summary = document.createElement('summary');
            summary.textContent = 'User Datagram Procotol';
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
