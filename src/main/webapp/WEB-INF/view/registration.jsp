<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimas
  Date: 19.06.2017
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/main.css"/>"/>
</head>
<body>
<c:url var="registerUrl" value="/register"/>
<form:form  modelAttribute="user" action="${registerUrl}" method="post"  class="form-inline">

    <div class="form-group">
        <label for="userLogin">Login</label>
        <form:input type="text" class="form-control" id="userLogin" placeholder="" path="login"/>
    </div>

    <div class="form-group">
        <label for="userName">Name</label>
        <form:input type="text" class="form-control" id="userName" placeholder="" path="firstName"/>
    </div>

    <div class="form-group">
        <label for="userSurname">Surname</label>
        <form:input type="text" class="form-control" id="userSurname" placeholder="" path="secondName"/>
    </div>

    <div class="form-group">
        <label for="userEmail">Email</label>
        <form:input type="email" class="form-control" id="userEmail" placeholder="" path="email"/>
    </div>

    <div class="form-group">
        <label for="userPassword">Password</label>
        <form:input type="password" class="form-control" id="userPassword" placeholder="" path="password"/>
    </div>


    <button type="submit" class="btn btn-default">register</button>



</form:form>

<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>
</body>
</html>
