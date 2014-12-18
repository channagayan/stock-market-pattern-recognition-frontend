<%--
  Created by IntelliJ IDEA.
  User: Rashmi
  Date: 11/13/2014
  Time: 5:47 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ARCANE</title>
    <link href='<c:url value="/css/bootstrap.css" />' rel="stylesheet" type="text/css"/>
    <link href='<c:url value="/css/bootstrap-theme.css" />' rel="stylesheet" type="text/css"/>
    <link href='<c:url value="/css/style.css" />' rel="stylesheet" type="text/css"/>
    <link href='<c:url value="/css/admin.css" />' rel="stylesheet" type="text/css"/>

    <script src='<c:url value="/js/jquery-1.10.2.min.js" />' type="text/javascript"></script>
</head>

<body>
<div class="container ">
    <div>
        <div id="adminlogin" class="panel panel-primary admin-login">

            <c:if test="${not empty error}">
                <div class="msg-box error">
                    <div class="ln">Username and password do not match</div>
                </div>
            </c:if>

            <div class="panel-heading">
                <h3 class="panel-title">Login</h3>
            </div>
            <div class="panel-body">
             <%--   <c:url value="/admin/j_spring_security_check" var="loginUrl"/>
             --%>
                <form class="form-horizontal" role="form" action="j_spring_security_check" method='POST'>
                    <div class="form-group">
                        <label for="username" class="col-sm-4 control-label">User Name</label>

                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="j_username" id="username"
                                   placeholder="User Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-4 control-label">Password</label>

                        <div class="col-sm-8">
                            <input type="password" class="form-control" name="j_password" id="password"
                                   placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-8">
                            <button type="submit" class="btn btn-primary">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>