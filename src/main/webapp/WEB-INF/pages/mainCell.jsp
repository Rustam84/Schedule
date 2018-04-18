<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 4/17/2018
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Cell</title>
    <style type="text/css">
        <%@include file="../resources/css/styleMainCell.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-3 slider" ondrop="dropOnMain(event)" ondragover="allowDrop(event)">
            <div id="cells"></div>
        </div>
        <div class="col-md-9 slider">
            <div id="table"></div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptMainCell.js"%>
</script>
</body>
</html>
