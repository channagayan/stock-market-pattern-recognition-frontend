<%--
  Created by IntelliJ IDEA.
  User: Rashmi
  Date: 11/13/2014
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ARCANE</title>

    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/local.css" />
    <link rel="stylesheet" type="text/css" href="/css/multiple-select.css" />
    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.multiple.select.js"></script>
    <%--<script src="http://code.highcharts.com/highcharts.js" type="text/javascript"></script>--%>
    <script src="http://code.highcharts.com/stock/highstock.js"></script>
    <script src="http://code.highcharts.com/modules/exporting.js" type="text/javascript"></script>
    <script src="/js/liveChartWithWebsocket.js" type="text/javascript"></script>
    <script src="/js/currentPattern.js" type="text/javascript"></script>
    <script src="/js/arcane.js" type="text/javascript"></script>
    <script typ="text/javascript">
        function test() {
            alert("helo");
        }
    </script>

</head>

<body>

<div id="wrapper">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="arcane">ARCANE Dashboard</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li class="active"><a href="arcane"><i class="fa fa-bullseye"></i> Dashboard</a></li>
                <li><a href="javascript:getPatternPage('tripplebottom');"><i class="fa fa-tasks"></i> Tripple Bottom</a></li>
                <li><a href="javascript:getPatternPage('trippletop');"><i class="fa fa-globe"></i> Tripple Top</a></li>
                <li><a href="javascript:getPatternPage('headnshoulder');"><i class="fa fa-list-ol"></i> Head and Shoulder</a></li>
                <li><a href="javascript:getPatternPage('headnshoulderbottom');"><i class="fa fa-font"></i> Head and Shoulder Bottom</a></li>
                <li><a href="javascript:getPatternPage('doublebottom');"><i class="fa fa-font"></i> Double Bottom</a></li>
                <li><a href="javascript:getPatternPage('doubletop');"><i class="fa fa-list-ol"></i> Double Top</a></li>
                <%--<li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i> Bootstrap Grid</a></li>--%>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-user">
                <li class="dropdown messages-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Messages <span class="badge">2</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">2 New Messages</li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Security alert</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Security alert</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#">Go to Inbox <span class="badge">2</span></a></li>
                    </ul>
                </li>
                <li class="dropdown user-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Steve Miller<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                        <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
    <div id="page-wrapper">
        <div class="panel panel-default ">
            <div class="panel-body alert-info">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Dashboard <small>Dashboard Home</small></h2>

                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12 col-md-12">
                        <div id="graph" class="panel">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <select id="company"  multiple="multiple" placeholder="Company" >
                                                <option value="a">Company ABC1 Pvt Ltd</option>
                                                <option value="b">Company ABC2 Pvt Ltd</option>
                                                <option value="c">Company ABC3 Pvt Ltd</option>
                                                <option value="d">Company ABC4 Pvt Ltd</option>
                                                <option value="e">Company ABC5 Pvt Ltd</option>
                                                <option value="f">Company ABC6 Pvt Ltd</option>
                                            </select>
                                        </div>
                                    </div>
                                  <%--  <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <select id="pattern" multiple="multiple" placeholder="Pattern">
                                                <option value="1">Double - TOP</option>
                                                <option value="2">Double - BOTTOM</option>
                                                <option value="3">Head and Shoulder - TOP</option>
                                                <option value="4">Head and Shoulder - BOTTOM</option>
                                                <option value="5">Triple -  TOP</option>
                                                <option value="6">Triple - BOTTOM</option>
                                                <option value="7">Pending</option>
                                                <option value="8">Pending</option>
                                                <option value="9">Pending</option>
                                                <option value="10">Pending</option>
                                                <option value="11">Pending</option>
                                                <option value="12">Pending</option>
                                            </select>
                                        </div>
                                    </div>--%>
                                </div>
                            </div>

                            <div class="panel-body text-center">
                                <div id="container" style="min-width: 310px; height: 404px; margin: 0 auto"></div>
                            </div>

                            <div class="panel-footer">
                                <div class="row">

                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="col-sm-12 col-md-4" style="width:50%;">
                        <div id="alerts" class="panel">
                            <div class="panel-heading">
                                <h4 class="text-center" >Recent Patterns<span class="glyphicon glyphicon-user pull-right"></span></h4>
                            </div>

                            <div class="panel-body text-center" id="a">

                                <ol class="list-group list-group-flush" id="patternList" style="max-height: 25em; overflow-y: auto;">

                                    <c:forEach var="pattern" items="${patterns}">
                                        <li class="list-group-item liitem" onclick="javaScript:loadGraph('${pattern.id}','${pattern.name}')">
                                            <strong>${pattern.id}:</strong>
                                            <span>${pattern.stock}</span>
                                            <span class="pull-right"  >${pattern.name}</span>

                                        </li>
                                    </c:forEach>

                                </ol>
                            </div>

                            <div class="panel-footer">
                                <div class="row">

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-4" style="width:50%;">
                        <div id="patternNow" class="panel">
                            <div class="panel-heading">
                                <h4 class="text-center">Recent Patterns<span class="glyphicon glyphicon-user pull-right"></span></h4>
                            </div>

                            <div class="panel-body text-center" id="patternContainer">
                                <%--<div id="patternContainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>--%>

                            </div>

                            <div class="panel-footer">
                                <div class="row">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>

</div>
</div>
<div id="active">yes</div>
<script type="text/javascript" src="/js/arcane.js"></script>
</body>
</html>
