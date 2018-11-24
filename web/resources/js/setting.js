/**
 * Created by son on 2018-11-25.
 */
var setting = {
    clearIdMap : {
        cpuCheck: null,
        detectCheck: null
    },

    onToggleCpuEvent: function () {
        var id = window.event.srcElement.id;
        var isCheckedCpu = $('input[id=cpuCheck]').is(':checked');
        if (!isCheckedCpu) {
            clearInterval(this.clearIdMap[id]);
            this.clearIdMap.cpuCheck = null;
        } else if (this.clearIdMap.cpuCheck === null && isCheckedCpu){
            devices.startCpuAmount();
        }
    },

    onTogglePacketEvent: function () {
        var isCheckedPackets = $('input[id=packetsCheck]').is(':checked');
        var isCheckedGraph = $('input[id=graphCheck]').is(':checked');

        if (this.clearIdMap.detectCheck === null) {
            return;
        }

        if (!isCheckedPackets && !isCheckedGraph) {
            clearInterval(this.clearIdMap.detectCheck);
            this.clearIdMap.detectCheck = 'restart';
        }

        var id = window.event.srcElement.id;
        if (this.clearIdMap.detectCheck === 'restart' && (isCheckedPackets || isCheckedGraph)) {
            devices.checkDevice(id);
        }
    }
};
