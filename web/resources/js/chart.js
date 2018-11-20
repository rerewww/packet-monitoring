var chart = {
    data: [],
    labels: [],
    drawPacketChart: function(packetsSize) {
        var ctx = document.getElementById("packetChart").getContext('2d');
        var date = new Date();
        var curTime = date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();

        this.data.push(packetsSize);
        this.labels.push(curTime);

        var myLineChart = new Chart(ctx, {
            type: 'line',
            data: {
                labels: this.labels,
                datasets: [{
                    label: 'Packet Count',
                    backgroundColor: '#ff0000',
                    borderColor: '#ff0000',
                    data: this.data,
                    fill: false
                }]
            },
            options: {
                maintainAspectRatio: false,
                responsive: true,
                title: {
                    display: true,
                    text: '실시간 패킷 분석'
                },
                tooltips: {
                    mode: 'index',
                    intersect: false
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '시간'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: '패킷(총 개수)'
                        }
                    }]
                }
            }
        });
    }
};