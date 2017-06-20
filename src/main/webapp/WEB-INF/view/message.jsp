<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimas
  Date: 20.06.2017
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Input form</title>
    <%--<link rel="stylesheet" href="<c:url value="/resources/main2.css"/>"/>--%>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"/>
</head>
<script>
    function saveComment(element, input) {
        var child = element.id;
        alert(input.value);
        $.ajax({
            url: 'http://localhost:8080/chat/message/comment',
            method: 'post',
            data:{messageId: element.id, commentMessage: "dfg"},
            complete:function () {
                location.reload();
            }
        })
    }
</script>
<body>
<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
<div class="form-group">
    <label for="inputlg">Message</label>
    <input class="form-control input-lg" id="message" type="text">
</div>


<button id="button" onclick="saveMessage()"  class="btn btn-success" type="submit">Send message</button>
    </div>
    <div class="col-lg-3"></div>
</div>
<div id="data" class="container">
<c:forEach var="message" items="${messages}">
<div  class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <output class="date">${message.date}</output>
        <output class="name">${message.user.firstName}</output>
        <output class="message">${message.text}</output>
        <label for="inputlg">Comment</label>
        <input name="in" id="${message.id}" class="form-control input-lg" id="inputlg" type="text">
        <button name="button" id="${message.id}" onclick="saveComment(this, this.previousSibling)" class="btn btn-default" type="submit">Send comment</button>
        <div class="row">
        <c:forEach var="comment" items="${message.commentList}">
            <div class="col-lg-3"></div>
            <div data-id="${message.id}" class="col-lg-9">
                <output class="date">${comment.date}</output>
                <output class="name">${comment.user.firstName}</output>
                <output class="message">${comment.text}</output>
            </div>
        </c:forEach>
        </div>
    </div>
    <div class="col-lg-3"></div>
</div>
</c:forEach>
</div>

</body>
<script
        src="https://code.jquery.com/jquery-3.2.1.js"
        integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
        crossorigin="anonymous"></script>
<script>
    function saveMessage() {
        $.ajax({
            url: 'http://localhost:8080/chat/message/create',
                method: 'post',
            data:{messageText: $('#message').val()},
            complete:function () {
                location.reload();
            }
        })
    }

    $('#data').on('click', '*', function() {
        var moo = $(this);
    });

</script>
</html>
