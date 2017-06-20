<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimas
  Date: 19.06.2017
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta>
    <title>Web task</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/main.css"/>"/>
</head>
<body>


<form name="loginForm" action="<c:url value='j_spring_security_check'/>" class="form-inline" method="post">

    <div class="form-group">
        <label for="exampleInputName2">Login</label>
        <input type="text" name="login" class="form-control" id="exampleInputName2" placeholder="">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail2">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputEmail2" placeholder="">
    </div>

    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />

    <a class = "btn btn-default" href="<c:url value="/registration"/>">registration</a>

    <input name="submit" value="login" type="submit" class="btn btn-default"/>

    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>

</form>


</body>
</html>
