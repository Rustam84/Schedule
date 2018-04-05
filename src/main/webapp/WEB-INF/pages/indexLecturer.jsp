<%--
  Created by IntelliJ IDEA.
  User: rshaghivaliev
  Date: 3/27/2018
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lecturer</title>
    <style type="text/css">
        <%@include file="../resources/css/styleLecturer.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row">
        <h1>Таблица "Преподаватели"</h1>
    </div>
    <div class="row">
        <div class="col-3">
            <button class="btn btn-primary btn-lg btn-block" id="buttonShowLecturer">Просмотреть</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonAddLecturer">Добавить</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonUpdateLecturer">Редактировать</button>
            <br/>
            <button class="btn btn-primary btn-lg btn-block" id="buttonDeleteLecturer">Удалить</button>
            <br/>
            <form action="/">
                <button class="btn btn-danger btn-lg btn-block">Назад</button>
                <br/>
            </form>
        </div>
        <div class="col-9">
            <div id="blockLecturerShow">
            </div>
            <div id="blockLecturerAdd">
                <div class="alert alert-success fade show" id="successAdd">
                    <strong>Успех!</strong> Данные добавлены.
                </div>
                <form action="lecturer/add">
                    <div class="form-group">
                        <label for="surname">Введите фамилию преподавателя </label>
                        <input type="text" id="surname" name="surname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="name">Введите имя преподавателя </label>
                        <input type="text" id="name" name="name" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="addLecturer">Добавить</button>
            </div>
            <div id="blockLecturerUpdate">
                <div class="alert alert-success fade show" id="successUpdate">
                    <strong>Успех!</strong> Данные обновлены.
                </div>
                <div id="updateLecturerTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idUpdate">ID преподавателя </label>
                        <input type="text" id="idUpdate" name="id" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="surnameUpdate">Введите фамилию преподавателя </label>
                        <input type="text" id="surnameUpdate" name="surname" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="nameUpdate">Введите имя преподавателя </label>
                        <input type="text" id="nameUpdate" name="name" class="form-control">
                    </div>
                </form>
                <button class="btn btn-primary" id="updateLecturer">Обновить</button>
            </div>
            <div id="blockLecturerDelete">
                <div class="alert alert-success fade show" id="successDelete">
                    <strong>Успех!</strong> Данные удалены.
                </div>
                <div id="deleteLecturerTable"></div>
                <form>
                    <div class="form-group">
                        <label for="idDelete">ID преподавателя </label>
                        <input type="text" id="idDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="surnameDelete">Фамилия преподавателя </label>
                        <input type="text" id="surnameDelete" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nameDelete">Имя преподавателя </label>
                        <input type="text" id="nameDelete" class="form-control" readonly>
                    </div>
                </form>
                <button class="btn btn-primary" id="deleteLecturer">Удалить</button>
            </div>
        </div>
    </div>
</div>
<script>
    <%@include file="../resources/js/scriptLecturer.js"%>
</script>
</body>
</html>
