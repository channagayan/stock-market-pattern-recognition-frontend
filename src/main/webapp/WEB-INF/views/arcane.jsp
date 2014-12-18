<%--
  Created by IntelliJ IDEA.
  User: Rashmi
  Date: 11/13/2014
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="http://code.highcharts.com/highcharts.js" type="text/javascript"></script>
    <script src="http://code.highcharts.com/modules/exporting.js" type="text/javascript"></script>
    <script src="/js/liveChartWithWebsocket.js" type="text/javascript"></script>

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
                <li><a href="portfolio.html"><i class="fa fa-tasks"></i> Portfolio</a></li>
                <li><a href="blog.html"><i class="fa fa-globe"></i> Blog</a></li>
                <li><a href="signup.html"><i class="fa fa-list-ol"></i> SignUp</a></li>
                <li><a href="register.html"><i class="fa fa-font"></i> Register</a></li>
                <li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i> Bootstrap Grid</a></li>
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
                        <%--<div class="alert alert-success alert-dismissable">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            Welcome to the admin dashboard! Feel free to review all pages and modify the layout to your needs.
                            For the purpose of data visualization, additional widgets are used, so make sure you review all provided information.
                        </div>--%>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12 col-md-8">
                        <div id="graph" class="panel">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group">
                                            <select id="company"  multiple="multiple" placeholder="Company">
                                                <option value="1">Company ABC1 Pvt Ltd</option>
                                                <option value="2">Company ABC2 Pvt Ltd</option>
                                                <option value="3">Company ABC3 Pvt Ltd</option>
                                                <option value="4">Company ABC4 Pvt Ltd</option>
                                                <option value="5">Company ABC5 Pvt Ltd</option>
                                                <option value="6">Company ABC6 Pvt Ltd</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
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
                                    </div>
                                </div>
                            </div>

                            <div class="panel-body text-center">
                                <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
                            </div>

                            <div class="panel-footer">
                                <div class="row">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-md-4">
                        <div id="alerts" class="panel">
                                <div class="panel-heading">
                                    <h4 class="text-center">Recent Patterns<span class="glyphicon glyphicon-user pull-right"></span></h4>
                                </div>
                                <div class="panel-body text-center">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item liitem"><strong>Position:</strong>
                                            <span class="pull-right">Pattern 1</span>
                                        </li>
                                        <li class="list-group-item liitem"><strong>Company:</strong>
                                            <span class="pull-right">PAttern 2</span>
                                        </li>
                                        <li class="list-group-item liitem"><strong>Department:</strong>
                                            <span class="pull-right">Pattern 3</span>
                                        </li>
                                        <li class="list-group-item liitem"><strong>Project Duration:</strong>
                                            <span class="pull-right">Pattern 4</span>
                                        </li>
                                    </ul>
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
    <div class="row">
        <div class="col-lg-3">
            <div class="panel panel-default ">
                <div class="panel-body alert-info">
                    <div class="col-xs-5">
                        <i class="fa fa-truck fa-5x"></i>
                    </div>
                    <div class="col-xs-5 text-right">
                        <p class="alerts-heading">343</p>
                        <p class="alerts-text">New Orders</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="panel panel-default ">
                <div class="panel-body alert-info">
                    <div class="col-xs-5">
                        <i class="fa fa-money fa-5x"></i>
                    </div>
                    <div class="col-xs-5 text-right">
                        <p class="alerts-heading">17453</p>
                        <p class="alerts-text">Income</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="panel panel-default ">
                <div class="panel-body alert-info">
                    <div class="col-xs-5">
                        <i class="fa fa-twitter fa-5x"></i>
                    </div>
                    <div class="col-xs-5 text-right">
                        <p class="alerts-heading">743</p>
                        <p class="alerts-text">Mentions</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-3">
            <div class="panel panel-default ">
                <div class="panel-body alert-info">
                    <div class="col-xs-5">
                        <i class="fa fa-download fa-5x"></i>
                    </div>
                    <div class="col-xs-5 text-right">
                        <p class="alerts-heading">1453</p>
                        <p class="alerts-text">Downloads</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</div>
<script type="text/javascript" src="/js/arcane.js"></script>
</body>
</html>