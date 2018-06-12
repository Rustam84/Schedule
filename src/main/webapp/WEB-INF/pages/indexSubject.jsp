<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 3/27/2018
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject</title>
    <style type="text/css">
        <%@include file="../resources/static/css/styleSubject.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Предметы"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowSubject">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddSubject">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdateSubject">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeleteSubject">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockSubjectShow"></div>
            <div id="blockSubjectAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form>
                    <div class="form-group">
                        <label for="name">Введите название предмета </label>
                        <input type="text" id="name" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="abbreviation">Введите сокращённое нащвание предмета </label>
                        <input type="text" id="abbreviation" name="abbreviation" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="addSubject">Добавить</button>
            </div>
            <div id="blockSubjectUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updateSubjectTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID предмета </label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameUpdate">Введите название предмета </label>
                        <input type="text" id="nameUpdate" name="name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="abbreviationUpdate">Введите сокращённое название предмета </label>
                        <input type="text" id="abbreviationUpdate" name="abbreviation" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="updateSubject">Обновить</button>
            </div>
            <div id="blockSubjectDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deleteSubjectTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID предмета </label>
                        <input type="text" id="idDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameDelete">Название предмета </label>
                        <input type="text" id="nameDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="abbreviationDelete">Сокращённое название предмета </label>
                        <input type="text" id="abbreviationDelete" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary" id="deleteSubject">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/static/js/scriptSubject.js"%>
</script>
</body>
</html>
