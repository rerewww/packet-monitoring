/**
 * Created by son on 2018-12-04.
 */
var analytics = {
    setTables: function () {
        $.ajax({
            url: '/network/getRevisions',
            type:'GET',
            async: true,
            dataType: 'json',
            success: function(response) {
                if (response === null || response === undefined) {
                    console.warn('detecte packets is empty');
                    return;
                }

                var tbody = document.getElementsByTagName('tbody');
                for (var i = 0; i < response.data.length; i++) {
                    var number = document.createElement('td');
                    var localAddress = document.createElement('td');
                    var remoteAddress = document.createElement('td');
                    var protocol = document.createElement('td');
                    var info = document.createElement('td');
                    var tr = document.createElement('tr');

                    var num = String(i + 1);
                    number.textContent = num;
                    localAddress.textContent = response.data[i].localAddress;
                    remoteAddress.textContent = response.data[i].remoteAddress;
                    protocol.textContent = response.data[i].protocol;
                    info.textContent = response.data[i].info;

                    tr.appendChild(number);
                    tr.appendChild(localAddress);
                    tr.appendChild(remoteAddress);
                    tr.appendChild(protocol);
                    tr.appendChild(info);
                    tbody[0].appendChild(tr);
                }
            },
            error: function(response) {
                console.warn('error occurred: ', response.responseText);
            }
        });
    }
};