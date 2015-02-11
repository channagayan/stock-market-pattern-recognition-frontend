<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/currentPattern.js" type="text/javascript"></script>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Pattern</title>
</head>
<body>
<div class="row">
    <div class="col-sm-12 col-md-4" style="width:50%;">
        <div id="alerts" class="panel">
            <div class="panel-heading">
                <h4 class="text-center" >Recent Patterns<span class="glyphicon glyphicon-user pull-right"></span></h4>
            </div>

            <div class="panel-body text-center" id="a">

                <ol class="list-group list-group-flush" id="patternList" style="max-height: 25em; overflow-y: auto;">

                    <c:forEach var="pattern" items="${patterns}">
                        <li class="list-group-item liitem" onclick="javaScript:loadSubGraph('${pattern.id}','${pattern.name}')">
                            <strong  class="pull-left">${pattern.timeStamp}:</strong>
                            <strong  style="visibility: hidden;">${pattern.id}:</strong>
                            <span style="visibility: hidden;">${pattern.stock}</span>
                            <span>${pattern.stockName}</span>
                            <span style="visibility: hidden;">${pattern.name}</span>
                            <span class="pull-right"  >${pattern.patternEnum}</span>

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

            <div class="panel-body text-center" id="SubPatternContainer">
                <%--<div id="patternContainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>--%>

            </div>

            <div class="panel-footer">
                <div class="row">

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>