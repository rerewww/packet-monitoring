<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en"><head><style>
  tr:hover td{
    background: #45E1E8;
  }
</style>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Dashboard Template for Bootstrap</title>

  <!-- Bootstrap core CSS -->
  <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

  <script type="text/javascript" src="/resources/js/packets.js"></script>
  <script type="text/javascript" src="/resources/js/style.js"></script>
  <script type="text/javascript" src="/resources/js/devices.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

  <!-- Custom styles for this template -->
  <link href="../../resources/css/dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Project name</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Dashboard</a></li>
        <li><a href="#">Settings</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Help</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="Search...">
      </form>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="/">Dashboard<span class="sr-only">(current)</span></a></li>
        <li id="devices"><a href="/viewDevices">Devices</a></li>
        <li><a href="#">Analytics</a></li>
        <li><a href="#">Export</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <div class="row placeholders" style="
">
        <div class="col-xs-6 col-sm-3 placeholder">

          <h4>Label</h4>
          <span class="text-muted">Something else</span>
        </div>
        <div class="col-xs-6 col-sm-3 placeholder">

          <h4>Label</h4>
          <span class="text-muted">Something else</span>
        </div>
        <div class="col-xs-6 col-sm-3 placeholder">

          <h4>Label</h4>
          <span class="text-muted">Something else</span>
        </div>

      </div>

      <div class="row placeholders">



        <div class="col-xs-6 col-sm-3 placeholder" style="
    width: 50%;
">
          <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="200x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDIwMCAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iIzM5REJBQyIvPjxnPjx0ZXh0IHg9Ijc0LjA1NDY4NzUiIHk9IjEwMCIgc3R5bGU9ImZpbGw6IzFFMjkyQztmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMHB0O2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjIwMHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true">
          <h4>Label</h4>
          <span class="text-muted">Something else</span>
        </div>
        <div class="col-xs-6 col-sm-3 placeholder" style="
    width: 50%;
">
          <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="200x200" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDIwMCAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjxkZWZzLz48cmVjdCB3aWR0aD0iMjAwIiBoZWlnaHQ9IjIwMCIgZmlsbD0iIzM5REJBQyIvPjxnPjx0ZXh0IHg9Ijc0LjA1NDY4NzUiIHk9IjEwMCIgc3R5bGU9ImZpbGw6IzFFMjkyQztmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMHB0O2RvbWluYW50LWJhc2VsaW5lOmNlbnRyYWwiPjIwMHgyMDA8L3RleHQ+PC9nPjwvc3ZnPg==" data-holder-rendered="true">
          <h4>Label</h4>
          <span class="text-muted">Something else</span>
        </div></div>

      <h4 class="sub-header">Packet Table</h4>
      <table class="table table-striped" style="
    margin-bottom: 0;">
        <thead>
        <tr>
          <th id='headerNum' style="width: 10%">Number</th>
          <th id='headerLa' style="width: 20%">LocalAddress</thi>
          <th id='headerRe' style="width: 20%">RemoteAddress</th>
          <th id='headerPr' style="width: 10%">Protocol</th>
          <th id='headerIn'>Info</th>
        </tr>
        </thead>

      </table><div class="table-responsive" style="
    height: 400px;
">

      <table id="packets" class="table table-striped">
        <tbody>
        </tbody>
      </table></div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<svg xmlns="http://www.w3.org/2000/svg" width="200" height="200" viewBox="0 0 200 200" preserveAspectRatio="none" style="visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs></defs><text x="0" y="10" style="font-weight:bold;font-size:10pt;font-family:Arial, Helvetica, Open Sans, sans-serif;dominant-baseline:middle">200x200</text></svg></body></html>