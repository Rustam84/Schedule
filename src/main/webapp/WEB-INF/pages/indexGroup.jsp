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
    <title>Group</title>
    <style type="text/css">
        <%@include file="../resources/css/styleGroup.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Группы"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowGroup">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddGroup">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdateGroup">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeleteGroup">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockGroupShow">
            </div>
            <div id="blockGroupAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form>
                    <div class="form-group">
                        <label for="name">Введите название группы </label>
                        <input type="text" id="name" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="number">Введите количество студентов </label>
                        <input type="number" id="number" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        Выберите язык обучения группы
                        <div class="radio">
                            <label><input type="radio" name="language" value="RUS">Руский</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="language" value="ROM">Румынский</label>
                        </div>
                    </div>
                </form>
                <button class="btn btn-primary" id="addGroup">Добавить</button>
            </div>
            <div id="blockGroupUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updateGroupTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID группы </label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameUpdate">Введите название группы </label>
                        <input type="text" id="nameUpdate" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="numberUpdate">Введите количество студентов </label>
                        <input type="number" id="numberUpdate" name="number" class="form-control">
                    </div>
                    <div class="form-group">
                        Выберите язык обучения группы
                        <div class="radio">
                            <label><input type="radio" name="languageUpdate" value="RUS">Руский</label>
                        </div>
                        <div class="radio">
                            <label><input type="radio" name="languageUpdate" value="ROM">Румынский</label>
                        </div>
                    </div>
                </form>
                <button class="btn btn-primary" id="updateGroup">Обновить</button>
            </div>
            <div id="blockGroupDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deleteGroupTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID группы </label>
                        <input type="text" id="idDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameDelete">Название группы </label>
                        <input type="text" id="nameDelete" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary" id="deleteGroup">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptGroup.js"%>
</script>
</body>
</html>
