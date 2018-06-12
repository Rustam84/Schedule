<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 4/18/2018
  Time: 6:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
    <style type="text/css">
        <%@include file="../resources/static/css/styleFilterCell.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="row" style="margin: 10px;">
    <div class="col-3">
        <div class="form-group">
            <label>Выберите преподавателя</label>
            <select class="form-control" id="lecturer"></select>
        </div>
        <div class="form-group">
            <label>Выберите группу</label>
            <select class="form-control" id="group"></select>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="showConflicts">
            <label class="form-check-label" for="showConflicts">
                Показывать конфликтные ячейки
            </label>
        </div>
    </div>
    <div class="col-9">
        <div id="header" class="h2"></div>
        <table class='table table-bordered' id="schedule"><thead></thead><tbody></tbody></table>
    </div>
</div>
<!--script>
    <%--@include file="../resources/js/scriptFilterCell.js"%--%>
</script-->
<script src="../resources/static/js/scriptFilterCell.js"></script>
</body>
</html>
