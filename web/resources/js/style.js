/**
 * Created by son on 2018-11-13.
 */
var viewStyle = {
    setPacketsDivHeight: function () {
        var chartHeight = document.getElementById('chart').offsetHeight;
        var systemHeight = document.getElementsByClassName('box system')[0].offsetHeight;
        var maxHeight = document.documentElement.clientHeight - (chartHeight + systemHeight) - 180;
        this.setStyle(document.getElementById('packets'), 'height', maxHeight);
    },

    resizePacketsScroll: function () {
        var packets = document.getElementById('packets');
        packets.scrollTop = packets.scrollHeight;
    },

    setStyle: function (elem, key, value) {
        $(elem).css(key, value);
    }
};
