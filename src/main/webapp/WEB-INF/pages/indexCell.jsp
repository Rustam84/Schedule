<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 3/27/2018
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pair</title>
    <style type="text/css">
        <%@include file="../resources/css/styleCell.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Пары"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowCell">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddCell">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdateCell">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeleteCell">Удалить</button>
            <br/>
            <form action="mainCell">
                <fieldset class="form-group">
                    <legend></legend>
                    <button class="btn btn-primary btn-lg btn-block">Работа с ячейками</button> <br />
                </fieldset>
            </form>
            <form action="filterCell">
                <fieldset class="form-group">
                    <legend></legend>
                    <button class="btn btn-primary btn-lg btn-block">Фильтры для ячеек</button> <br />
                </fieldset>
            </form>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockCellShow">
            </div>
            <div id="blockCellAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form>
                    <div class="form-group">
                        <label>Выберите преподавателя</label>
                        <span id = "addLecturerList"></span>
                    </div>
                    <div class="form-group">
                        <label>Выберите предмет </label>
                        <span id = "addSubjectList"></span>
                    </div>
                    <div class="form-group">
                        <label>Введите группы </label>
                        <span id = "addGroupList"></span>
                    </div>
                </form>
                <button class="btn btn-primary" id="addCell">Добавить</button>
            </div>
            <div id="blockCellUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updatePairTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID ячейки</label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Выберите преподавателя</label>
                        <span id = "updateLecturerList"></span>
                    </div>
                    <div class="form-group">
                        <label>Выберите предмет </label>
                        <span id = "updateSubjectList"></span>
                    </div>
                    <div class="form-group">
                        <label>Введите группы </label>
                        <span id = "updateGroupList"></span>
                    </div>
                </form>
                <button class="btn btn-primary" id="updateCell">Обновить</button>
            </div>
            <div id="blockCellDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deleteCellTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID ячейки</label>
                        <input type="text" id="idDelete" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameDelete">Преподаватель</label>
                        <input type="text" id="nameDelete" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="subjectDelete">Предмет</label>
                        <input type="text" id="subjectDelete" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="groupsDelete">Группы</label>
                        <input type="text" id="groupsDelete" name="id" class="form-control" readonly>
                    </div>
                 </form>
                <button class="btn btn-primary" id="deleteCell">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptCell.js"%>
</script>
</body>
</html>
