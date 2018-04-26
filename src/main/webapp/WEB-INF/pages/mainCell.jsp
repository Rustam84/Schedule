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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
            integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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

<div class="modal fade" id="cellInfo" tabindex="-1" role="dialog" aria-labelledby="headerLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="headerLabel">Детли ячейки</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="idInModal" style="display:none"></div>
                Преподаватель:
                <div id="lecturerInModal"></div>
                Предмет:
                <div id="subjectInModal"></div>
                Тип:
                <input id="typeInModal" type="text" class="form-control">
                Неделя:
                <select id="parityInModal" class="form-control">
                    <option value="0">пар и непар</option>
                    <option value="1">пар</option>
                    <option value="2">непар</option>
                </select>
                Группа:
                <div id="groupsInModal"></div>
                Кабинет:
                <div id="cabinetInModal"></div> <br />
                <div id="currentStatus"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                <button type="button" class="btn btn-primary" id="updateCellInfo">Сохранить изменения</button>
            </div>
        </div>
    </div>
</div>
<script src="../resources/js/scriptMainCell.js"></script>
</body>
</html>
