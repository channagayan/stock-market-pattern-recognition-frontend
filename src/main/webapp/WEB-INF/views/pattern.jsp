
<%--
  /*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

  Date: 11/13/2014
  Time: 6:21 PM
  ARCANE Pattern Panel
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/currentPattern.js" type="text/javascript"></script>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Pattern</title>
    <link rel="stylesheet" type="text/css" href="/css/local.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
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
                            <span class="pull-right"  >${pattern.patternEnum}</span>
                            <span style="visibility: hidden;">${pattern.name}</span>

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