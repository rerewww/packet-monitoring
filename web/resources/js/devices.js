/**
 * Created by son on 2018-11-19.
 */
var devices = {
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
            url: 'http://localhost:8080/selectDevice',
            type:'GET',
            async: true,
            data: {'id': id},
            dataType: 'text',
            success: function(data) {
                if (data === null || data === undefined) {
                    console.warn('detecte packets is empty');
                    return;
                }
            },
            error: function(data) {
                alert("Connected...");
                packets.startDetectPackets();
                // console.warn("error occurred");
            }
        });
    }
};
