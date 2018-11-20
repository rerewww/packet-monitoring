/**
 * Created by son on 2018-11-20.
 */
var domControl = {
  moveScroll: function () {
      var divTable =document.getElementsByClassName('table-responsive')[0];
      divTable.scrollTop = divTable.scrollHeight;
  }
};