/**
 * Created by son on 2018-11-19.
 */
var devices = {
    startCpuAmount: function () {
        if (!$('input[id=cpuCheck]').is(':checked')) {
            $('input[id=cpuCheck]').trigger('click');
        }

        setting.clearIdMap.cpuCheck = setInterval(function () {
            $.ajax({
                url: '/network/cpuAmount',
                type:'GET',
                async: true,
                dataType: 'json',
                success: function(response) {
                    if (response === null || response === undefined) {
                        console.warn('Failed get cpu amount');
                        return;
                    }
                    chart.drawCpucpuAmount(response.data);
                },
                error: function(response) {
                    console.warn('error occurred: ', response.responseText);
                }
            });
        }.bind(this), 5000);
    },

    addDevices : function (devices) {
        devices.forEach(function (device) {
            var item = document.createElement('div');
            item.className = 'col-xs-6 col-sm-3 placeholder';
            viewStyle.setStyle(item, 'float', 'none');

            var title = document.createElement('h4');
            title.innerText = device.name;

            var btn = document.createElement('button');
            btn.className = 'btn btn-default';
            btn.innerText = 'Accept';
            btn.id = device.id;
            btn.onclick = function () {
                this.selectDevice(btn.id);
            }.bind(this);
            viewStyle.setStyle(btn, 'margin-top', '5px');

            item.appendChild(title);
            item.appendChild(btn);
            document.getElementsByClassName("row placeholders")[0].appendChild(item);
        }.bind(this));
    },

    selectDevice: function (id) {
        $.ajax({
            url: '/network/selectDevice',
            type:'GET',
            async: true,
            data: {'id': id},
            dataType: 'text',
            success: function(response) {
                if (response === null || response === undefined) {
                    console.warn('detecte packets is empty');
                    return;
                }
                alert("Connected...");
            },
            error: function(response) {
                console.warn("error occurred : ", response);
            }
        });
    },

    checkDevice: function (id) {
        $.ajax({
            url: '/network/checkDevice',
            type:'GET',
            async: false,
            dataType: 'json',
            success: function(response) {
                if (response === null || response === undefined) {
                    console.warn('detecte packets is empty');
                    return;
                }
                if (!response.data) {
                    return;
                }
                packets.startDetectPackets(id);
            },
            error: function(response) {
                console.warn("error occurred : ", response.responseText);
            }
        });
    }
};
